package io.ayte.utility.value.api;

/**
 * Simple three-value container.
 *
 * @param <F> Type of first value
 * @param <S> Type of second value
 * @param <T> Type of third value
 */
public interface Trio<F, S, T> {
    F getFirst();
    S getSecond();
    T getThird();
}
