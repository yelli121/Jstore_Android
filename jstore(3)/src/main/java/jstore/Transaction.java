package jstore;
/**
 * Write a description of class Transaction here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
import java.util.ArrayList;

public class Transaction
{
    /**
     * An example of a method - replace this comment with your own
     *
     *
     */
    public static void orderNewItem(ArrayList<Integer> item_list)
    {
        //ArrayList<Integer> temp = new ArrayList<>();
        //temp.add(item.getId());
        //Invoice inv = new Buy_Paid(temp);
        //DatabaseInvoice.addInvoice(inv);
    }
    
    public static void orderSecondItem(ArrayList<Integer> item_list)
    {
//        ArrayList<Integer> temp = new ArrayList<>();
//        //temp.add(item.getId());
//        Invoice inv = new Buy_Paid(temp);
//        DatabaseInvoice.addInvoice(inv);
    }
    
    public static void orderRefurbishedItem(ArrayList<Integer> item_list)
    {
//        ArrayList<Integer> temp = new ArrayList<>();
//        //temp.add(item.getId());
//        Invoice inv = new Buy_Paid(temp);
//        DatabaseInvoice.addInvoice(inv);
    }
    
    public static void sellItemPaid(ArrayList<Integer> item_list, Customer customer)
    {
//        ArrayList<Integer> temp = new ArrayList<>();
//        //temp.add(item.getId());
//        Invoice inv = new Sell_Paid(temp, customer);
//        DatabaseInvoice.addInvoice(inv);
    }
    
    public static void sellItemUnpaid(ArrayList<Integer> item_list, Customer customer)
    {
//        ArrayList<Integer> temp = new ArrayList<>();
//        //temp.add(item.getId());
//        Invoice inv = new Sell_Unpaid(temp, customer);
//        DatabaseInvoice.addInvoice(inv);
    }
    
    public static void sellItemInstallment(ArrayList<Integer> item_list, Customer customer, int installmentPeriod)
    {
//        ArrayList<Integer> temp = new ArrayList<>();
//        //temp.add(item.getId());
//        Invoice inv = new Sell_Installment(temp,12,customer);
//        DatabaseInvoice.addInvoice(inv);
    }
    
    public static boolean finishTransaction(Invoice invoice)
    {
        if(invoice.getInvoiceStatus()==InvoiceStatus.Unpaid|| invoice.getInvoiceStatus()==InvoiceStatus.Installment){
            ArrayList<Invoice> inv = DatabaseInvoice.getInvoiceDatabase();
            for (int i = 0; i < inv.size(); i++){
                if(inv.get(i).getId() == invoice.getId()){
                    invoice.setIsActive(false);
                    inv.set(i,invoice);
                    System.out.println(invoice.toString());
                    return true;
                }
            }
            return false;
        }
        return false;
    }
    
    public static boolean cancelTransaction(Invoice invoice)
    {
        if(invoice.getInvoiceStatus()==InvoiceStatus.Unpaid|| invoice.getInvoiceStatus()==InvoiceStatus.Installment) {
            ArrayList<Invoice> invDb = DatabaseInvoice.getInvoiceDatabase();
            for (Invoice inv : invDb) {
                if (inv.getId() == invoice.getId()) {
                    invDb.remove(inv);
                    return true;
                }
            }
            return false;
        }
        return false;
    }
}
