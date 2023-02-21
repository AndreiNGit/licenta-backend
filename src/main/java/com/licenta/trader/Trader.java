package com.licenta.trader;

import com.licenta.order.Order;
import com.licenta.stock.Stock;
import jakarta.persistence.*;

import java.util.Set;

@Entity
public class Trader {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private float invested;

    @OneToMany(mappedBy = "trader")
    private Set<Order> orders;

    @ManyToOne
    @JoinColumn(name="stock_id", referencedColumnName="id")
    private Stock stock;
}
