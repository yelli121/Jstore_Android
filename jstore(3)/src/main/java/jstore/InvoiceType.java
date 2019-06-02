package jstore;
/**
 * Enumeration class InvoiceType - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum InvoiceType
{
    Buy("Buy"), Sell("Sell");
    
    private String strInvoiceType;
    
    private InvoiceType(String strInvoiceType)
    {
        this.strInvoiceType=strInvoiceType;
    }
    
    public String toString()
    {
        return strInvoiceType;
    }
}
