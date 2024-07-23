package com.inteswitchmiddleware.digitalmiddleware.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

@Entity
@Getter
@Setter
public class Biller {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private BillCategory category;

    @OneToMany(mappedBy = "biller", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Set<Product> products;
}
