package com.example.demosecond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/seller")
public class SellerController {

    @Autowired
    private SellerRepository selRepo;

    @PostMapping("/store")
    public Seller storeSeller(@RequestBody Seller seller){
        return selRepo.save(seller);
    }

    @GetMapping("/getseller")
    public List<Seller> getSeller(){
        return selRepo.findAll();
    }

    @GetMapping("/getSpecificSeller/{id}")
    public Seller getSellerById(@PathVariable int id){
        Optional<Seller> sel = selRepo.findById(id);
        if(sel.isPresent()){
            return sel.get();
        }
        else return null;
    }
}










