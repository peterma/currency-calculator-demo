package io.lab.currency;

import java.util.Currency;
import java.util.Set;

/**
 * Hello world!
 *
 */
public class App {
	public static void main(String[] args) {
		// showAllCurrencies();
		
		String code = "EUR"; // EUR, USD
		getCurrencyByCode(code);
	}

	private static void getCurrencyByCode(String code) {
		
		Currency currency = Currency.getInstance(code);
		StringBuffer sb;
		sb = new StringBuffer();
		sb.append("CurrencyCode:" + currency.getCurrencyCode());
		sb.append(", ");
		sb.append("DefaultFractionDigits:" + currency.getDefaultFractionDigits());
		sb.append(", ");
		sb.append("Symbol:" + currency.getSymbol());
		sb.append(", ");
		sb.append("DisplayName:" + currency.getDisplayName());
		System.out.println(sb.toString());
	}

	private static void showAllCurrencies() {
		Set<Currency> currencies = Currency.getAvailableCurrencies();
		StringBuffer sb;
		for (Currency currency : currencies) {
			sb = new StringBuffer();
			sb.append("CurrencyCode:" + currency.getCurrencyCode());
			sb.append(", ");
			sb.append("DefaultFractionDigits:" + currency.getDefaultFractionDigits());
			sb.append(", ");
			sb.append("Symbol:" + currency.getSymbol());
			sb.append(", ");
			sb.append("DisplayName:" + currency.getDisplayName());
			System.out.println(sb.toString());
		}
	}
}
