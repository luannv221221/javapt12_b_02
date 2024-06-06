package com.ra.controller;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.entity.Product;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("")
    public ResponseEntity<List<Product>> index(){
        List<Product> products = productService.getAll();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Product> create(@ModelAttribute ProductRequestDTO product){
        Product productNew = productService.saveOrUpdate(product);
        return new ResponseEntity<>(productNew,HttpStatus.CREATED);
    }
}
