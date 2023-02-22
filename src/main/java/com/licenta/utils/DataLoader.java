package com.licenta.utils;

import com.licenta.category.Category;
import com.licenta.category.CategoryRepository;
import com.licenta.stock.StockRepository;
import com.licenta.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CategoryRepository categoryRepository;
    @Autowired
    private StockRepository stockRepository;

    @Override
    public void run(String... args) throws Exception {

    }
}
