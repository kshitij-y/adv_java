package com.example.ProductApp.Controller;


import com.example.ProductApp.Model.Product;
import com.example.ProductApp.Service.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/products")
@SessionAttributes("product")
public class ProductController {

    @Autowired
    private ProductService productService;

    @GetMapping("/home")
    public String home() {
        return "home";
    }

    @GetMapping("/list")
    public String showProducts(Model model) {
        model.addAttribute("products", productService.getAllProduct());
        return "product-list";
    }

    @GetMapping("/add")
    public String addProductForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping("/save")
    public String saveProduct(@Valid @ModelAttribute Product product,
                              BindingResult result,
                              SessionStatus status
    ) {
        if(result.hasErrors()){
            return "product-form";
        }
        productService.addProduct(product);
        status.setComplete();
        return "redirect:/products/list";
    }

    @GetMapping("/edit/{id}")
    public String editProduct(@PathVariable("id") Long id, Model model) {
        model.addAttribute("product", productService.getProductById(id));
        return "product-form";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable("id") Long id) {
        productService.deleteProductById(id);
        return "redirect:/products/list";
    }

    @GetMapping("/count")
    @ResponseBody
    public String getProductCount() {
        return "Total product: " + productService.getAllProduct().size();
    }

    @SuppressWarnings("unused")
    @ExceptionHandler(RuntimeException.class)
    public String handleRuntimeException(RuntimeException ex, Model model){
        model.addAttribute("errorMessage", "Error : -> " + ex.getMessage());
        return "error-page";
    }
}
