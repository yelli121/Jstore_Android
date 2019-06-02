package jstore;
/**
 * Ini adalah kelas Supplier. Kelas ini digunakan untuk mendata
 * supplier dan hal-hal yang bersangkutan dengannya.
 * @author Yelli Yulfita
 * @version 31 mei 2019
 */
public class Supplier
{
    // instance variables - replace the example below with your own
    private int id;
    private String name;
    private String email;
    private String phoneNumber;
    private Location location;

    /**
     * Konstruktor untuk objek dari kelas Supplier
     */
    public Supplier(String name, String email, String phoneNumber, Location location)
    {
        // initialise instance variables
        this.id=DatabaseSupplier.getLastSupplierID()+1;
        this.name=name;
        this.email=email;
        this.phoneNumber=phoneNumber;
        this.location=location;
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
        return name;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    email
     */
    public String getEmail()
    {
        return email;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    phoneNumber
     */
    public String getPhoneNumber()
    {
        return phoneNumber;
    }
    
    /**
     * Method getter untuk mengambil data
     *
     * @return    location
     */
    public Location getLocation()
    {
        return location;
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
     * @param email 
     */
    public void setEmail(String email)
    {
        this.email = email;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param phoneNumber 
     */
    public void setPhoneNumber(String phoneNumber)
    {
        this.phoneNumber = phoneNumber;
    }
    
    /**
     * Method setter untuk menentukan data
     *
     * @param location 
     */
    public void setLocation(Location location)
    {
        this.location = location;
    }
    
    public String toString()
    {
        return "=============SUPPLIER=============="+"\nID: " +id+ "\nName: " +name+ "\nEmail: " +email+ "\nPhone Number: " +phoneNumber+ "\nLocation: "+location.getCity();
    }
}
