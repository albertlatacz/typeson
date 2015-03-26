package com.github.typeson;

import java.math.BigInteger;

public class Scale extends IntegerValue<Scale> {
    private Scale(BigInteger value) {
        super(value);
    }

    public static Scale scale(Number value) {
        return new Scale(BigInteger.valueOf(value.intValue()));
    }

    protected Scale valueOf(BigInteger other) {
        return scale(other.intValue());
    }
}
