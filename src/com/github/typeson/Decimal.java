package com.github.typeson;

import com.googlecode.totallylazy.numbers.BigDecimalOperators;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Decimal extends DecimalValue<Decimal> {
    private Decimal(BigDecimal value) {
        super(value, Scale.scale(32), RoundingMode.HALF_EVEN);
    }

    public static Decimal decimal(Number value) {
        return new Decimal(BigDecimalOperators.decimal(value));
    }

}
