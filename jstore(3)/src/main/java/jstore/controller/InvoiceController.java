package jstore.controller;

import jstore.*;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class InvoiceController {
    @RequestMapping(value = "/invoicecustomer/{id_customer}", method = RequestMethod.GET)
    public ArrayList<Invoice> invoiceCust(@PathVariable int id_customer) {
        try {
            return DatabaseInvoice.getActiveOrder(DatabaseCustomerPostgre.getCustomer(id_customer));
        } catch (CustomerDoesntHaveActiveException e) {
            e.getExMessage();
            return null;
        }
    }

    @RequestMapping(value = "/invoice/{id_invoice}", method = RequestMethod.GET)
    public Invoice getInvoice(@PathVariable int id_invoice) {
        return DatabaseInvoice.getInvoice(id_invoice);
    }

    @RequestMapping(value = "/createinvoicepaid", method= RequestMethod.POST)
    public Invoice createInvoicePaid(@RequestParam(value="listitem") ArrayList<Integer> listItem,
                                     @RequestParam(value="idcustomer") int id_customer) {

        Invoice sp = new Sell_Paid(listItem, DatabaseCustomerPostgre.getCustomer(id_customer));
        try {
            DatabaseInvoice.addInvoice(sp);
        } catch (InvoiceAlreadyExistsException e) {
            e.getExMessage();
        }
        return sp;
    }

    @RequestMapping(value = "/createinvoiceunpaid", method= RequestMethod.POST)
    public Invoice createInvoiceUnpaid(@RequestParam(value="listitem") ArrayList<Integer> listItem,
                                       @RequestParam(value="idcustomer") int id_customer) {

        Invoice su = new Sell_Unpaid(listItem, DatabaseCustomerPostgre.getCustomer(id_customer));
        try {
            DatabaseInvoice.addInvoice(su);
        } catch (InvoiceAlreadyExistsException e) {
            e.getExMessage();
        }
        return su;
    }

    @RequestMapping(value = "/createinvoiceinstallment", method= RequestMethod.POST)
    public Invoice createInvoiceInstallment(@RequestParam(value="listitem") ArrayList<Integer> listItem,
                                            @RequestParam(value="durasiinstallment") int installment_period,
                                            @RequestParam(value="idcustomer") int id_customer) {

        Invoice si = new Sell_Installment(listItem, installment_period, DatabaseCustomerPostgre.getCustomer(id_customer));
        try {
            DatabaseInvoice.addInvoice(si);
        } catch (InvoiceAlreadyExistsException e) {
            e.getExMessage();
        }
        return si;
    }

    @RequestMapping(value = "/canceltransaction", method= RequestMethod.POST)
    public Invoice cancelTransaction(@RequestParam(value="idinvoice") int id_invoice) {
        Invoice inv = DatabaseInvoice.getInvoice(id_invoice);
        Transaction.cancelTransaction(DatabaseInvoice.getInvoice(id_invoice));
        return inv;
    }

    @RequestMapping(value = "/finishtransaction", method= RequestMethod.POST)
    public Invoice finishTransaction(@RequestParam(value="idinvoice") int id_invoice) {
        Transaction.finishTransaction(DatabaseInvoice.getInvoice(id_invoice));
        return DatabaseInvoice.getInvoice(id_invoice);
    }
}
