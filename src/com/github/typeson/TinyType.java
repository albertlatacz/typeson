package com.github.typeson;

import com.googlecode.yadic.Container;
import com.googlecode.yadic.SimpleContainer;

import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

import static com.googlecode.totallylazy.Classes.allClasses;
import static com.googlecode.totallylazy.Unchecked.cast;
import static java.lang.String.format;
import static java.util.Optional.ofNullable;

public class TinyType<T extends Comparable<? super T>, SELF_CLASS extends TinyType<T, SELF_CLASS>> implements Comparable<SELF_CLASS> {
    private final T value;
    private Function<T, SELF_CLASS> constructor;

    public TinyType(T value) {
        if (value == null)
            throw new IllegalArgumentException("value cannot be null");

        this.value = value;
        withConstructor(constructorNotSpecified());
    }

    public TinyType(Function<T, SELF_CLASS> constructor, T value) {
        this(value);
        withConstructor(constructor);
    }

    @SuppressWarnings("unchecked")
    protected void withConstructor(Function<T, SELF_CLASS> constructor) {
        if (constructor == null)
            throw new IllegalArgumentException("constructor cannot be null");

        this.constructor = constructor;
    }

    public T value() {
        return value;
    }

    public <S> S map(Function<? super T, ? extends S> mapper) {
        return mapper.apply(value());
    }

    public <S extends TinyType<T, S>> SELF_CLASS flatMap(Function<? super T, S> function) {
        return valueOf(function.apply(value()).value());
    }

    public void forEach(Consumer<? super T> consumer) {
        consumer.accept(value());
    }

    public boolean exists(Predicate<? super T> predicate) {
        return predicate.test(value());
    }

    public Optional<T> find(Predicate<? super T> predicate) {
        return ofNullable(exists(predicate) ? value() : null);
    }

    @Override
    public String toString() {
        return value.toString();
    }

    @Override
    public boolean equals(Object o) {
        return getClass().isInstance(o) && ((TinyType) o).value().equals(value);
    }

    @Override
    public int hashCode() {
        return value.hashCode();
    }

    @Override
    public int compareTo(SELF_CLASS other) {
        return value.compareTo(other.value());
    }

    protected SELF_CLASS valueOf(T value) {
        return constructor.apply(value);
    }

    protected Function<T, SELF_CLASS> constructorFor(final Class<?> constructorParameterClass) {
        return constructorFor(getClass(), constructorParameterClass);
    }

    public static <_T, _SELF_CLASS> Function<_T, _SELF_CLASS> constructorFor(final Class<?> selfClass, final Class<?> constructorParameterClass) {
        return value -> {
            try {
                return cast(allClasses(constructorParameterClass).delete(Object.class).
                    fold((Container) new SimpleContainer(), (acc, cl) -> acc.addInstance(cast(cl), value)).
                    add(selfClass).
                    get(selfClass));
            } catch (Exception e) {
                throw new TypesonException(format("Could not construct instance of type %s from value of type %s", selfClass, value.getClass()), e);
            }
        };
    }

    private Function<T, SELF_CLASS> constructorNotSpecified() {
        return value1 -> {
           throw new RuntimeException("Constructor not specified");
        };
    }

}
