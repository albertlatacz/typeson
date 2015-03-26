package com.github.typeson;

import com.googlecode.totallylazy.numbers.BigDecimalOperators;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SomeDecimal1 extends DecimalValue<SomeDecimal1> {
    public SomeDecimal1(BigDecimal value) {
        super(value, Scale.scale(32), RoundingMode.HALF_EVEN);
    }

    public static SomeDecimal1 someDecimal1(Number value) {
        return new SomeDecimal1(BigDecimalOperators.decimal(value));
    }
}
