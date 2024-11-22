package com.example.stock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Entity
@NoArgsConstructor
@ToString(exclude = "containedItems")
@Table(name = "stock_items")
public class StockItem {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "is_package", nullable = false)
    private boolean isPackage;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = true)
    private Product product;

    @Column(name = "expiration_date")
    private LocalDate expirationDate;

    @Column(name = "quantity", nullable = false)
    private Integer quantity = 1;

    // Self-referencing relationships for packages
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_package_id")
    private StockItem parentPackage;

    @OneToMany(mappedBy = "parentPackage", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StockItem> containedItems = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freeshop_id")
    private Freeshop freeshop;

}
