package io.lab.currency.biz.impl;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import javax.annotation.Resource;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import io.lab.currency.biz.CurrencyCalculateService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
public class CurrencyCalculateServiceImplTest {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyCalculateServiceImplTest.class);

	@Resource
	private CurrencyCalculateService currencyCalculateService;

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
	public void testCalculate() {
		BigDecimal result = currencyCalculateService.calculate("EUR100+GBP100=USD");
		System.out.println(result);
		assertNotNull(result);
	}

}
