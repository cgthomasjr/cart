
package com.cgtcorp.project1;

import java.util.ArrayList;
/**
 * Provides the classes necessary to create a Cart
 * @author Clayton G. Thomas
 */
public class Cart {
    
    private double dscntPrcnt;
    private double dscntVle;
    private double total;
    private double dscntTtl;
    private int minNmbrDscntItms;
    private int nmbrItems;    
    private ArrayList items;

    /**
     * Constructs a cart with a default discount percentage (.20) and 
     * minimum number (4) of required items for the associated discount.
     */ 
    public Cart() {
        dscntPrcnt = 0.20;
        minNmbrDscntItms = 4;
        items = new ArrayList();
    }
    /**
     * Constructs a cart with a discount percentage and minimum require
     * items for the associated discount.
     * @param myDscntPrcnt
     * @param myMinNmbrDscntItms 
     */
    public Cart(double myDscntPrcnt,int myMinNmbrDscntItms) {
        dscntPrcnt = myDscntPrcnt;
        minNmbrDscntItms = myMinNmbrDscntItms;
        items = new ArrayList();
    }    
    /**
     * Get the minimum number of items required for a discount
     * @return 
     */
    public int getMinNmbrDscntItms() {
        return minNmbrDscntItms;
    }
    /**
     * Set the minimum number of items required for a discount
     * @param myMinNmbrDscntItms 
     */
    public void setMinNmbrDscntItms(int myMinNmbrDscntItms) {
        this.minNmbrDscntItms = myMinNmbrDscntItms;
    }
    /**
     * Set the discount percentage amount
     * @param myDscntPrcnt 
     */
    public void setDscntPrcnt(double myDscntPrcnt) {
        this.dscntPrcnt = myDscntPrcnt;
    }
    /**
     * Get the discount percentage
     * @return 
     */
    public double getDscntPrcnt() {
        return dscntPrcnt;
    }
    /**
     * Get the discounted value.  This value is subtracted from the total.
     * @return 
     */
    public double getDscntVle() {
        return dscntVle;
    }
    /**
     * Get the total sum of item prices.
     * @return 
     */
    public double getTotal(){
        return total;
    }
    /**
     * Get the number of items in the cart.
     * @return 
     */
    public int getNmbrItems() {         
         return nmbrItems;
    }
    /**
     * Get the discounted total after applying discount percentage.
     * @return 
     */
    public double getDscntTtl() {
        return dscntTtl;
    }
    void addItem(Item myItem) {
        this.items.add(myItem);
        nmbrItems = items.size();
        computeTotal(myItem);        
        computeDscntVle();
        computeDscntTtl();
    }
    ArrayList rtrveItems() {
        return items;
    }    
    private void computeDscntTtl() {
        double aTotal = getTotal();
        double discountValue = getDscntVle();               
        dscntTtl = aTotal - discountValue;
    }
    private void computeDscntVle() {
        double aTotal = getTotal();
        int aSize = getNmbrItems();
        double discountValue = 0;        
        if (aSize >= minNmbrDscntItms) {
            discountValue = dscntPrcnt * aTotal;
        }              
        dscntVle = discountValue;
    }    
    private void computeTotal(Item myItem) {           
        total += myItem.getPrice();
    }
}