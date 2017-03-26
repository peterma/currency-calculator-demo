package io.lab.currency.biz;

import java.math.BigDecimal;

public interface CurrencyCalculateService {
	
	BigDecimal calculate(String expression);
}
