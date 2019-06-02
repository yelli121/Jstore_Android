package jstore.controller;

import jstore.DatabaseSupplier;
import jstore.Supplier;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
public class SupplierController {
    @RequestMapping(value = "/suppliers", method= RequestMethod.GET)
    public ArrayList<Supplier> suppliersList(){
        return DatabaseSupplier.getSupplierDatabase();
    }

    @RequestMapping(value = "/suppliers/{id_supplier}", method = RequestMethod.GET)
    public Supplier getSupplier(@PathVariable int id_supplier) {
        return DatabaseSupplier.getSupplier(id_supplier);
    }
}
