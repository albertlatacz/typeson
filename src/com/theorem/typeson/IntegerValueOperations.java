package com.theorem.typeson;

public interface IntegerValueOperations<T> {
    public T multiply(IntegerValue<?> that);
    public T divide(IntegerValue<?> that);
    public T add(IntegerValue<?> that);
    public T subtract(IntegerValue<?> that);
    public T min(IntegerValue<?> that);
    public T max(IntegerValue<?> that);

    public boolean equalTo(IntegerValue<?> that);
    public boolean greaterThan(IntegerValue<?> that);
    public boolean greaterThanOrEqualTo(IntegerValue<?> that);
    public boolean lessThan(IntegerValue<?> that);
    public boolean lessThanOrEqualTo(IntegerValue<?> that);
}
