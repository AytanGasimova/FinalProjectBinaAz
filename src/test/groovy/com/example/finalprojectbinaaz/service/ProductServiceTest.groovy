package com.example.finalprojectbinaaz.service

import com.example.finalprojectbinaaz.dao.entity.ProductEntity
import com.example.finalprojectbinaaz.dao.repository.ProductRepository
import com.example.finalprojectbinaaz.exception.NotFoundException
import com.example.finalprojectbinaaz.mapper.ProductMapper
import com.example.finalprojectbinaaz.model.ProductDto
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import spock.lang.Specification

class ProductServiceTest extends Specification {
    private ProductRepository productRepository
    private ProductMapper productMapper
    private ProductService productService

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()


    void setup() {
        productRepository = Mock()
        productMapper = Mock()
        productService = new ProductService(productRepository, productMapper)
    }

    def "GetProducts successes"() {

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
}
