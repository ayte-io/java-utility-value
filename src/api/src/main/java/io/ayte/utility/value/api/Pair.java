package io.ayte.utility.value.api;

/**
 * Simple two-value tuple.
 *
 * @param <A> Type of first value.
 * @param <B> Type of second value.
 */
public interface Pair<A, B> {
    A getFirst();
    B getSecond();
}
