package com.github.typeson;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SomeDecimal2 extends DecimalValue<SomeDecimal2> {
    public SomeDecimal2(BigDecimal value) {
        super(value, Scale.scale(32), RoundingMode.HALF_EVEN);
    }

    public static SomeDecimal2 someDecimal2(int value) {
        return new SomeDecimal2(BigDecimal.valueOf(value));
    }
}
