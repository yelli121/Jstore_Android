package jstore;
/**
 * Write a description of class JStore here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JStore
{
    // instance variables - replace the example below with your own
    

    /**
     * Constructor for objects of class JStore
     */
    public static void main(String[] args)
    {
        Location loc = new Location("Depok", "Jawa Barat", "Kota");
//
        try {
            DatabaseSupplier.addSupplier(new Supplier("Alwi", "alwi@email.com", "02184305768", loc));
        } catch (SupplierAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
//        try {
//            DatabaseSupplier.addSupplier(new Supplier("Udin", "udin@email.com", "02184309876", loc));
//        } catch (SupplierAlreadyExistsException e) {
//            System.out.println(e.getExMessage());
//        }
//        try {
//            DatabaseSupplier.addSupplier(new Supplier("Meidi", "Meidi@email.com", "02184301234", loc));
//        } catch (SupplierAlreadyExistsException e) {
//            System.out.println(e.getExMessage());
//        }
//
        try {
            DatabaseItem.addItem(new Item("LED Strip", ItemStatus.New, 100000, DatabaseSupplier.getSupplier(1), ItemCategory.Electronics));
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        try {
            DatabaseItem.addItem(new Item("Desk", ItemStatus.Refurbished, 1000000, DatabaseSupplier.getSupplier(1), ItemCategory.Furniture));
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
        try {
            DatabaseItem.addItem(new Item("Calculator", ItemStatus.Second, 400000, DatabaseSupplier.getSupplier(1), ItemCategory.Stationery));
        } catch (ItemAlreadyExistsException e) {
            System.out.println(e.getExMessage());
        }
//        try {
//            DatabaseItem.addItem(new Item("Resistor", ItemStatus.Sold, 1000, DatabaseSupplier.getSupplier(1), ItemCategory.Electronics));
//        } catch (ItemAlreadyExistsException e) {
//            System.out.println(e.getExMessage());
//        }

        SpringApplication.run(JStore.class, args);
    }
    /**
     * An example of a method - replace this comment with your own
     *
     *    the sum of x and y
     */
    public JStore()
    {
        // put your code here
        
    }
   
}
