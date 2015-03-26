package com.theorem.typeson;

import org.hamcrest.core.Is;
import org.junit.Test;

import java.util.Optional;

import static com.theorem.typeson.TinyTypeTest.SomeTinyType.someTinyType;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TinyTypeTest {

    @Test
    public void supportsBasicFunctionalOperations() {
        assertThat(someTinyType("hello").map(String::toUpperCase), is("HELLO"));
        assertThat(someTinyType("hello").flatMap(x -> someTinyType(x.toUpperCase())), Is.is(someTinyType("HELLO")));
        assertThat(someTinyType("hello").exists(x -> x.equals("hello")), is(true));
        assertThat(someTinyType("hello").find(x -> x.equals("hello")), is(Optional.of("hello")));
        assertThat(someTinyType("hello").find(x -> x.equals("not found")), is(Optional.<String>empty()));
    }

    public static class SomeTinyType extends TinyType<String, SomeTinyType> {
        private SomeTinyType(String value) {
            super(constructorFor(SomeTinyType.class, String.class), value);
        }

        public static SomeTinyType someTinyType(String value) {
            return new SomeTinyType(value);
        }
    }
}