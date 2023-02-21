package com.licenta.order;

import com.licenta.trader.Trader;
import com.licenta.utils.OrderType;
import jakarta.persistence.*;
import java.util.Date;

@Entity
@Table(name = "trader_order" )
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private OrderType type;
    private float price;
    private float quantity;

    @Temporal(TemporalType.TIMESTAMP)
    private Date date;

    @ManyToOne
    @JoinColumn(name = "trader_id" )
    private Trader trader;
}
