package com.licenta.order;

import com.licenta.trader.Trader;
import com.licenta.utils.OrderType;
import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

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

    public Order(int id, OrderType type, float price, float quantity, Date date, Trader trader) {
        this.id = id;
        this.type = type;
        this.price = price;
        this.quantity = quantity;
        this.date = date;
        this.trader = trader;
    }

    public Order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public OrderType getType() {
        return type;
    }

    public void setType(OrderType type) {
        this.type = type;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getQuantity() {
        return quantity;
    }

    public void setQuantity(float quantity) {
        this.quantity = quantity;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Trader getTrader() {
        return trader;
    }

    public void setTrader(Trader trader) {
        this.trader = trader;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Order order = (Order) o;
        return id == order.id && Float.compare(order.price, price) == 0 && Float.compare(order.quantity, quantity) == 0 && type == order.type && Objects.equals(date, order.date) && Objects.equals(trader, order.trader);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, price, quantity, date, trader);
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", type=" + type +
                ", price=" + price +
                ", quantity=" + quantity +
                ", date=" + date +
                ", trader=" + trader +
                '}';
    }
}
