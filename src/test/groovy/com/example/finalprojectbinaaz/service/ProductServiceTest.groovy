package com.example.finalprojectbinaaz.service

import com.example.finalprojectbinaaz.dao.entity.ProductEntity
import com.example.finalprojectbinaaz.dao.repository.ProductRepository
import com.example.finalprojectbinaaz.exception.NotFoundException
import com.example.finalprojectbinaaz.mapper.ProductMapper
import com.example.finalprojectbinaaz.model.ProductDto
import com.example.finalprojectbinaaz.model.ProductFilterDto
import com.example.finalprojectbinaaz.service.specification.FilterSpecification
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.springframework.data.domain.PageImpl
import org.springframework.data.domain.Pageable
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import spock.lang.Specification
import org.springframework.data.domain.Page

class ProductServiceTest extends Specification {
    private ProductRepository productRepository
    private ProductMapper productMapper
    private ProductService productService
    private JavaMailSender javaMailSender
    private FilterSpecification specification

    MimeMessageHelper mimeMessageHelper

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()


    void setup() {
        productRepository = Mock()
        productMapper = Mock()
        javaMailSender = Mock()
        specification = Mock(FilterSpecification)
        productService = new ProductService(productRepository, productMapper,
                javaMailSender, specification)
    }

    def "GetProducts successes"() {
        given:
        def pageable = Pageable.ofSize(10).withPage(1)
        def productFilterDto = new ProductFilterDto()
        def productEntityList = [random.nextObject(ProductEntity),
                                 random.nextObject(ProductEntity),
                                 random.nextObject(ProductEntity)]
        List<ProductDto> productDtoList = [random.nextObject(ProductDto),
                                         random.nextObject(ProductDto),
                                         random.nextObject(ProductDto)]
        def productPage = new PageImpl<>(productDtoList)

        when:
        def result = productService.getProducts(pageable, productFilterDto)
        then:
        1 * productService.specification.filterProduct(productFilterDto) >> specification
        1 * productRepository.findAll(specification, pageable) >> productPage
        1 * productMapper.mapEntityToDto(productEntityList) >> productDtoList

        result == productPage
    }



    def "GetProduct successes"() {
        given:
        Long productId = random.nextLong()
        ProductDto productDto = random.nextObject(ProductDto)
        ProductEntity productEntity = random.nextObject(ProductEntity)

        when:
        ProductDto result = productService.getProduct(productId)

        then:
        1 * productRepository.findById(productId) >> Optional.of(productEntity)
        1 * productMapper.mapEntityToDto(productEntity) >> productDto

         result == productDto
    }

    def "GetProduct ProductNotFound exception"() {
        given:
        Long productId = random.nextLong()

        when:
        ProductDto result = productService.getProduct(productId)

        then:
        1 * productRepository.findById(productId) >> Optional.empty()
        0 * productMapper.mapEntityToDto(_)

        def exception = thrown(NotFoundException)
        exception.message == "Product was not found with id " + productId

        result == null
    }

    def "SaveProduct successes"() {
        given:
        ProductDto productDto = random.nextObject(ProductDto)
        ProductEntity productEntity = random.nextObject(ProductEntity)

        when:
        productService.saveProduct(productDto)

        then:
        1 * productMapper.mapDtoToEntity(productDto) >> productEntity
        1 * productRepository.save(productEntity)
    }

    def "EditProduct successes"() {
        given:
        Long productId = random.nextLong()
        ProductEntity productEntity = random.nextObject(ProductEntity)
        ProductDto productDto = random.nextObject(ProductDto)

        when:
        productDto.setId(productId)
        productService.editProduct(productDto, productId)

        then:
        1 * productMapper.mapDtoToEntity(productDto, productId) >> productEntity
        1 * productRepository.save(productEntity) >> _
    }

    def "DeleteProduct successes"() {
        given:
        Long productId = random.nextLong()

        when:
        def result = productService.deleteProduct(productId)

        then:
        1 * productRepository.deleteById(productId)

        result == true
    }

//    def "test for sendEmail successes"(){
//        given:
//        String toEmail = "test@example.com"
//        String subject = "Test Subject"
//        String text = "Test Text"
//        MimeMessage mimeMessage = Mock(MimeMessage)
//        mimeMessageHelper = Mock(MimeMessageHelper)
//
//        when:
//        productService.sendEmail(toEmail, subject, text)
//
//        then:
//        1 * javaMailSender.createMimeMessage() >> mimeMessage
//        1 * mimeMessageHelper.setTo(toEmail)
//        1 * mimeMessageHelper.setSubject(subject)
//        1 * mimeMessageHelper.setText(text)
//        1 * javaMailSender.send(mimeMessage)
//
//    }
//
//    def "test for sendEmail exception"(){
//        given:
//        String toEmail = "test@example.com"
//        String subject = "Test Subject"
//        String text = "Test Text"
//        MimeMessage mimeMessage = Mock(MimeMessage)
//        mimeMessageHelper = Mock(MimeMessageHelper)
//
//        1 * javaMailSender.createMimeMessage() >> { throw new MessagingException("Test MessagingException") }
//
//        when:
//        try {
//            productService.sendEmail(toEmail, subject, text)
//        } catch (MessagingException e) {
//            e.getMessage()
//        }
//
//        then:
//        1 * javaMailSender.createMimeMessage()
//        0 * mimeMessageHelper.setTo(toEmail)
//        0 * mimeMessageHelper.setSubject(subject)
//        0 * mimeMessageHelper.setText(text)
//        0 * javaMailSender.send(mimeMessage)
//
//    }

}
