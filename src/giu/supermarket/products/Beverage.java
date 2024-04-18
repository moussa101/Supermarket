package giu.supermarket.products;

public class Beverage extends GroceryProduct implements Drinkable{

   private SugarLevel sugarLevel ;

    public Beverage(String name, double price, double discount, SugarLevel a) {
        super(name, price, discount);
        this.sugarLevel  = a;
    }

    @Override
    public String toString() {
        return super.toString() +"\n"+"Sugar Level: "+ sugarLevel ;
    }

    public SugarLevel getSugarLevel() {
        return sugarLevel;
    }

    public void setSugarLevel(SugarLevel sugarLevel) {
        this.sugarLevel = sugarLevel;
    }


    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Beverage)) {
            return false;
        }
        Beverage o1 = (Beverage) o;
        if (super.equals(o1) && this.sugarLevel.equals(o1.sugarLevel)) {
            return true ;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean isHealthy() {
        if (sugarLevel==SugarLevel.ADDED_SUGAR){
            return false;
        }
        else{
            return true;
        }
    }

    public final double getActualPrice(double extra){
        return getPrice()-getPrice()*(( getDiscount() + extra)/100.0);
    }

    @Override
    public boolean refrigerate() {
        return false;
    }
}
