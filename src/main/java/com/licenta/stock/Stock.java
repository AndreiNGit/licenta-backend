package com.licenta.stock;

import com.licenta.category.Category;
import com.licenta.order.Order;
import com.licenta.user.User;
import jakarta.persistence.*;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Entity
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int Id;
    private String name;
    private String symbol;
    private String model;
    private float[] price;
    private float[] predicted_price;
    @ManyToMany(mappedBy = "stocks")
    private List<Category> categories;



    public Stock(int id, String name, String symbol, String model, float[] price, float[] predicted_price, List<Category> categories) {
        Id = id;
        this.name = name;
        this.symbol = symbol;
        this.model = model;
        this.price = price;
        this.predicted_price = predicted_price;
        this.categories = categories;
    }

    public Stock() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public float[] getPrice() {
        return price;
    }

    public void setPrice(float[] price) {
        this.price = price;
    }

    public float[] getPredicted_price() {
        return predicted_price;
    }

    public void setPredicted_price(float[] predicted_price) {
        this.predicted_price = predicted_price;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public void setCategories(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "Id=" + Id +
                ", name='" + name + '\'' +
                ", symbol='" + symbol + '\'' +
                ", model='" + model + '\'' +
                ", price=" + Arrays.toString(price) +
                ", predicted_price=" + Arrays.toString(predicted_price) +
                ", categories=" + categories +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stock stock = (Stock) o;
        return Id == stock.Id && Objects.equals(name, stock.name) && Objects.equals(symbol, stock.symbol) && Objects.equals(model, stock.model) && Arrays.equals(price, stock.price) && Arrays.equals(predicted_price, stock.predicted_price) && Objects.equals(categories, stock.categories);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(Id, name, symbol, model, categories);
        result = 31 * result + Arrays.hashCode(price);
        result = 31 * result + Arrays.hashCode(predicted_price);
        return result;
    }
}
