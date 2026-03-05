package com.example.demosecond;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@Controller
@ResponseBody
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    private EmployeeRepository empRep;


    @PostMapping("/store")
    public Employee storeEmployeeDetails(@RequestBody Employee emp){
        return empRep.save(emp);
    }

    @GetMapping("/show")
    public List<Employee> showAllData(){
        return empRep.findAll();
    }


    @GetMapping("/specificemployee/{id}")
    public Employee showSpecific(@PathVariable int id){
//        Optional<Employee> obj = empRep.findById(id);
     Optional<Employee> user = empRep.findById(id);
        if(user.isPresent()) {
            return (user.get());
        }
        return null;

    }
    @DeleteMapping("/delete/{id}")
    public String deteleEmp(@PathVariable int id){
        Employee emp = showSpecific(id);
        try {
            String name = emp.getName();
            empRep.delete(emp);
            return name+" got Deleted";
        } catch (Exception e){
            return "User "+id+" Not Found - 404";
        }
    }
    @PutMapping("update/{id}")
    public String updateEmp(@PathVariable int id, @RequestBody Employee emp){
        Employee existEmp = showSpecific(id);
        System.out.println(emp);
        if(emp.getEmail()!=null){
            existEmp.setEmail(emp.getEmail());
        }
        if(emp.getPassword()!=null){
            existEmp.setPassword(emp.getPassword());
        }
        empRep.save(existEmp);
        System.out.println(existEmp);
        return existEmp.getId()+" Has been Updated!";
    }
}






