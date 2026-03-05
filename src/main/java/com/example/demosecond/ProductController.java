package com.example.demosecond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductRepository prodRepo;

    @GetMapping("/getall")
    public List<Product> getAllProducts(){
        return prodRepo.findAll();
    }

    @GetMapping("/getSpecificProduct/{id}")
    public Product getSpecificProduct(@PathVariable int id){
        Optional<Product> prod = prodRepo.findById(id);
        if(prod.isPresent()){
            return prod.get();
        }
        else return null;
    }

}









