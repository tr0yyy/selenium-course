package curs1;

import static org.testng.Assert.assertTrue;

import org.testng.annotations.Test;

public class TestNgDependency {
	
	@Test
	public void method1() {
		
		assertTrue(false);
		System.out.println("Method 1");
	}
	
	@Test(dependsOnMethods = "method1", alwaysRun = true)
	public void method2() {
		System.out.println("Method 2");
		assertTrue(false);
	}
	
	@Test
	public void method3() {
		System.out.println("Method 3");
	}
	
	
	

}
