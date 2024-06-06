package com.ra.controller;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.entity.Product;
import com.ra.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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
    public ResponseEntity<Page<Product>> index(
            @RequestParam(defaultValue = "0",name = "page") int page,
            @RequestParam(defaultValue = "2",name = "limit") int limit,
            @RequestParam(defaultValue = "ASC",name = "sort") String sort,
            @RequestParam(defaultValue = "id",name = "sortBy") String sortBy) {
        Pageable pageable;
        if(sort.equalsIgnoreCase("desc")){
            pageable = PageRequest.of(page,limit, Sort.by(sortBy).descending());
        } else {
            pageable = PageRequest.of(page,limit, Sort.by(sortBy).ascending());
        }
        Page<Product> products = productService.paginate(pageable);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @PostMapping("")
    public ResponseEntity<Product> create(@ModelAttribute ProductRequestDTO product){
        Product productNew = productService.saveOrUpdate(product);
        return new ResponseEntity<>(productNew,HttpStatus.CREATED);
    }
}
