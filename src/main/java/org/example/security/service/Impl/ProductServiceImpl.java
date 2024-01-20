package org.example.security.service.Impl;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.example.security.model.Product;
import org.example.security.repository.ProductRepository;
import org.example.security.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    public List<Product> listAll() {
        return productRepository.findAll();
    }

    @Override
    public Product create(Product product) {
        if(product.getId() != null){
            throw new RuntimeException("To create a record, you cannot have an ID");
        }

        return productRepository.save(product);
    }

    @Override
    public Product update(Product product) {
        if(product.getId() == null){
            throw new RuntimeException("To update a record, you must have an ID");
        }

        return productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }
}