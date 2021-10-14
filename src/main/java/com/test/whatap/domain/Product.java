package com.test.whatap.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 30, nullable = false)
    private String title;

    @Column(length = 10, nullable = false)
    private int price;

    @Builder
    public Product(String title, int price) {
        this.title = title;
        this.price = price;
    }

    public void update(String title, int price) {
        this.title = title;
        this.price = price;
    }
}
