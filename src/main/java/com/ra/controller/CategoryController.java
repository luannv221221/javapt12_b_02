package com.ra.controller;

import com.ra.model.entity.Category;
import com.ra.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/categories")
public class CategoryController {
    @Autowired
    private CategoryService categoryService;
    @GetMapping("")
    public ResponseEntity<List<Category>> index(){
        List<Category> categories = categoryService.getAll();
        return new ResponseEntity<>(categories, HttpStatus.OK);
    }
}
