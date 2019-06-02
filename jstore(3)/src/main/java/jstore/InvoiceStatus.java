package jstore;
/**
 * Enumeration class InvoiceStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceStatus
{
    Paid("Paid"), Unpaid("Unpaid"), Installment("Installment");
    
    private String strInvoiceStatus;
    
    private InvoiceStatus(String strInvoiceStatus)
    {
        this.strInvoiceStatus=strInvoiceStatus;
    }
    
    public String toString(){
        return strInvoiceStatus;
    }
}
