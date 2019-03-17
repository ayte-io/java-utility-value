package io.ayte.utility.value.api;

/**
 * Simple three-value container.
 *
 * @param <A> Type of first value
 * @param <B> Type of second value
 * @param <C> Type of third value
 */
public interface Trio<A, B, C> {
    A getFirst();
    B getSecond();
    C getThird();
}
