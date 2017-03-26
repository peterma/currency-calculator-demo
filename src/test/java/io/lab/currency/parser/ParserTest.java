package io.lab.currency.parser;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.lab.currency.domain.Expression;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
public class ParserTest {

	@Resource
	private Parser parser;

	@Test
	public void testParse() {
		Expression exp = parser.parse("EUR100+GBP100=USD");
		assertNotNull(exp);
	}
	
	@Test
	public void testParseNull() {
		Expression exp = parser.parse("");
		assertNull(exp);
	}
	
	@Test
	public void testParseException() {
		
		Expression exp = parser.parse("");
		assertNull(exp);
	}
	
	@Test
	public void testValidate() {
		boolean valid = parser.validate("EUR100+GBP100=USD");
		assertTrue(valid);
	}

}
