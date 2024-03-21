package giu.supermarket.products;

public class DairyProduct extends GroceryProduct{
    private Fat fat;


    public DairyProduct(String name, double price, double discount, Fat fat) {
        super(name, price, discount);
        this.fat = fat;
    }

    @Override
    public String toString() {
        return super.toString()+"\n"+"Fat Level:"+fat;
    }

    public Fat getFat() {
        return fat;
    }

    public void setFat(Fat fat) {
        this.fat = fat;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof DairyProduct)) {
            return false;
        }
        DairyProduct a = (DairyProduct) o;
        if(super.equals(o)&&this.fat.equals(a.fat))
            return true;
        else{
            return false;
        }
    }

    @Override
    public boolean refrigerate() {
        return true;
    }
}
