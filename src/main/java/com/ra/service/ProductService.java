package com.ra.service;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<Product> getAll();
    Product saveOrUpdate(ProductRequestDTO product);
    Product findById(Long id);
    void delete(Long id);
    Page<Product> paginate(Pageable pageable);
}
