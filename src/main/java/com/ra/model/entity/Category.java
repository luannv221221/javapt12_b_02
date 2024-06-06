package com.ra.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "categories")
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long categoryId;
    @Column(name = "category_name",length = 100)
    private String categoryName;
    @Column(name = "category_status")
    private Boolean categoryStatus;
    @JsonIgnore
    @OneToMany(mappedBy = "category",fetch = FetchType.LAZY)
    Set<Product> products;
}
