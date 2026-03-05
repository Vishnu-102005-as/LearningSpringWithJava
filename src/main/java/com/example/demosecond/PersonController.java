package com.example.demosecond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/person")
public class PersonController {
    @Autowired
    private PersonRepository perRepo;

    @PostMapping("/store")
    public Person storePerson(@RequestBody Person per) {
        return perRepo.save(per);
    }

    @GetMapping("/show")
    public List<Person> showPerson() {
        return perRepo.findAll();
    }

    @GetMapping("/specificperson/{id}")
    public Person getSpecificPerson(@PathVariable int id) {
        Optional<Person> ps = perRepo.findById(id);
        if (ps.isPresent()) {
            return ps.get();
        } else {
            return null;
        }
    }
}












