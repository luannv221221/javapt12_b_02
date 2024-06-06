package com.ra.service;

import com.ra.model.dto.ProductRequestDTO;
import com.ra.model.entity.Category;
import com.ra.model.entity.Product;
import com.ra.repository.CategoryRepository;
import com.ra.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ProductServiceImpl implements ProductService{
    private final ProductRepository productRepository;
    private final CategoryRepository categoryRepository;
    private final FileService fileService;
    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, CategoryRepository categoryRepository, FileService fileService) {
        this.productRepository = productRepository;
        this.categoryRepository = categoryRepository;
        this.fileService = fileService;
    }

    @Override
    public List<Product> getAll() {
        return productRepository.findAll();
    }

    @Override
    public Product saveOrUpdate(ProductRequestDTO product) {
        /*cachs 1 convert DTO => Entity
        Product productEntity = new Product();
        productEntity.setId(product.getId());
        productEntity.setProductName(product.getProductName());
        // xu ly upload anh
        productEntity.setImage("Anh");
        productEntity.setPrice(product.getPrice());
        // lay ve doi tuong danh mucj theo id
        Category category = categoryRepository.findById(product.getCategoryId()).orElse(null);
        */
        // xu ly upload file
        String image = fileService.uploadImage(product.getImage());
        Category category = categoryRepository.findById(product.getCategoryId()).orElse(null);
        Product productEntity = Product.builder()
                .id(product.getId())
                .productName(product.getProductName())
                .price(product.getPrice())
                .image(image).category(category)
                .build();
        productEntity.setCategory(category);
        return productRepository.save(productEntity);
    }

    @Override
    public Product findById(Long id) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Page<Product> paginate(Pageable pageable) {
        return productRepository.findAll(pageable);
    }
}
