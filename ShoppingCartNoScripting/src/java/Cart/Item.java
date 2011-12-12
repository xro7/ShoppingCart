/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Cart;

/**
 *
 * @author ΧΡΟ
 */
public class Item {
    
    private String name;
    private int quantity;
    private double price;
    private double totalprice;
    public void Item(){}
    
    public String getName(){
        return(name);
    }
    public void setName(String name){
        this.name=name;
    }
    public int getQuantity(){
        return(quantity);
    }
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    public double getPrice(){
        return(price);
    }
    public void setPrice(double price){
        this.price=price;
    }
     public double getTotalprice(){
        return(totalprice);
    }
    public void setTotalprice(double totalprice){
        this.totalprice=totalprice;
    }
    
}
