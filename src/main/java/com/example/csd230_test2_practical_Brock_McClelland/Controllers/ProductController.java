package com.example.csd230_test2_practical_Brock_McClelland.Controllers;

import com.example.csd230_test2_practical_Brock_McClelland.Entities.Product;
import com.example.csd230_test2_practical_Brock_McClelland.Repositories.ProductRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

@Controller
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @GetMapping
    public String listProducts(Model model) {
        model.addAttribute("products", productRepository.findAll());
        return "product-list";
    }

    @GetMapping("/new")
    public String showAddForm(Model model) {
        model.addAttribute("product", new Product());
        return "product-form";
    }

    @PostMapping
    public String saveProduct(@ModelAttribute Product product) {
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Product> product = productRepository.findById(id);
        if (product.isPresent()) {
            model.addAttribute("product", product.get());
            return "product-form";
        }
        return "redirect:/products";
    }

    @PostMapping("/update/{id}")
    public String updateProduct(@PathVariable Long id, @ModelAttribute Product product) {
        product.setId(id);
        productRepository.save(product);
        return "redirect:/products";
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable Long id) {
        productRepository.deleteById(id);
        return "redirect:/products";
    }
}