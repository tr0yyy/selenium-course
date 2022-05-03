package curs2;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class AssertionExample {
	
	@Test(priority=1)
	public void softAssert() {
		
		SoftAssert sa =  new SoftAssert();
		System.out.println("Soft assert incepe aici!");
		sa.assertTrue(false);
		System.out.println("Cod dupa assert!");
		sa.assertTrue(false);
		System.out.println("Soft assert se inchide aici!");
		sa.assertAll();
		
	}
	
	@Test(priority=2)
	public void hardAssert() {
		System.out.println("Hard asser incepe aici!");
		assertTrue(false);
		System.out.println("Cod dupa assert!");
		System.out.println("Hard assert se inchide aici!");

	}
	

}
