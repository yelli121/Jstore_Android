package jstore;
/**
 * Write a description of class Sell_Unpaid here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.*;
import java.util.ArrayList;
import java.text.SimpleDateFormat;

public class Sell_Unpaid extends Invoice
{
    // instance variables - replace the example below with your own
    private static final InvoiceType INVOICE_TYPE=InvoiceType.Sell;
    private static final InvoiceStatus INVOICE_STATUS=InvoiceStatus.Unpaid;
    private Calendar dueDate;
    private Customer customer;
//    private boolean isActive;
    
    /**
     * Constructor for objects of class Sell_Unpaid
     */
    public Sell_Unpaid(ArrayList<Integer> item, Customer customer)
    {
        // initialise instance variables
        super(item);
        this.customer=customer;
        this.dueDate = Calendar.getInstance();
        dueDate.add(Calendar.DATE,1);
        super.setIsActive(true);
        int total = 0;
        for(int id : item){
            Item temp = DatabaseItem.getItemFromID(id);
            int priceTemp = temp.getPrice();
            total += priceTemp;
        }
        super.totalPrice = total;
    }

    /**
     * An example of a method - replace this comment with your own
     * @return    the sum of x and y
     */
   public InvoiceStatus getInvoiceStatus()
    {
        // put your code here
        return INVOICE_STATUS;
    }
    
    public InvoiceType getInvoiceType()
    {
        return INVOICE_TYPE;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    public Calendar getDueDate()
    {
        return dueDate;
    }
    
    public void setCustomer(Customer customer)
    {
        this.customer=customer;
    }
    
    public void setDueDate(Calendar dueDate)
    {
        this.dueDate=dueDate;
    }
    
    public String toString()
    {
        StringBuilder total = new StringBuilder();
        total.append("===============INVOICE===============\n");
        for(int i : item){
            Item temp = DatabaseItem.getItemFromID(i);
            String stringTemp = null;
            if (temp != null) {
                stringTemp = temp.toString();
                total.append(stringTemp);
            }
            total.append("\n");
        }
//        total.append("\nCustomer: ").append(customer.getName());
//        int price = this.getTotalPrice();
//        total.append("\nTotal price = ").append(price);
//        total.append("\n"+this.isActive());
        return total.toString();
    }
}
