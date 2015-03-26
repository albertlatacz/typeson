package com.github.typeson;

public interface NumberOperations<T> {
    public T multiply(Number that);
    public T divide(Number that);
    public T add(Number that);
    public T subtract(Number that);
    public T min(Number that);
    public T max(Number that);

    public boolean equalTo(Number that);
    public boolean greaterThan(Number that);
    public boolean greaterThanOrEqualTo(Number that);
    public boolean lessThan(Number that);
    public boolean lessThanOrEqualTo(Number that);
}
