package net.orphidian11.projects.cars.product.controller;

import net.orphidian11.projects.cars.product.domain.Product;
import net.orphidian11.projects.cars.product.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private List<Product> products = new ArrayList<Product>();

    /* @Autowired
    ProductMapper productMapper; */

    //  initialize
    {
        products.add(new Product(1, "City", "Economy Sedan", 1, new Date()));
        products.add(new Product(2, "Civic", "Sports Sedan", 1, new Date()));
        products.add(new Product(3, "Accord", "Luxury Sedan", 1, new Date()));
        products.add(new Product(4, "CR-V", "SUV", 1, new Date()));
        products.add(new Product(5, "HR-V", "Subcompact Crossover", 1, new Date()));
    }

    /**
     * List all products
     * @return
     */
    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public ResponseEntity<List<Product>> all(){
        return new ResponseEntity<List<Product>>(products, HttpStatus.OK);
    }

    /**
     * Add a new product
     * @param product
     * @return
     */
    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public ResponseEntity<Product> add(@RequestBody Product product){
        products.add(product);

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    } 

    /**
     * Edit an existing product
     * @param product
     * @param id
     * @return
     */
    @RequestMapping(value = "/edit/{id}", method = RequestMethod.POST)
    public ResponseEntity<Product> edit(@RequestBody Product product, @PathVariable Integer id){
        Product targetProduct = products.stream()
            .filter(prod -> prod.getId().equals(id))
            .findAny()
            .orElse(null);

        products.remove(products.indexOf(targetProduct));
        products.add(product);
        
        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }

    /**
     * Delete an existing product
     * @param id
     * @return
     */
    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<String> delete(@PathVariable Integer id){
        Product targetProduct = products.stream()
            .filter(prod -> prod.getId().equals(id))
            .findAny()
            .orElse(null);

        products.remove(products.indexOf(targetProduct));

        return new ResponseEntity<String>("successfully deleted!", HttpStatus.OK);
    }

    /**
     * Get an existing product
     * @return
     */
    @RequestMapping(value = "/find/{id}", method = RequestMethod.GET)
    public ResponseEntity<Product> find(@PathVariable Integer id){
        Product product = products.stream()
            .filter(prod -> prod.getId().equals(id))
            .findAny()
            .orElse(null);

        return new ResponseEntity<Product>(product, HttpStatus.OK);
    }
}
