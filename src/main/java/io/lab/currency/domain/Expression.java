package io.lab.currency.domain;

import java.util.Currency;

public class Expression {

	private Operand firstOperand;
	private Operand secondOperand;
	private Operations operation;
	private Currency targetCurrency;

	public Expression(Operand firstOperand, Operand secondOperand, Operations operation, Currency targetCurrency) {
		this.firstOperand = firstOperand;
		this.secondOperand = secondOperand;
		this.operation = operation;
		this.targetCurrency = targetCurrency;
	}

	public Operand getFirstOperand() {
		return firstOperand;
	}

	public void setFirstOperand(Operand firstOperand) {
		this.firstOperand = firstOperand;
	}

	public Operand getSecondOperand() {
		return secondOperand;
	}

	public void setSecondOperand(Operand secondOperand) {
		this.secondOperand = secondOperand;
	}

	public Currency getTargetCurrency() {
		return targetCurrency;
	}

	public void setTargetCurrency(Currency targetCurrency) {
		this.targetCurrency = targetCurrency;
	}

	public Operations getOperation() {
		return operation;
	}

	public void setOperation(Operations operation) {
		this.operation = operation;
	}

	@Override
	public String toString() {
		return "Expression [firstOperand=" + firstOperand + ", secondOperand=" + secondOperand + ", operation=" + operation + ", targetCurrency="
				+ targetCurrency + "]";
	}

}
