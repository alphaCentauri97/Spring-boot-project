package com.example.spring_security.Spring.Security.Practice.controller;

import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private record Product (Integer id, String product_name, double product_price){}

    List<Product> products = new ArrayList<>(List.of(new Product(1,"Iphone",999.0),
            new Product(2,"Mac Pro", 2099.0)));

    @GetMapping()
    public List<Product> getProducts(){
        return products;
    }

    @PostMapping()
    public Product saveProducts(@RequestBody Product product){
        products.add(product);
        return product;
    }

    @GetMapping("/csrf")
    public CsrfToken getToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
