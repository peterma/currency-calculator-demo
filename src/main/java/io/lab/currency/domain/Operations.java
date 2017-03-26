package io.lab.currency.domain;

import java.math.BigDecimal;
import java.math.RoundingMode;

public enum Operations {

	ADD {
		public BigDecimal apply(BigDecimal a, BigDecimal b) {
			return a.add(b);
		}
	},
	SUBTRACT {
		public BigDecimal apply(BigDecimal a, BigDecimal b) {
			return a.subtract(b);
		}
	},
	MULTIPLY {
		public BigDecimal apply(BigDecimal a, BigDecimal b) {
			return a.multiply(b);
		}
	},
	DIVIDE {
		public BigDecimal apply(BigDecimal a, BigDecimal b) {
			return a.divide(b, /* scale= */2, RoundingMode.HALF_UP);
		}
	};

	public abstract BigDecimal apply(BigDecimal a, BigDecimal b);

}
