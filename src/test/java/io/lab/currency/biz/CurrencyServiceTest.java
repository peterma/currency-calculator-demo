package io.lab.currency.biz;

import static org.junit.Assert.*;

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

import io.lab.currency.biz.impl.CurrencyServiceImpl;
import io.lab.currency.domain.CurrencyExchange;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/application-config.xml")
public class CurrencyServiceTest {

	private static final Logger logger = LoggerFactory.getLogger(CurrencyServiceTest.class);

	@Resource
	private CurrencyService currencyService;

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
	public void testGetExhangeRate() {
		float exchangeRate = currencyService.getExchangeRate("USD", "EUR");
		logger.debug("USD/EUR:" + exchangeRate);
		assertNotNull(exchangeRate);

		exchangeRate = currencyService.getExchangeRate("USD", "GBP");
		logger.debug("USD/GBP:" + exchangeRate);
		assertNotNull(exchangeRate);

		exchangeRate = currencyService.getExchangeRate("USD", "JPY");
		logger.debug("USD/JPY:" + exchangeRate);
		assertNotNull(exchangeRate);
	}

//	@Test
//	public void testGetExhangeRates() {
//		currencyService.getExchangeRates();
//	}

}
