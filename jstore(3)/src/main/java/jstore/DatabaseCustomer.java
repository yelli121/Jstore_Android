package jstore;
/**
 * Write a description of class DatabaseCustomer here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class DatabaseCustomer
{
    // instance variables - replace the example below with your own
    private final static ArrayList<Customer> CUSTOMER_DATABASE=new ArrayList<>();
    private static int LAST_CUSTOMER_ID=0;

    /**
     * An example of a method - replace this comment with your own
     *
     */
    public static ArrayList<Customer> getCustomerDatabase()
    {
        return CUSTOMER_DATABASE;
    }
    
    public static int getLastCustomerID()
    {
        return LAST_CUSTOMER_ID;
    }
    
    public static boolean addCustomer(Customer customer) throws CustomerAlreadyExistsException
    {
        // put your code here
        boolean success = true;
        for(Customer object : CUSTOMER_DATABASE)
        {
            if(object.getUsername().equals(customer.getUsername()) || object.getEmail().equals(customer.getEmail()))
            {
                throw new CustomerAlreadyExistsException(object);
            }
            else
            {
                success = true;
            }
        }
        if (success)
        {
            CUSTOMER_DATABASE.add(customer);
            LAST_CUSTOMER_ID = customer.getId();
        }
        return success;
    }
    
    public static Customer getCustomer(int id)
    {
        Customer value = null;
        for(Customer object : CUSTOMER_DATABASE)
        {
            if(object.getId() == id)
            {
                value = object;
                break;
            }
        }
        return value;
    }
    
    public static boolean removeCustomer(int id) throws CustomerNotFoundException
    {
        Customer value = null;
        int index;
        boolean success = false;
        for(Customer object : CUSTOMER_DATABASE)
        {
            if(object.getId() == id)
            {
                value = object;
                index = CUSTOMER_DATABASE.indexOf(value);
                CUSTOMER_DATABASE.remove(index);
                success = true;
                break;
            }
        }
        throw new CustomerNotFoundException(id);
    }

    public static Customer getCustomerLogin(String email, String password)
    {
        Customer value = null;
        for(Customer object : CUSTOMER_DATABASE)
        {
            if(object.getEmail() == email && object.getPassword() == password)
            {
                value = object;
                break;
            }
        }
        return value;
    }
}
