package com.example.projeto;

import java.util.ArrayList;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;


@RestController 
@RequestMapping("/produtos")

public class ProductController {

    public List<Product> product = new ArrayList<>();

    //GET
    @GetMapping
    public List<Product> get(){

        return product;

    }

    //GET {ID}
    @GetMapping ({"id"})
    public Product get(@PathVariable Integer id){

        for (Product product : product) {
            if (product.getId().equals(id)) {
                return product;
            }
        }

        return null;

    }

    //POST
    @PostMapping
    public List<Product> post(@RequestBody Product newProduct){

        product.add(newProduct);
        return product;

    }

    //PUT
    @PutMapping("/{id}")
    public List<Product> put(@PathVariable Integer id, @RequestBody Product product){

        for (int i = 0; i < this.product.size(); i++) {
            if (this.product.get(i).getId().equals(id)) {
                product.setId(id);
                this.product.set(i, product);
            }
        }

        return this.product;

    }

    //DELETE
    @DeleteMapping("/{id}")
    public List<Product> delete(@PathVariable Integer id){
        
        for (int i = 0; i < this.product.size(); i++) {
            if (this.product.get(i).getId().equals(id)) {
                this.product.remove(i); 
                break; 
            }
        }

        return this.product; 
    }

}
