/**
 * 
 */
package com.vu.entity;

import java.util.HashMap;
import java.util.Map;

/**
 * @author VUNH
 *
 * Apr 12, 2019
 * 
 * version 1.0
 */
public class Cart {
	
	private String idcode;
	private Map<Integer, Item> cart;

	public String getIdcode() {
		return idcode;
	}

	public void setIdcode(String idcode) {
		this.idcode = idcode;
	}

	public Map<Integer, Item> getCart() {
		return cart;
	}

	public void setCart(Map<Integer, Item> cart) {
		this.cart = cart;
	}

	public Cart() {
		this.cart = new HashMap<>();
	}
	
	public Cart(String idcode) {
		this.idcode = idcode;
		this.cart = new HashMap<>();
	}
	
	/**
	 * plus product in cart
	 * 
	 * @param productid
	 * @param item
	 */
    public void plus(int productid, Item item){
        boolean check= cart.containsKey(productid);
        if(check){
            int quantityOld= item.getQuantity()+ 1;
            item.setQuantity(quantityOld);
            cart.put(item.getProduct().getProductId(), item);
        }
        else{
            cart.put(item.getProduct().getProductId(), item);
        }
    }
    
    /**
     * sub product in cart
     * 
     * @param productid
     * @param item
     */
    public void sub(int productid, Item item){
        boolean check= cart.containsKey(productid);
        if(check){
            if(item.getQuantity()<2){
                cart.remove(productid);
            }else{
                int quantityOld= item.getQuantity()-1;
                item.setQuantity(quantityOld);
                cart.put(productid, item);
            }
        }

    }
    
    /**
     * remove product in cart
     * 
     * @param productid 
     */
    public void remove(int productid){
        boolean check= cart.containsKey(productid);
        if(check){
            cart.remove(productid);
        }
    }
    
    /**
     * 
     * @return count cart item
     */
    public int count(){
        return cart.size();
    }
    
    /**
     * Coupons can  GO2018
     * 
     * @return total money
     */
    public float total(){
        float total=0;
        for (Map.Entry<Integer, Item> item : cart.entrySet()) {
            total+= item.getValue().getProduct().getPrice()*item.getValue().getQuantity();
        }
        
        if("GO2018".equals(this.idcode)) {
        	total = total - (total *10 /100);
        }
        return total;
    }

}