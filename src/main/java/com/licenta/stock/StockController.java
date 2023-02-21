package com.licenta.stock;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/stock")
public class StockController {
    private StockRepository stockRepository;

    public StockController(StockRepository stockRepository) {
        this.stockRepository = stockRepository;
    }

    @GetMapping
    public List<Stock> getAll() {
        return stockRepository.findAll();
    }

    @GetMapping("{id}")
    public ResponseEntity<Object> getById(@PathVariable int id) {
        Optional<Stock> optionalStock = stockRepository.findById(id);
        if(optionalStock.isPresent()) {
            return ResponseEntity.ok(optionalStock.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
