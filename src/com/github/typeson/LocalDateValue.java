package com.github.typeson;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAmount;

public abstract class LocalDateValue<T extends TinyType<LocalDate,T>> extends TinyType<LocalDate,T> {
    protected LocalDateValue(LocalDate value) {
        super(value);
    }

    public T add(TemporalAmount amount) {
        return valueOf(value().plus(amount));
    }

    public T subtract(TemporalAmount amount) {
        return valueOf(value().minus(amount));
    }

    public String format(DateTimeFormatter formatter) {
        return formatter.format(value());
    }
}
