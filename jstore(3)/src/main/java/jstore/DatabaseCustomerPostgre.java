package jstore;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class DatabaseCustomerPostgre {
    public static boolean insertCustomer(Customer customer){
        Connection c = DatabaseConnectionPostgre.connection();
        boolean success = true;
        Statement stmt = null;
        int year = 1999;
        int month = 0;
        int date = 1;
        Calendar cal = Calendar.getInstance();
        cal.clear();
        cal.set(Calendar.YEAR, year);
        cal.set(Calendar.MONTH, month);
        cal.set(Calendar.DATE, date);
        java.util.Date utilDate = cal.getTime();

        try {
            stmt = c.createStatement();
            String sql = "INSERT INTO customer (id,name,email,username,password,birthdate) VALUES("+customer.getId()+",'"+customer.getName()+"','"+customer.getEmail()+"','"+customer.getUsername()+"','"+customer.getPassword()+"','"+utilDate+"');";
            stmt.executeUpdate(sql);

            stmt.close();
//            c.commit();
            c.close();
        } catch (Exception e) {
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return success;
    }

    public static int getLastCustomerId(){
        int value=0;
        Connection c = DatabaseConnectionPostgre.connection();
        Statement stmt = null;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT MAX (id) AS id FROM customer;");
            while (rs.next()){
                value = rs.getInt("id");
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return value;
    }

    public static Customer getCustomer(int id){
        Customer value = null;
        Connection c = DatabaseConnectionPostgre.connection();
        Statement stmt = null;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer WHERE id = "+id+";");
            while (rs.next()){
                id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Date birthdate = rs.getDate("birthdate");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(birthdate);
                value = new Customer(id, name, email, username, password, calendar);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return value;
    }

    public static boolean removeCustomer(int id){
        Connection c = DatabaseConnectionPostgre.connection();
        boolean success = true;
        Statement stmt = null;

        try{
            stmt = c.createStatement();
            String sql = "DELETE FROM customer WHERE ID = "+id+";";
            stmt.executeUpdate(sql);
//            c.commit();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return success;
    }

    public static ArrayList<Customer> getCustomerDatabase(){
        ArrayList<Customer> customers = new ArrayList<>();
        Customer value = null;
        Connection c = DatabaseConnectionPostgre.connection();
        Statement stmt = null;

        try {
            stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM customer;");
            while (rs.next()){
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");
                String username = rs.getString("username");
                String password = rs.getString("password");
                Date birthdate = rs.getDate("birthdate");
                Calendar calendar = new GregorianCalendar();
                calendar.setTime(birthdate);
                value = new Customer(id, name, email, username, password, calendar);
                customers.add(value);
            }
            rs.close();
            stmt.close();
            c.close();
        }catch (Exception e){
            System.err.println(e.getClass().getName()+": "+e.getMessage());
            System.exit(0);
        }

        return customers;
    }
}
