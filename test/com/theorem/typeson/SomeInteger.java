package com.theorem.typeson;

import java.math.BigInteger;

class SomeInteger extends IntegerValue<SomeInteger> {
    private SomeInteger(BigInteger value) {
        super(value);
    }

    protected static SomeInteger someInteger(int value) {
        return new SomeInteger(BigInteger.valueOf(value));
    }

    protected SomeInteger valueOf(BigInteger other) {
        return new SomeInteger(other);
    }
}
