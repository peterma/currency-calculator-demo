package io.lab.currency.biz.impl;

import java.math.BigDecimal;
import java.math.RoundingMode;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import io.lab.currency.biz.CurrencyCalculateService;
import io.lab.currency.biz.CurrencyService;
import io.lab.currency.domain.Expression;
import io.lab.currency.domain.Operand;
import io.lab.currency.domain.Operations;
import io.lab.currency.parser.Parser;

@Component
public class CurrencyCalculateServiceImpl implements CurrencyCalculateService {

	@Autowired
	CurrencyService currencyService;

	@Autowired
	Parser parser;

	public BigDecimal calculate(String expressionText) {
		BigDecimal result = null;
		Expression expression = parser.parse(expressionText);

		String baseCurrency = expression.getTargetCurrency().getCurrencyCode();

		Operand firstOperand = expression.getFirstOperand();
		String firstOperandCurrency = firstOperand.getCurrency().getCurrencyCode();
		float firstOperandRate = currencyService.getExchangeRate(baseCurrency, firstOperandCurrency);
		BigDecimal firstOperandInTargetCurrency = firstOperand.getAmount().multiply(BigDecimal.valueOf(firstOperandRate));

		Operand secondOperand = expression.getSecondOperand();
		String secondOpernadCurrency = secondOperand.getCurrency().getCurrencyCode();
		float secondOperandRate = currencyService.getExchangeRate(baseCurrency, secondOpernadCurrency);
		BigDecimal secondOperandInTargetCurrency = secondOperand.getAmount().multiply(BigDecimal.valueOf(secondOperandRate));

		// TODO Do this in a design pattern way, like "Command".
		Operations operation = expression.getOperation();
		result = operation.apply(firstOperandInTargetCurrency, secondOperandInTargetCurrency);

		return result;
	}

}
