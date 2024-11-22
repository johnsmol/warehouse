package com.example.stock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@Entity
@ToString(exclude = {"stockItems", "productPrices", "shopRules"})
@NoArgsConstructor
@Table(name = "freeshops")
public class Freeshop {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "address", nullable = false)
    private String address;

    @OneToMany(mappedBy = "freeshop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<StockItem> stockItems;

    @OneToMany(mappedBy = "freeshop", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<ProductPrice> productPrices;

    @OneToMany(mappedBy = "freeshop", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ShopRule> shopRules;

}
