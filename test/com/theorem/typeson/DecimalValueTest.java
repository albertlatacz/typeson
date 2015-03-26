package com.theorem.typeson;

import org.hamcrest.Matchers;
import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.assertTrue;

public class DecimalValueTest {

    @Test
    public void supportsSignOperations() {
        assertTrue(SomeDecimal1.someDecimal1(-1).isNegative());
        assertTrue(SomeDecimal1.someDecimal1(0).isZero());
        assertTrue(SomeDecimal1.someDecimal1(1).isPositive());
    }

    @Test
    public void supportsOperationsWithDecimalType() {
        assertThat(SomeDecimal1.someDecimal1(12).add(SomeDecimal2.someDecimal2(30)), Matchers.is(SomeDecimal1.someDecimal1(42)));
        assertThat(SomeDecimal1.someDecimal1(30).subtract(SomeDecimal2.someDecimal2(10)), Matchers.is(SomeDecimal1.someDecimal1(20)));
        assertThat(SomeDecimal1.someDecimal1(3).multiply(SomeDecimal2.someDecimal2(10)), Matchers.is(SomeDecimal1.someDecimal1(30)));
        assertThat(SomeDecimal1.someDecimal1(30).divide(SomeDecimal2.someDecimal2(3)), Matchers.is(SomeDecimal1.someDecimal1(10)));
        assertThat(SomeDecimal1.someDecimal1(10).min(SomeDecimal2.someDecimal2(30)), Matchers.is(SomeDecimal1.someDecimal1(10)));
        assertThat(SomeDecimal1.someDecimal1(10).max(SomeDecimal2.someDecimal2(30)), Matchers.is(SomeDecimal1.someDecimal1(30)));

        assertTrue(SomeDecimal1.someDecimal1(10).equalTo(SomeDecimal2.someDecimal2(10)));
        assertTrue(SomeDecimal1.someDecimal1(20).greaterThan(SomeDecimal2.someDecimal2(10)));
        assertTrue(SomeDecimal1.someDecimal1(10).greaterThanOrEqualTo(SomeDecimal2.someDecimal2(10)));
        assertTrue(SomeDecimal1.someDecimal1(10).lessThan(SomeDecimal2.someDecimal2(20)));
        assertTrue(SomeDecimal1.someDecimal1(10).lessThanOrEqualTo(SomeDecimal2.someDecimal2(10)));
    }

    @Test
    public void supportsOperationsWithIntegerType() {
        assertThat(SomeDecimal1.someDecimal1(12).add(SomeInteger.someInteger(30)), Matchers.is(SomeDecimal1.someDecimal1(42)));
        assertThat(SomeDecimal1.someDecimal1(30).subtract(SomeInteger.someInteger(10)), Matchers.is(SomeDecimal1.someDecimal1(20)));
        assertThat(SomeDecimal1.someDecimal1(3).multiply(SomeInteger.someInteger(10)), Matchers.is(SomeDecimal1.someDecimal1(30)));
        assertThat(SomeDecimal1.someDecimal1(30).divide(SomeInteger.someInteger(3)), Matchers.is(SomeDecimal1.someDecimal1(10)));
        assertThat(SomeDecimal1.someDecimal1(30).min(SomeInteger.someInteger(10)), Matchers.is(SomeDecimal1.someDecimal1(10)));
        assertThat(SomeDecimal1.someDecimal1(30).max(SomeInteger.someInteger(10)), Matchers.is(SomeDecimal1.someDecimal1(30)));

        assertTrue(SomeDecimal1.someDecimal1(10).equalTo(SomeInteger.someInteger(10)));
        assertTrue(SomeDecimal1.someDecimal1(20).greaterThan(SomeInteger.someInteger(10)));
        assertTrue(SomeDecimal1.someDecimal1(10).greaterThanOrEqualTo(SomeInteger.someInteger(10)));
        assertTrue(SomeDecimal1.someDecimal1(10).lessThan(SomeInteger.someInteger(20)));
        assertTrue(SomeDecimal1.someDecimal1(10).lessThanOrEqualTo(SomeInteger.someInteger(10)));
    }

    @Test
    public void supportsOperationsWithNumberType() {
        assertThat(SomeDecimal1.someDecimal1(12).add(30), Matchers.is(SomeDecimal1.someDecimal1(42)));
        assertThat(SomeDecimal1.someDecimal1(30).subtract(10.0d), Matchers.is(SomeDecimal1.someDecimal1(20)));
        assertThat(SomeDecimal1.someDecimal1(3).multiply(10l), Matchers.is(SomeDecimal1.someDecimal1(30)));
        assertThat(SomeDecimal1.someDecimal1(30).divide(3.0f), Matchers.is(SomeDecimal1.someDecimal1(10)));
        assertThat(SomeDecimal1.someDecimal1(30).min(BigDecimal.valueOf(10.0)), Matchers.is(SomeDecimal1.someDecimal1(10)));
        assertThat(SomeDecimal1.someDecimal1(30).max(BigInteger.valueOf(10)), Matchers.is(SomeDecimal1.someDecimal1(30)));

        assertTrue(SomeDecimal1.someDecimal1(10).equalTo(10.00));
        assertTrue(SomeDecimal1.someDecimal1(20).greaterThan(10L));
        assertTrue(SomeDecimal1.someDecimal1(10).greaterThanOrEqualTo(10.00d));
        assertTrue(SomeDecimal1.someDecimal1(10).lessThan(20));
        assertTrue(SomeDecimal1.someDecimal1(10).lessThanOrEqualTo(10.00f));
    }

}