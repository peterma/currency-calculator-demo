package io.lab.currency.domain;

import java.util.Date;
import java.util.Map;

import org.codehaus.jackson.annotate.JsonProperty;

public class CurrencyExchange {

	@JsonProperty(value = "base")
	private String baseCurrency;

	@JsonProperty(value = "date")
	private Date exchangeDate;

	@JsonProperty(value = "rates")
	private Map<String, String> rates;

	private String quoteCurrency;

	private float exchangeRate;

	public CurrencyExchange() {

	};

	public String getBaseCurrency() {
		return baseCurrency;
	}

	public void setBaseCurrency(String baseCurrency) {
		this.baseCurrency = baseCurrency;
	}

	public Date getExchangeDate() {
		return exchangeDate;
	}

	public void setExchangeDate(Date exchangeDate) {
		this.exchangeDate = exchangeDate;
	}

	public String getQuoteCurrency() {
		return quoteCurrency;
	}

	public void setQuoteCurrency(String quoteCurrency) {
		this.quoteCurrency = quoteCurrency;
	}

	public float getExchangeRate() {
		return exchangeRate;
	}

	public void setExchangeRate(float exchangeRate) {
		this.exchangeRate = exchangeRate;
	}

	public Map<String, String> getRates() {
		return rates;
	}

	public void setRates(Map<String, String> rates) {
		this.rates = rates;
		if (null != rates) {
			for(String quoteCurrency : rates.keySet()) {
				this.quoteCurrency = quoteCurrency;
				String exchangeRateText = rates.get(quoteCurrency);
				
				this.exchangeRate = Float.valueOf(exchangeRateText);
				return;
			}
		}
	}

	@Override
	public String toString() {
		return "CurrencyExchange [baseCurrency=" + baseCurrency + ", exchangeDate=" + exchangeDate + ", rates=" + rates
				+ ", quoteCurrency=" + quoteCurrency + ", exchangeRate=" + exchangeRate + "]";
	}

}
