package com.example.finalprojectbinaaz.controller

import com.example.finalprojectbinaaz.model.ProductDto
import com.example.finalprojectbinaaz.model.ProductFilterDto
import com.example.finalprojectbinaaz.service.ProductService
import io.github.benas.randombeans.EnhancedRandomBuilder
import io.github.benas.randombeans.api.EnhancedRandom
import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import spock.lang.Specification

class ProductControllerTest extends Specification {
    private ProductService productService
    private ProductDto productDto
    private Page<ProductDto> productDtoPage
    private ProductController productController

    private EnhancedRandom random = EnhancedRandomBuilder.aNewEnhancedRandom()

    void setup() {
        productService = Mock()
        productController = new ProductController(productService)

    }

    def "ProductController GetProducts method successes"() {
        given:
        def pageable = Pageable.unpaged()
        def productFilterDto = random.nextObject(ProductFilterDto)

        when:
        def result = productController.getProducts(pageable, productFilterDto)

        then:
        1 * productService.getProducts(pageable, productFilterDto) >> productDtoPage

        result == productDtoPage

    }

    def "ProductController GetProduct method successes"() {
        given:
        Long productId = random.nextLong()

        when:
        def result = productController.getProduct(productId)

        then:
        1 * productService.getProduct(productId) >> productDto

        result == productDto

    }

    def "ProductController SaveProduct method successes"() {
        given:
        productDto = random.nextObject(ProductDto)

        when:
        productController.saveProduct(productDto)

        then:
        1 * productService.saveProduct(productDto)

    }

    def "ProductController EditProduct method successes"() {
        given:
        productDto = random.nextObject(ProductDto)
        Long productId = random.nextLong()

        when:
        productController.editProduct(productDto, productId)

        then:
        1 * productService.editProduct(productDto, productId)

    }

    def "ProductController DeleteProduct method successes"() {
        given:
        Long productId = random.nextLong()

        when:
        def result = productController.deleteProduct(productId)

        then:
        1 * productService.deleteProduct(productId) >> true

        result == true

    }
}
