package giu.supermarket.people;

import giu.supermarket.cart.Cart;
import giu.supermarket.exceptions.IncorrectFatTypeException;
import giu.supermarket.exceptions.IncorrectSugarLevelException;
import giu.supermarket.products.*;

public class Customer {

	private String name;
	private Cart myCart;
	private Fat preferableFatLevel;
	private SugarLevel preferableSugarLevel;

	public Customer(String name, Cart cart) {

		this.name = name;
		this.myCart = cart;

	}

	public Customer(String name, Cart myCart, Fat preferableFatLevel, SugarLevel preferableSugarLevel) {
		super();
		this.name = name;
		this.myCart = myCart;
		this.preferableFatLevel = preferableFatLevel;
		this.preferableSugarLevel = preferableSugarLevel;
	}

	public void buy(GroceryProduct p) throws IncorrectFatTypeException, IncorrectSugarLevelException {
		if (p instanceof DairyProduct){
			DairyProduct m =(DairyProduct) p;
			if (!(m.getFat().equals(preferableFatLevel))){
				throw new IncorrectFatTypeException();
			}
		}
		else if (p instanceof Beverage){
			Beverage m =(Beverage) p;
			if (!(m.getSugarLevel().equals(preferableSugarLevel))){
				throw new IncorrectSugarLevelException();
			}
		}

		else {
			System.out.println(this.name + " bought " + p.getName() + ".");
			myCart.addProduct(p);
		}

	}
}
