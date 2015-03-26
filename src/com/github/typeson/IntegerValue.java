package com.github.typeson;

import com.googlecode.totallylazy.numbers.Numbers;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.function.Function;

public abstract class IntegerValue<T extends TinyType<BigInteger, T>> extends TinyType<BigInteger, T> implements IntegerValueOperations<T>, DecimalValueOperations<Decimal>, NumberOperations<Decimal>, SignOperations {
    public IntegerValue(BigInteger value) {
        super(value);
        withConstructor(constructorFor(BigInteger.class));
    }

    public IntegerValue(Function<BigInteger, T> constructor, BigInteger value) {
        super(constructor, value);
    }

    public boolean isZero() {
        return Numbers.isZero(value());
    }

    public boolean isPositive() {
        return Numbers.isPositive(value());
    }

    public boolean isNegative() {
        return Numbers.isNegative(value());
    }

    public T add(IntegerValue<?> that) {
        return valueOf(value().add(that.value()));
    }

    public T subtract(IntegerValue<?> that) {
        return valueOf(value().subtract(that.value()));
    }

    public T multiply(IntegerValue<?> that) {
        return valueOf(value().multiply(that.value()));
    }

    public T divide(IntegerValue<?> that) {
        return valueOf(value().divide(that.value()));
    }

    public T min(IntegerValue<?> that) {
        return valueOf(value().min(that.value()));
    }

    public T max(IntegerValue<?> that) {
        return valueOf(value().max(that.value()));
    }

    public boolean equalTo(IntegerValue<?> that) {
        return Numbers.equalTo(value(), that.value());
    }

    public boolean greaterThan(IntegerValue<?> that) {
        return Numbers.greaterThan(value(), that.value());
    }

    public boolean greaterThanOrEqualTo(IntegerValue<?> that) {
        return Numbers.greaterThanOrEqualTo(value(), that.value());
    }

    public boolean lessThan(IntegerValue<?> that) {
        return Numbers.lessThan(value(), that.value());
    }

    public boolean lessThanOrEqualTo(IntegerValue<?> that) {
        return Numbers.lessThanOrEqualTo(value(), that.value());
    }


    public Decimal add(DecimalValue<?> that) {
        return toDecimal().add(that);
    }

    public Decimal subtract(DecimalValue<?> that) {
        return toDecimal().subtract(that);
    }

    public Decimal multiply(DecimalValue<?> that) {
        return toDecimal().multiply(that);
    }

    public Decimal divide(DecimalValue<?> that) {
        return toDecimal().divide(that);
    }

    public Decimal min(DecimalValue<?> that) {
        return toDecimal().min(that);
    }

    public Decimal max(DecimalValue<?> that) {
        return toDecimal().max(that);
    }

    public boolean equalTo(DecimalValue<?> that) {
        return toDecimal().equalTo(that);
    }

    public boolean greaterThan(DecimalValue<?> that) {
        return toDecimal().greaterThan(that);
    }

    public boolean greaterThanOrEqualTo(DecimalValue<?> that) {
        return toDecimal().greaterThanOrEqualTo(that);
    }

    public boolean lessThan(DecimalValue<?> that) {
        return toDecimal().lessThan(that);
    }

    public boolean lessThanOrEqualTo(DecimalValue<?> that) {
        return toDecimal().lessThanOrEqualTo(that);
    }


    public Decimal add(Number that) {
        return add(Decimal.decimal(that));
    }

    public Decimal subtract(Number that) {
        return subtract(Decimal.decimal(that));
    }

    public Decimal multiply(Number that) {
        return multiply(Decimal.decimal(that));
    }

    public Decimal divide(Number that) {
        return divide(Decimal.decimal(that));
    }

    public Decimal min(Number that) {
        return min(Decimal.decimal(that));
    }

    public Decimal max(Number that) {
        return max(Decimal.decimal(that));
    }

    public boolean equalTo(Number that) {
        return equalTo(Decimal.decimal(that));
    }

    public boolean greaterThan(Number that) {
        return greaterThan(Decimal.decimal(that));
    }

    public boolean greaterThanOrEqualTo(Number that) {
        return greaterThanOrEqualTo(Decimal.decimal(that));
    }

    public boolean lessThan(Number that) {
        return lessThan(Decimal.decimal(that));
    }

    public boolean lessThanOrEqualTo(Number that) {
        return lessThanOrEqualTo(Decimal.decimal(that));
    }

    public BigDecimal toBigDecimal() {
        return new BigDecimal(value());
    }

    public Decimal toDecimal() {
        return Decimal.decimal(toBigDecimal());
    }

    public int intValue() {
        return value().intValue();
    }
}