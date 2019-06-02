package jstore;
/**
 * Ini adalah kelas Item. Kelas ini digunakan untuk mendata
 * barang dan hal-hal yang bersangkutan dengannya.
 * @author Yelli Yulfita
 * @version 31 mei 2019
 */
public class Item
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private int price;
    private ItemCategory category;
    private ItemStatus status;
    private Supplier supplier;

    /**
     * Konstruktor untuk objek dari kelas Item
     */
    public Item(String name, ItemStatus status, int price, Supplier supplier, ItemCategory category)
    {
        // initialise instance variables
        this.id=DatabaseItem.getLastItemID()+1;
        this.name=name;
        this.status=status;
        this.price=price;
        this.supplier=supplier;
        this.category=category;
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
     * @return    name
     */
    public String getName()
    {
        return this.name;
    }

    /**
     * Method getter untuk mengambil data
     *
     * @return    price
     */
    public int getPrice()
    {
        return this.price;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    category
     */
    public ItemCategory getCategory()
    {
        return this.category;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    supplier
     */
    public Supplier getSupplier()
    {
        return this.supplier;
    }
    
    public ItemStatus getStatus()
    {
        return this.status;
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
     * @param name 
     */
    public void setName(String name)
    {
        this.name = name;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param price 
     */
    public void setPrice(int price)
    {
        this.price = price;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param category 
     */
    public void setCategory(ItemCategory category)
    {
        this.category = category;
    }
    
    public void setStatus(ItemStatus status)
    {
        this.status = status;
    }
    
    public void setSupplier(Supplier supplier)
    {
        this.supplier = supplier;
    }
    
    public String toString()
    {
        return "ID: " +id+ "\nName: " +name+ "\nPrice: " +price+ "\nCategory: " +category+ "\nStatus: " +status+ "\nSupplier: " +supplier;
    }
}
