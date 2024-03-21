package giu.supermarket.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.lang.reflect.Modifier;

import org.junit.Test;

import giu.supermarket.products.Beverage;
import giu.supermarket.products.DairyProduct;
import giu.supermarket.products.Fat;
import giu.supermarket.products.GroceryProduct;
import giu.supermarket.products.SugarLevel;
import giu.supermarket.products.Drinkable;

public class Lab3AllTests {
	String gPath = "giu.supermarket.products.GroceryProduct";
	String bPath = "giu.supermarket.products.Beverage";
	String dPath = "giu.supermarket.products.DairyProduct";
	String cPath = "giu.supermarket.cart.Cart";

	@Test(timeout = 1000)
	public void testClassIsAbstractGroceryProduct() throws NoSuchMethodException {
		assertTrue("No object should be instantiated from class groceryProducts",
				Modifier.isAbstract(GroceryProduct.class.getModifiers()));

	}

	@Test
	public void testMethodBeverageRefrigerate() throws Exception {

		Beverage.class.getDeclaredMethod("refrigerate");

	}

	@Test
	public void testMethodBeverageRefrigerateLogic() throws Exception {

		Beverage p = new Beverage("Schweppes Pomegranate", 10, 5, SugarLevel.ADDED_SUGAR);
		assertEquals("Beverages does not need to be kept in a refrigerator", false, p.refrigerate());

	}

	@Test
	public void testMethodDairyProductRefrigerate() throws Exception {

		DairyProduct.class.getDeclaredMethod("refrigerate");

	}

	@Test
	public void testMethodDairyProductRefrigerateLogic() throws Exception {

		DairyProduct p = new DairyProduct("Juhayna", 20, 5, Fat.FULLCREAM);
		assertEquals("Dairy products need to be kept in a refrigerator", true, p.refrigerate());

	}

	@Test
	public void testMethodGroceryProductRefrigerate() throws Exception {

		assertTrue(
				"A method that behaves completely differently in each subclass should be declared as abstract in the super class and implemented in each subclass.",
				Modifier.isAbstract(GroceryProduct.class.getMethod("refrigerate", new Class[0]).getModifiers()));

	}

	@Test(timeout = 1000)
	public final void testInterface() {

		assertEquals("Drinkable should be an Interface", 1537, Drinkable.class.getModifiers());

		Drinkable drink = new Beverage("Pepsi", 5, 0, SugarLevel.ADDED_SUGAR);
		Drinkable drink2 = new Beverage("Pure Apple", 5, 0, SugarLevel.NO_ADDED_SUGAR);
		Drinkable drink3 = new Beverage("Sprite", 5, 0, SugarLevel.LIGHT);
		Drinkable drink4 = new Beverage("Pepsi", 5, 0, SugarLevel.ZERO);
		assertFalse("A drink with added sugar is unhealthy", drink.isHealthy());
		assertTrue("A drink with no sugar is healthy", drink2.isHealthy());
		assertTrue("A drink with light sugar level is healthy", drink3.isHealthy());
		assertTrue("A drink with zero sugar level is healthy", drink4.isHealthy());
	}

	// --------------------------------------------Helper
	// methods----------------------------------------------------------
	public static boolean containsMethod(Class<?> c, String name, @SuppressWarnings("rawtypes") Class[] parameters) {
		try {
			c.getDeclaredMethod(name, parameters);
			return true;
		} catch (NoSuchMethodException e) {
			return false;
		}
	}
}
