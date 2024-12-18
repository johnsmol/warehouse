package com.example.stock.entities;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;

import static jakarta.persistence.GenerationType.SEQUENCE;

@Getter
@Setter
@Entity
@ToString
@NoArgsConstructor
@Table(name = "shop_rules")
public class ShopRule {

    @Id
    @GeneratedValue(strategy = SEQUENCE)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "freeshop_id", nullable = false)
    private Freeshop freeshop;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Enumerated(EnumType.STRING)
    @Column(name = "rule_type", nullable = false)
    private RuleType ruleType; // RATIONING, DISCOUNT, etc.

    @Column(name = "value", nullable = false)
    private Double value; // E.g., 10 (rationing limit), 0.2 (20% discount)

    @Column(name = "start_date", nullable = true)
    private LocalDate startDate;

    @Column(name = "end_date", nullable = true)
    private LocalDate endDate;

    @Column(name = "description", nullable = true)
    private String description; // Optional explanation of the rule

    // ----- helper methods ----- //

    public enum RuleType {
        RATIONING, // Maximum units a customer can purchase
        DISCOUNT   // Percentage discount on the product price
    }
}
