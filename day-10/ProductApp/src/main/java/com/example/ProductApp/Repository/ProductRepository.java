package com.example.ProductApp.Repository;

import com.example.ProductApp.Model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository {
    private final List<Product> productList = new ArrayList<>();
    private Long idCounter = 1L;

    public List<Product> findAll(){
        return productList;
    }

    public void save(Product product){
        if(product.getId() == null){
            product.setId(idCounter++);
            productList.add(product);
        } else {
            update(product);
        }
    }

    public Optional<Product> findById(Long id) {
        return productList.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteById(long id) {
        productList.removeIf(p -> p.getId().equals(id));
    }

    private void update(Product updatedProduct) {
        productList.stream()
                .filter(p -> p.getId().equals(updatedProduct.getId()))
                .findFirst()
                .ifPresent(existing -> {
                    existing.setName(updatedProduct.getName());
                    existing.setPrice(updatedProduct.getPrice());
                    existing.setQuantity(updatedProduct.getQuantity());
                });
    }



}
