import static org.junit.Assert.assertEquals;
import giu.supermarket.cart.Cart;
import giu.supermarket.exceptions.CannotBuyException;
import giu.supermarket.exceptions.IncorrectFatTypeException;
import giu.supermarket.exceptions.IncorrectSugarLevelException;
import giu.supermarket.people.Customer;
import giu.supermarket.products.Beverage;
import giu.supermarket.products.DairyProduct;
import giu.supermarket.products.Fat;
import giu.supermarket.products.SugarLevel;

import org.junit.Before;
import org.junit.Test;

public class Lab4PublicTests {

	Customer customer;
	DairyProduct dairyProduct_fullcream;
	DairyProduct dairyProduct_halfcream;
	DairyProduct dairyProduct_skimmed;
	Beverage beverage_zero;
	Beverage beverage_addedSugar;
	Beverage beverage_noAddedSugar;
	Beverage beverage_light;
	Cart cart;

	@Before
	public void setup() {
		cart = new Cart();
		customer = new Customer("Lama", cart, Fat.SKIMMED, SugarLevel.ZERO);
		dairyProduct_fullcream = new DairyProduct("Lamar", 10, 0, Fat.FULLCREAM);
		dairyProduct_halfcream = new DairyProduct("Lamar", 10, 0, Fat.HALFCREAM);
		dairyProduct_skimmed = new DairyProduct("Lamar", 10, 0, Fat.SKIMMED);
		beverage_zero = new Beverage("Pepsi", 5, 0, SugarLevel.ZERO);
		beverage_light = new Beverage("Pepsi", 5, 0, SugarLevel.LIGHT);
		beverage_addedSugar = new Beverage("Pepsi", 5, 0,
				SugarLevel.ADDED_SUGAR);
		beverage_noAddedSugar = new Beverage("Pepsi", 5, 0,
				SugarLevel.NO_ADDED_SUGAR);
	}

	@Test(timeout = 1000)
	public void testIncorrectFatTypeExceptionInheritance() {
		assertEquals(
				"Class IncorrectFatTypeException should be a subclass of CannotBuyException",
				IncorrectFatTypeException.class.getSuperclass(),
				CannotBuyException.class);
	}

	@Test(timeout = 1000, expected = IncorrectFatTypeException.class)
	public void testFullCream() throws IncorrectFatTypeException,
			IncorrectSugarLevelException {
		customer.buy(dairyProduct_fullcream);
	}

	@Test(timeout = 1000)
	public void testSkimmed() throws IncorrectFatTypeException,
			IncorrectSugarLevelException {
		customer.buy(dairyProduct_skimmed);
	}

	@Test(timeout = 1000, expected = IncorrectSugarLevelException.class)
	public void testLight() throws IncorrectFatTypeException,
			IncorrectSugarLevelException {
		customer.buy(beverage_light);
	}

	@Test(timeout = 1000)
	public void testZero() throws IncorrectFatTypeException,
			IncorrectSugarLevelException {
		customer.buy(beverage_zero);
	}
}
