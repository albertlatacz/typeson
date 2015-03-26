package com.github.typeson;

import com.googlecode.totallylazy.numbers.BigIntegerOperators;

import java.math.BigInteger;

public class Integer extends IntegerValue<Integer> {
    protected Integer(BigInteger value) {
        super(value);
    }

    public static Integer integer(Number value) {
        return new Integer(BigIntegerOperators.bigInteger(value));
    }
}
