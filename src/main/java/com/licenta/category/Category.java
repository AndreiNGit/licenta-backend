package com.licenta.category;

import com.licenta.stock.Stock;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "category_stock",
            joinColumns = @JoinColumn(name = "category_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id")
    )
    private List<Stock> stocks;

    public Category(int id, String name, List<Stock> stocks) {
        this.id = id;
        this.name = name;
        this.stocks = stocks;
    }

    public Category() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Stock> getStocks() {
        return stocks;
    }

    public void setStocks(List<Stock> stocks) {
        this.stocks = stocks;
    }

    @Override
    public String toString() {
        return "Category{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", stocks=" + stocks +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id && Objects.equals(name, category.name) && Objects.equals(stocks, category.stocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, stocks);
    }
}
