package io.lab.currency;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class JDK5Features {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test_Enumerations() {
		ResponseStatus statusA = ResponseStatus.Success;
		ResponseStatus statusB = ResponseStatus.ParamError;
		assertFalse(statusA == statusB);
		
		ResponseStatus statusX = ResponseStatus.valueOf("Success");
		assertTrue(statusA == statusX);
		System.out.println("statusA, code:" + statusA.getCode() + ", msg:" + statusA.getMessage());
		System.out.println("statusB, code:" + statusB.getCode() + ", msg:" + statusB.getMessage());
		
		ResponseStatus statusY = ResponseStatus.fromCode(600);
		System.out.println("statusY, code:" + statusY.getCode() + ", msg:" + statusY.getMessage());
		
		System.out.println("Without calling toString():" + statusY);
		
		System.out.println("Calling .name(): \"" + statusY.name() + "\"");
		
		System.out.println("Ordinal values: statusA(Success-200), statusB(ParamError-601): " + statusA.ordinal() + ", " + statusB.ordinal());
		System.out.println("statusA(Success-200) compare to statusB(ParamError-601): " + statusA.compareTo(statusB));
	}
	
	@Test
	public void test_Lamda() {
		int answer = 42;
		Thread t = new Thread(
		  () -> System.out.println("The answer is: " + answer)
		);
		t.start();
	}

}

enum ResponseStatus {
	Success(200, "Operation success."),
	Failed(600, "Operation failed."),
	ParamError(601, "Parameter error.");

	private int code;
	private String msg;
	
	private ResponseStatus(int code, String msg) {
		this.code = code;
		this.msg = msg;
	}
	
	public int getCode() {
		return this.code;
	}

	public String getMessage() {
		return this.msg;
	}
	
	public static ResponseStatus fromCode(int code) {
		switch(code) {
		case 200:
			return ResponseStatus.Success;
		case 600:
			return ResponseStatus.Failed;
		case 601:
			return ResponseStatus.ParamError;
		default:
			return ResponseStatus.Failed;
		}		
	}
	
	public String toString() {
		return this.msg;
	}
}
