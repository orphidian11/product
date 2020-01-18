package net.orphidian11.projects.cars.product.controller;

import net.orphidian11.projects.cars.product.domain.Product;
import net.orphidian11.projects.cars.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    ProductMapper productMapper;

    @RequestMapping("/all")
    public List<Product> all(){
        return productMapper.findAll();
    }
}
