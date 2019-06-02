package jstore;
/**
 * Enumeration class ItemStatus - write a description of the enum class here
 *
 * @author (your name here)
 * @version (version number or date here)
 */
public enum ItemStatus
{
    New("New"), Second("Second"), Refurbished("Refurbished"), Sold("Sold");
   
    private String strItemStatus;
    
    private ItemStatus(String strItemStatus)
    {
        this.strItemStatus=strItemStatus;
    }
    
    public String toString(){
        return strItemStatus;
    }
}
