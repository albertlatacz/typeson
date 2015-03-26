package com.github.typeson;

public interface DecimalValueOperations<T> {
    public T multiply(DecimalValue<?> that);
    public T divide(DecimalValue<?> that);
    public T add(DecimalValue<?> that);
    public T subtract(DecimalValue<?> that);
    public T min(DecimalValue<?> that);
    public T max(DecimalValue<?> that);

    public boolean equalTo(DecimalValue<?> that);
    public boolean greaterThan(DecimalValue<?> that);
    public boolean greaterThanOrEqualTo(DecimalValue<?> that);
    public boolean lessThan(DecimalValue<?> that);
    public boolean lessThanOrEqualTo(DecimalValue<?> that);
}
