package com.licenta.user;

import com.licenta.stock.Stock;
import com.licenta.utils.UserType;
import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
@Table(name="app_user")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String username;
    private String email;
    private String password;
    @Enumerated(EnumType.STRING)
    private UserType userType;

    @ManyToMany
    @JoinTable(
            name = "favorite_stock",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "stock_id")
    )
    private Set<Stock> favoriteStocks;

    public User(int id, String username, String email, String password, UserType userType, Set<Stock> favoriteStocks) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.userType = userType;
        this.favoriteStocks = favoriteStocks;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserType getUserType() {
        return userType;
    }

    public void setUserType(UserType userType) {
        this.userType = userType;
    }

    public Set<Stock> getFavoriteStocks() {
        return favoriteStocks;
    }

    public void setFavoriteStocks(Set<Stock> favoriteStocks) {
        this.favoriteStocks = favoriteStocks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id && Objects.equals(username, user.username) && Objects.equals(email, user.email) && Objects.equals(password, user.password) && userType == user.userType && Objects.equals(favoriteStocks, user.favoriteStocks);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, email, password, userType, favoriteStocks);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", userType=" + userType +
                ", favoriteStocks=" + favoriteStocks +
                '}';
    }
}
