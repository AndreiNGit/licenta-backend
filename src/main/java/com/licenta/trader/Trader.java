package com.licenta.trader;

import com.licenta.order.Order;
import com.licenta.stock.Stock;
import jakarta.persistence.*;

import java.util.Objects;
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

    public Trader(int id, float invested, Set<Order> orders, Stock stock) {
        this.id = id;
        this.invested = invested;
        this.orders = orders;
        this.stock = stock;
    }

    public Trader() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getInvested() {
        return invested;
    }

    public void setInvested(float invested) {
        this.invested = invested;
    }

    public Set<Order> getOrders() {
        return orders;
    }

    public void setOrders(Set<Order> orders) {
        this.orders = orders;
    }

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trader trader = (Trader) o;
        return id == trader.id && Float.compare(trader.invested, invested) == 0 && Objects.equals(orders, trader.orders) && Objects.equals(stock, trader.stock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, invested, orders, stock);
    }

    @Override
    public String toString() {
        return "Trader{" +
                "id=" + id +
                ", invested=" + invested +
                ", orders=" + orders +
                ", stock=" + stock +
                '}';
    }
}
