package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.Calendar;

@RestController
public class CustomerController {

    @RequestMapping("/")
    public String indexPage(@RequestParam(value="name", defaultValue="world") String name) {
        return "Hello " + name;
    }

    @RequestMapping(value = "/newcustomer", method= RequestMethod.POST)
    public Customer newCust(@RequestParam(value="name") String name,
                            @RequestParam(value="email") String email,
                            @RequestParam(value="username") String username,
                            @RequestParam(value="password") String password,
                            @RequestParam(value="birthyear", required=false) Integer year) {
        if(year==null){
            year=1999;
        }
        else{
            year=year;
        }
        Customer customer = new Customer(name, email, username, password, year, 10, 10);
        try {
            DatabaseCustomerPostgre.insertCustomer(customer);
        } catch(Exception ex) {
            ex.getMessage();
            return null;
        }

        return customer;
    }

    @RequestMapping("/getcustomer/{id}")
    public Customer getCust(@PathVariable int id) {
        Customer customer = DatabaseCustomerPostgre.getCustomer(id);
        return customer;
    }

    @RequestMapping(value = "/logincust", method= RequestMethod.POST)
    public Customer loginCust(@RequestParam(value="email") String email,
                              @RequestParam(value="password") String password) {

        for(Customer cust:DatabaseCustomerPostgre.getCustomerDatabase()){
            if(cust.getEmail().equals(email)&&cust.getPassword().equals(password)){
                return cust;
            }
        }
        return null;
    }

}