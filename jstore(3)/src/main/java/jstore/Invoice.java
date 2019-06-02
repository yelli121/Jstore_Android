package jstore;
/**
 * Ini adalah kelas Invoice. Kelas ini digunakan untuk
 * membuat invoice.
 * @author Yelli Yulfita
 * @version 31 mei 2019
 */
import java.util.Calendar;
import java.util.ArrayList;

public abstract class Invoice
{
    // instance variables - replace the example below with your own
    private int id;
    protected ArrayList<Integer> item;
    private Calendar date;
    protected int totalPrice;
    private boolean isActive;
    private Customer customer; 
    
    /**
     * Konstruktor untuk objek dari kelas Invoice
     */
    public Invoice(ArrayList<Integer> item)
    {
        // initialise instance variables
        this.item=item;
        int size=item.size();
        this.id=DatabaseInvoice.getLastInvoiceId()+1;
        this.setDate(Calendar.getInstance());
        this.date=getDate();
        //setTotalPrice(item.getPrice()*totalItem);
    }

    /**
     * Method getter untuk mengambil data
     *
     * @return    id
     */
    public int getId()
    {
        // put your code here
        return id;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    item
     */
    public ArrayList<Integer> getItem()
    {
        return item;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    date
     */
    public Calendar getDate()
    {
        return date;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    totalPrice
     */
    public int getTotalPrice()
    {
        return totalPrice;
    }
    
    public abstract InvoiceStatus getInvoiceStatus();
    
    public abstract InvoiceType getInvoiceType();
    
    public boolean getIsActive()
    {
        return isActive;
    }
    
    public Customer getCustomer()
    {
        return customer;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param id 
     */
    public void setId(int id)
    {
        this.id = id;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param item 
     */
    public void setItem(ArrayList<Integer> item)
    {
        this.item = item;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param date 
     */
    public void setDate(Calendar date)
    {
        this.date = date;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param totalPrice 
     */
    public void setTotalPrice(int totalPrice)
    {
        this.totalPrice = totalPrice;
    }
    
//    public void setInvoiceStatus(InvoiceStatus status)
//    {
//        this.status = status;
//    }
    
    public void setIsActive(boolean active)
    {
        isActive = active;
    }
    
    public abstract String toString();
}
