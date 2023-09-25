package com.example.finalprojectbinaaz.service;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.dao.repository.ProductRepository;
import com.example.finalprojectbinaaz.exception.NotFoundException;
import com.example.finalprojectbinaaz.mapper.ProductMapper;
import com.example.finalprojectbinaaz.model.ProductDto;
import com.example.finalprojectbinaaz.model.ProductFilterDto;
import com.example.finalprojectbinaaz.service.specification.*;
import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final JavaMailSender javaMailSender;
    private final FilterSpecification specification;


    public Page<ProductDto> getProducts(Pageable pageable,
                                        ProductFilterDto productFilterDto){
        log.info("ActionLog.getProducts.start");
        var specificationFilter = specification.filterProduct(productFilterDto);

        var products = productRepository.findAll(specificationFilter,pageable)
                        .stream().map(productMapper::mapEntityToDto)
                        .collect(Collectors.toList());
        log.info("ActionLog.getProducts.end");
        return new PageImpl<>(products);
    }

    public ProductDto getProduct(Long id){
        log.info("ActionLog.getProduct.start");
        ProductEntity productEntity =productRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Product was not found with id " + id)
        );
        log.info("ActionLog.getProduct.end");
        return productMapper.mapEntityToDto(productEntity);
    }

    public void saveProduct(ProductDto productDto){
        log.info("ActionLog.saveProduct.start");
        productRepository.save(productMapper.mapDtoToEntity(productDto));
        log.info("ActionLog.saveProduct.end");
    }

    public void editProduct(ProductDto productDto, Long id){
        log.info("ActionLog.editProduct.start");
        productDto.setId(id);
        productRepository.save(productMapper.mapDtoToEntity(productDto,id));
        log.info("ActionLog.editProduct.end");
    }

    public boolean deleteProduct(Long id){
        log.info("ActionLog.deleteProduct.start");
        productRepository.deleteById(id);
        log.info("ActionLog.deleteProduct.end");
        return true;
    }

   public void sendEmail(String toEmail, String subject, String text) throws MessagingException {
        MimeMessage message = javaMailSender.createMimeMessage();
        MimeMessageHelper helper;

        helper = new MimeMessageHelper(message);
        helper.setTo(toEmail);
        helper.setSubject(subject);
        helper.setText(text);

        javaMailSender.send(message);
    }
}
