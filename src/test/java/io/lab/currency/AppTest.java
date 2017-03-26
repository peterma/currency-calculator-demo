package io.lab.currency;

import java.math.BigDecimal;
import java.text.NumberFormat;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {
	/**
	 * Create the test case
	 *
	 * @param testName
	 *            name of the test case
	 */
	public AppTest(String testName) {
		super(testName);
	}

	/**
	 * @return the suite of tests being tested
	 */
	public static Test suite() {
		return new TestSuite(AppTest.class);
	}

	/**
	 * Rigourous Test :-)
	 */
	public void testApp() {
		assertTrue(true);
	}

	public void testDecimalAdd() {
		BigDecimal a1 = new BigDecimal("8250325.12");
		BigDecimal b1 = new BigDecimal("4321456.31");
		BigDecimal c1 = a1.add(b1);
		System.out.println("---------------------------------------");
		System.out.println("---- add      ----" + NumberFormat.getCurrencyInstance().format(c1));
	}
	
	public void testDecimalDivide() {
		BigDecimal a1 = new BigDecimal("8250325.12");
		BigDecimal b1 = new BigDecimal("4321456.31");
		BigDecimal c1 = a1.divide(b1, 2);
		//BigDecimal c1 = a1.divide(b1, 2, RoundingMode.HALF_UP);
		System.out.println("---------------------------------------");
		System.out.println("---- divide   ----" + NumberFormat.getCurrencyInstance().format(c1));
	}
	
	public void testDecimalMultiply() {
		BigDecimal a1 = new BigDecimal("8250325.12");
		BigDecimal b1 = new BigDecimal("4321456.31");
		BigDecimal c1 = a1.multiply(b1);
		System.out.println("---------------------------------------");
		System.out.println("---- multiply ----" + NumberFormat.getCurrencyInstance().format(c1));
	}
	
	public void testDecimalMinus() {
		BigDecimal a1 = new BigDecimal("8250325.12");
		BigDecimal b1 = new BigDecimal("4321456.31");
		BigDecimal c1 = a1.subtract(b1);
		System.out.println("---------------------------------------");
		System.out.println("---- subtract ----" + NumberFormat.getCurrencyInstance().format(c1));
	}
}
