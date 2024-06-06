package com.ra.service;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.entity.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product saveOrUpdate(ProductRequestDTO product);
    Product findById(Long id);
    void delete(Long id);
}
