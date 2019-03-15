package io.ayte.utility.value.api;

/**
 * Simple two-value tuple.
 *
 * @param <F> Type of first value.
 * @param <S> Type of second value.
 */
public interface Pair<F, S> {
    F getFirst();
    S getSecond();
}
