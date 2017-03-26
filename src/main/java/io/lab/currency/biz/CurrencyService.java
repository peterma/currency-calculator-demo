package io.lab.currency.biz;

public interface CurrencyService {
	
	/**
	 * Get exchange rate from base currency to term currency(quote currency).
	 * @param baseCurrency Base currency
	 * @param termCurrency Term currency(quote currency)
	 * @return
	 */
	public float getExchangeRate(String baseCurrency, String termCurrency);
	
	//public Map<String, CurrencyExchange> getExchangeRates();
	
}
