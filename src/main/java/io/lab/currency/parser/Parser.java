package io.lab.currency.parser;

import java.math.BigDecimal;
import java.util.Currency;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import io.lab.currency.domain.Expression;
import io.lab.currency.domain.Operand;
import io.lab.currency.domain.Operations;

@Component
public class Parser {

	private static final Logger logger = LoggerFactory.getLogger(Parser.class);
	private static final String TEXT_ADD = "+";
	private static final String TEXT_SUBTRACT = "-";
	private static final String TEXT_MULTIPLY = "*";
	private static final String TEXT_DIVIDE = "/";

	private static final String CURRENCY = "^([A-Za-z]{3})([0-9]*\\.?[0-9]*)$";
	private static final String EXPRESSION = "^([A-Za-z]{3}[0-9]*\\.?[0-9]*)([+\\-*/])([A-Za-z]{3}[0-9]*\\.?[0-9]*)=([A-Za-z]{3}$)";

	public Expression parse(String srcText) {
		Expression exp = null;
		// TODO Parse string to an Expression object
		Matcher m = Pattern.compile(EXPRESSION).matcher(srcText);
		if (m.find()) {
			String firstValue = m.group(1);
			String operatorText = m.group(2);
			String secondValue = m.group(3);
			String targetCurrencyText = m.group(4);

			logger.debug(firstValue);
			Operand firstOperand = getOperand(firstValue);
			logger.debug(operatorText);
			logger.debug(secondValue);
			Operand secondOperand = getOperand(secondValue);
			logger.debug(targetCurrencyText);
			Currency targetCurrency = Currency.getInstance(targetCurrencyText);

			Operations operation = null;
			if (TEXT_ADD.toString().equals(operatorText)) {
				operation = Operations.ADD;
			} else if (TEXT_SUBTRACT.toString().equals(operatorText)) {
				operation = Operations.SUBTRACT;
			} else if (TEXT_MULTIPLY.toString().equals(operatorText)) {
				operation = Operations.MULTIPLY;
			} else if (TEXT_DIVIDE.toString().equals(operatorText)) {
				operation = Operations.DIVIDE;
			} else {
				// throw exception.
			}

			exp = new Expression(firstOperand, secondOperand, operation, targetCurrency);
		}

		return exp;
	}

	private Operand getOperand(String srcText) {

		if (null == srcText) {
			// TODO Throw Exception
		}
		srcText = StringUtils.trimAllWhitespace(srcText);
		if (StringUtils.isEmpty(srcText)) {
			// TODO Throw Exception
		}

		Matcher m = Pattern.compile(CURRENCY).matcher(srcText);
		if (m.find()) {
			String currencyCode = m.group(1);
			String value = m.group(2);

			System.out.println(currencyCode);
			System.out.println(value);

			Currency currency = Currency.getInstance(currencyCode);
			Operand operand = new Operand();
			operand.setCurrency(currency);
			BigDecimal bigDValue = new BigDecimal(value);
			operand.setAmount(bigDValue);
			return operand;
		} else {
			return null;
		}
	}

	public boolean validate(String srcText) {
		String regex = EXPRESSION;

		boolean valid = Pattern.matches(regex, srcText);

		return valid;
	}
}
