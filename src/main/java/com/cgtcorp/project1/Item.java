package com.cgtcorp.project1;

/**
 * Provides the classes necessary to create an Item
 * @author Clayton G. Thomas
 */
public class Item {

    private String name;
    private double price;
    private String dscrptn;

    /**
     * Constructs a item with the name, price, and description.
     * @param myName
     * @param myPrice
     * @param myDscrptn 
     */
    public Item(String myName, double myPrice, String myDscrptn) {
        name = myName;
        price = myPrice;
        dscrptn = myDscrptn;
    }

    /**
     * Get price of item.
     * @return 
     */
    public double getPrice() {
        return price;
    }
    /**
     * Get name of item.
     * @return 
     */
    public String getName() {
        return name;
    }
    /**
     * Get description of item.
     * @return 
     */
    public String getDscrptn() {
        return dscrptn;
    }
    /**
     * Set the description of item.
     * @param myName 
     */
    public void setName(String myName) {
        this.name = myName;
    }
    /**
     * Set the item price.
     * @param myPrice 
     */
    public void setPrice(float myPrice) {
        this.price = myPrice;
    }
    /**
     * Set the item description.
     * @param myDscrptn 
     */
    public void setDscrptn(String myDscrptn) {
        this.dscrptn = myDscrptn;
    }
}
