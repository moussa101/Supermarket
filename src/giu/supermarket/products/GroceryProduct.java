package giu.supermarket.products;

public abstract class GroceryProduct {
private String name;
private double price;
private double discount;

    public GroceryProduct(String name, double price, double discount) {
        this.name = name;
        this.price = price;
        this.discount = discount;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }
    public final double getActualPrice() {
        return getPrice()-(getPrice()*(getDiscount()/100));
    }

    @Override
    public String toString() {
        return "Name: "+ name+"\n"+ "Price: "+price+ "L.E."+"\n"+ "Discount:"+discount*100+"%";
    }


    @Override
    public boolean equals(Object o) {
        GroceryProduct b = (GroceryProduct) o;
        if (this.getName().equals(b.getName())&&this.getPrice()==b.getPrice()&&getDiscount()==b.getDiscount())
        return true;

        else{
            return false;
        }
    }
    abstract public boolean refrigerate();


}
