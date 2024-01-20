package org.example.security.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.security.model.Product;
import org.example.security.service.ProductService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
@Slf4j
public class ProductController {

    private final ProductService productService;

    @PreAuthorize("hasRole('PRODUCT_SELECT')")
    @GetMapping
    public List<Product> listAll(){
        return productService.listAll();
    }

    @PreAuthorize("hasRole('PRODUCT_INSERT')")
    @PostMapping
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @PreAuthorize("hasRole('PRODUCT_UPDATE')")
    @PutMapping
    public Product update(@RequestBody Product product){
        return productService.update(product);
    }

    @PreAuthorize("hasRole('PRODUCT_DELETE')")
    @DeleteMapping
    public void delete(@RequestParam("id") Long id){
        productService.delete(id);
    }
}
