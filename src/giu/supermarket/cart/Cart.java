package giu.supermarket.cart;

import giu.supermarket.products.GroceryProduct;

import java.util.ArrayList;

public class Cart {
   private ArrayList<GroceryProduct> products;

    public Cart() {
        products = new ArrayList<GroceryProduct>();
    }
    public void addProduct(GroceryProduct p){
        products.add(p);
    }
    public double getTotal(){
        double total =0;
        for (GroceryProduct n : products) {
            total+= n.getActualPrice();
        }
        return total;
    }

    public ArrayList<GroceryProduct> getProducts() {
        return products;
    }

    @Override
    public String toString() {
        String f = "";
        for (GroceryProduct n: products){
            f += n.toString()+"\n"+"——————————"+"\n";
        }
        return f;
    }
}
