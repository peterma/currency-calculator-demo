package io.lab.currency.biz.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.annotation.*;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import io.lab.currency.biz.CurrencyService;
import io.lab.currency.domain.CurrencyExchange;

@Component
public class CurrencyServiceImpl implements CurrencyService {

	@Autowired
	RestTemplate restTemplate;

	public static final int NO_RESULT = -1;

	private static final Logger logger = LoggerFactory.getLogger(CurrencyServiceImpl.class);

	// TODO Daily maintain
	private static Map<String, CurrencyExchange> exchangeRates = new ConcurrentHashMap<String, CurrencyExchange>();

	private static String[] baseCurrencies = new String[] { "USD", "EUR", "GBP" };
	// final String uri = "http://api.fixer.io/latest?base={base}&symbos={symbols}";
	final String CURRENCY_URI = "http://api.fixer.io/latest?base={base}";

	private static int MAX_TRY = 5;

	@PostConstruct
	public Map<String, CurrencyExchange> init() {
		logger.debug("Init method called.");
		final String uri = "http://api.fixer.io/latest?base={base}";

		for (String baseCurrency : baseCurrencies) {

			Map<String, Object> urlVariables = new HashMap<String, Object>();
			urlVariables.put("base", baseCurrency);

			// TODO Handle connection timeout
			long startAt = System.currentTimeMillis();
			logger.debug("Begin..." + startAt);

			CurrencyExchange result = null;
			int haveTried = 0;
			do {
				try {
					result = restTemplate.getForObject(uri, CurrencyExchange.class, urlVariables);
				} catch (RestClientException exception) {
					// try again
					logger.debug("..." + haveTried++);
				}
			} while (null == result && haveTried <= MAX_TRY);

			long endAt = System.currentTimeMillis();
			logger.debug("End  ..." + endAt);
			logger.debug("In " + ((endAt - startAt) / 1000) + " seconds");
			if(result != null) {				
				exchangeRates.put(baseCurrency, result);
				logger.debug(result.toString());
			} else {
				logger.error("Cannot get data from exchange rate service.");
			}
		}

		return exchangeRates;
	}

	public float getExchangeRate(String baseCurrency, String termCurrency) {
		float exchangeRate = NO_RESULT;
		CurrencyExchange result = getExchangeRateFromCache(baseCurrency);

		if (result == null) {
			result = this.getExchangeRateFromService(baseCurrency);
		}

		if (result != null) {
			String exchangeRateText = result.getRates().get(termCurrency);
			if (exchangeRateText != null) {
				exchangeRate = Float.valueOf(exchangeRateText);
			}
		}

		return exchangeRate;
	}

	private CurrencyExchange getExchangeRateFromCache(String baseCurrency) {
		CurrencyExchange result = exchangeRates.get(baseCurrency);
		return result;
	}

	private CurrencyExchange getExchangeRateFromService(String baseCurrency) {
		CurrencyExchange result = null;

		Map<String, Object> urlVariables = new HashMap<String, Object>();
		urlVariables.put("base", baseCurrency);
		// urlVariables.put("symbols", termCurrency);

		long startAt = System.currentTimeMillis();
		logger.debug("Begin..." + startAt);

		int haveTried = 0;
		do {
			try {
				result = restTemplate.getForObject(CURRENCY_URI, CurrencyExchange.class, urlVariables);
			} catch (RestClientException exception) {
				// Handle connection timeout
				// try again
				logger.debug("..." + haveTried++);
			}
		} while (null == result && haveTried <= MAX_TRY);

		long endAt = System.currentTimeMillis();
		logger.debug("End  ..." + endAt);
		logger.debug("In " + ((endAt - startAt) / 1000) + " seconds");
		exchangeRates.put(baseCurrency, result);

		logger.debug(result.toString());

		return result;
	}
}
