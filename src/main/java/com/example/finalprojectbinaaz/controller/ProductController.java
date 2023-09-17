package com.example.finalprojectbinaaz.controller;

import com.example.finalprojectbinaaz.dao.entity.ProductEntity;
import com.example.finalprojectbinaaz.model.ProductDto;
import com.example.finalprojectbinaaz.model.ProductFilterDto;
import com.example.finalprojectbinaaz.service.ProductService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/products_ad")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService productService;

    @Validated
    @GetMapping
    public Page<ProductDto> getProducts(Pageable pageable,
                                           ProductFilterDto productFilterDto){
        return productService.getProducts(pageable, productFilterDto);
    }

    @GetMapping("/{productId}")
    public ProductDto getProduct(@PathVariable Long productId){
        return productService.getProduct(productId);
    }

    @PostMapping
    public void saveProduct(@Valid @RequestBody ProductDto productDto){
        productService.saveProduct(productDto);
    }

    @PutMapping("/{productId}")
    public void editProduct(@RequestBody ProductDto productDto,
                            @PathVariable Long productId){
        productService.editProduct(productDto,productId);
    }

    @DeleteMapping("/{productId}")
    public boolean deleteProduct(@PathVariable Long productId){
        return productService.deleteProduct(productId);
    }
}
