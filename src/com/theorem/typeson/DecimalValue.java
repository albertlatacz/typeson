package com.theorem.typeson;

import com.googlecode.totallylazy.numbers.Numbers;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.function.Function;

import static com.theorem.typeson.Decimal.decimal;

public abstract class DecimalValue<C extends TinyType<BigDecimal, C>> extends TinyType<BigDecimal, C> implements DecimalValueOperations<C>, IntegerValueOperations<C>, NumberOperations<C>, SignOperations {
    private final Scale scale;
    private final RoundingMode rounding;

    public DecimalValue(BigDecimal value, Scale scale, RoundingMode rounding) {
        super(setScale(value, scale, rounding));
        withConstructor(constructorFor(BigDecimal.class));
        this.scale = scale;
        this.rounding = rounding;
    }

    public DecimalValue(Function<BigDecimal, C> constructor, BigDecimal value, Scale scale, RoundingMode rounding) {
        super(constructor, setScale(value, scale, rounding));
        this.scale = scale;
        this.rounding = rounding;
    }

    private static BigDecimal setScale(BigDecimal value, Scale scale, RoundingMode rounding) {
        try {
            return value != null ? value.setScale(scale.intValue(), rounding) : null;
        } catch (ArithmeticException e) {
            throw new IllegalArgumentException(value + " is incompatible with rounding mode of " + rounding + " given scale of " + scale, e);
        }
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


    public C add(DecimalValue<?> that) {
        return valueOf(value().add(that.value()));
    }

    public C subtract(DecimalValue<?> that) {
        return valueOf(value().subtract(that.value()));
    }

    public C multiply(DecimalValue<?> that) {
        return valueOf(value().multiply(that.value()));
    }

    public C divide(DecimalValue<?> that) {
        return valueOf(value().divide(that.value(), scale.intValue(), rounding));
    }

    public C min(DecimalValue<?> that) {
        return valueOf(value().min(that.value()));
    }

    public C max(DecimalValue<?> that) {
        return valueOf(value().max(that.value()));
    }

    public boolean equalTo(DecimalValue<?> that) {
        return Numbers.equalTo(value(), that.value());
    }

    public boolean greaterThan(DecimalValue<?> that) {
        return Numbers.greaterThan(value(), that.value());
    }

    public boolean greaterThanOrEqualTo(DecimalValue<?> that) {
        return Numbers.greaterThanOrEqualTo(value(), that.value());
    }

    public boolean lessThan(DecimalValue<?> that) {
        return Numbers.lessThan(value(), that.value());
    }

    public boolean lessThanOrEqualTo(DecimalValue<?> that) {
        return Numbers.lessThanOrEqualTo(value(), that.value());
    }


    public C add(IntegerValue<?> that) {
        return add(that.toDecimal());
    }

    public C subtract(IntegerValue<?> that) {
        return subtract(that.toDecimal());
    }

    public C multiply(IntegerValue<?> that) {
        return multiply(that.toDecimal());
    }

    public C divide(IntegerValue<?> that) {
        return divide(that.toDecimal());
    }

    public C min(IntegerValue<?> that) {
        return min(that.toDecimal());
    }

    public C max(IntegerValue<?> that) {
        return max(that.toDecimal());
    }

    public boolean equalTo(IntegerValue<?> that) {
        return equalTo(that.toDecimal());
    }

    public boolean greaterThan(IntegerValue<?> that) {
        return greaterThan(that.toDecimal());
    }

    public boolean greaterThanOrEqualTo(IntegerValue<?> that) {
        return greaterThanOrEqualTo(that.toDecimal());
    }

    public boolean lessThan(IntegerValue<?> that) {
        return lessThan(that.toDecimal());
    }

    public boolean lessThanOrEqualTo(IntegerValue<?> that) {
        return lessThanOrEqualTo(that.toDecimal());
    }


    public C add(Number that) {
        return add(decimal(that));
    }

    public C subtract(Number that) {
        return subtract(decimal(that));
    }

    public C multiply(Number that) {
        return multiply(decimal(that));
    }

    public C divide(Number that) {
        return divide(decimal(that));
    }

    public C min(Number that) {
        return min(decimal(that));
    }

    public C max(Number that) {
        return max(decimal(that));
    }

    public boolean equalTo(Number that) {
        return equalTo(decimal(that));
    }

    public boolean greaterThan(Number that) {
        return greaterThan(decimal(that));
    }

    public boolean greaterThanOrEqualTo(Number that) {
        return greaterThanOrEqualTo(decimal(that));
    }

    public boolean lessThan(Number that) {
        return lessThan(decimal(that));
    }

    public boolean lessThanOrEqualTo(Number that) {
        return lessThanOrEqualTo(decimal(that));
    }

}
