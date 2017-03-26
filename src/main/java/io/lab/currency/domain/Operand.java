package io.lab.currency.domain;

import java.math.BigDecimal;
import java.util.Currency;

public class Operand {
	private Currency currency;
	private BigDecimal amount;

	public Currency getCurrency() {
		return currency;
	}

	public void setCurrency(Currency currency) {
		this.currency = currency;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	@Override
	public String toString() {
		return "Operand [currency=" + currency + ", amount=" + amount + "]";
	}

}
