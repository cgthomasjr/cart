/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cgtcorp.project1;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.Map;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.json.JsonBuilderFactory;
import javax.json.JsonNumber;
import javax.json.JsonObject;
import javax.json.JsonObjectBuilder;
import javax.json.JsonReader;

/**
 *
 * @author cgthomasjr
 */
public class JSONCartUtil {

    private String jsonclnt;
    private String jsonsrvr;

    public String getJsonclnt() {
        return jsonclnt;
    }

    public void setJsonclnt(String myJsonclnt) {
        this.jsonclnt = myJsonclnt;
    }

    public String getJsonsrvr() {
        return jsonsrvr;
    }

    public void setJsonsrvr(String myJsonsrvr) {
        this.jsonsrvr = myJsonsrvr;
    }
    
    public void process() throws IOException{
        jsonsrvr = retrieveJSON();
    }
    public Cart retrieveCart() 
            throws IOException{
        return retrieveCart(jsonclnt);
    }    
    public Cart retrieveCart(String myJSON)
            throws IOException {
        
        String jsonData = myJSON;
        Cart shppngCart = new Cart();
        
        if(jsonData == null){
            return shppngCart;
        }
        
        JsonReader reader = Json.createReader(new StringReader(jsonData));
        JsonObject cartObject = reader.readObject();
        reader.close();
        
        JsonArray itemsArray = cartObject.getJsonArray("items");
        int aSize = itemsArray.size();
        for (int i = 0; i < aSize; i++) {
            JsonObject itemsObject = itemsArray.getJsonObject(i);
            String name = itemsObject.getString("name");
            JsonNumber price = itemsObject.getJsonNumber("price");
            String dscrptn = "";
            double dblePrice = price.doubleValue();
            Item prdctItem = new Item(name, dblePrice, dscrptn);
            shppngCart.addItem(prdctItem);
        }
        return shppngCart;
    }
    public String retrieveJSON() throws IOException {
        Cart aCart = retrieveCart();
        return retrieveJSON(aCart);
    }
    public String retrieveJSON(Cart myCart) {
        Map config = null;
        JsonBuilderFactory factory = Json.createBuilderFactory(config);
        JsonObjectBuilder builder = factory.createObjectBuilder();

        int nmbrItems = myCart.getNmbrItems();
        double dscntTtl = myCart.getDscntTtl();
        double total = myCart.getTotal(); 
        double dscntPrcnt = myCart.getDscntPrcnt();         
        double dscntVle = myCart.getDscntVle();         
        
        ArrayList itemArrayList = myCart.rtrveItems();
        int aSize = itemArrayList.size();

        builder.add("nmbrItms", nmbrItems);
        builder.add("dscntTtl", dscntTtl);        
        builder.add("total", total);        
        builder.add("dscntPrcnt", dscntPrcnt);  
        builder.add("dscntVle", dscntVle);
 
        JsonArrayBuilder arrayBuilder = factory.createArrayBuilder();
         
        for (int t = 0; t < aSize; t++) {
            Item anItem = (Item) itemArrayList.get(t);
            String aName = anItem.getName();
            double aPrice = anItem.getPrice();
            String aDscrptn = anItem.getDscrptn();
            arrayBuilder.add(factory.createObjectBuilder()
                    .add("name", aName)
                    .add("price", aPrice)
                    .add("dscrptn", aDscrptn));
        }
        builder.add("items",arrayBuilder);
        JsonObject jo = builder.build();
        return jo.toString();
    }
}
