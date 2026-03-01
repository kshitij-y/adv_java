package com.example.ProductApp.Controller;


import com.example.ProductApp.Model.Product;
import com.example.ProductApp.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/products")
public class ProductRestController {

    @Autowired
    private ProductService productService;

    // Get all Product
    @GetMapping("/list")
    public List<Product> showProduct(){
        return productService.getAllProduct();
    }

    // Add a product
    @PostMapping("/save")
    public ResponseEntity<Map<String, Object>> saveProduct(@RequestBody Map<String, Object> req){
        String name = req.get("name").toString();
        double price = Double.parseDouble(req.get("price").toString());
        int quantity = Integer.parseInt(req.get("quantity").toString());

        Product product = new Product();
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        productService.addProduct(product);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of(
                        "message", "Product created",
                        "product", product
                ));
    }

    //Delete a product
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Map<String, Object>> deleteProduct(@PathVariable Long id) {

        productService.deleteProductById(id);

        return ResponseEntity.status(204)
                .body(Map.of(
                        "message", "deleted"
                ));
    }

    //edit a Product
    @PostMapping("/edit/{id}")
    public ResponseEntity<Map<String, Object>> editProduct(@RequestBody Map<String, Object> req, @PathVariable long id){
        //Long id = Long.parseLong(req.get("id").toString());
        String name = req.get("name").toString();
        double price = Double.parseDouble(req.get("price").toString());
        int quantity = Integer.parseInt(req.get("quantity").toString());

        Product product = new Product();
        product.setId(id);
        product.setName(name);
        product.setPrice(price);
        product.setQuantity(quantity);

        productService.addProduct(product);

        return ResponseEntity.status(201)
                .body(Map.of(
                        "message", "Product updated",
                        "product", product
                ));
    }

    // Get product By id
    @GetMapping("/{id}")
    public ResponseEntity<Map<String, Object>> getProduct(@PathVariable long id) {

        return ResponseEntity.status(201)
                .body(Map.of("product: ",productService.getProductById(id)));

    }

    // ExceptionHandler for this controller
    @SuppressWarnings("unused")
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex){
        return "Error: " + ex.getMessage();
    }

}
