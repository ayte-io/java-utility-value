package io.ayte.utility.value.api;

/**
 * Four-value container.
 *
 * @param <A> First value type
 * @param <B> Second value type
 * @param <C> Third value type
 * @param <D> Fourth value type
 */
public interface Quad<A, B, C, D> {
    A getFirst();
    B getSecond();
    C getThird();
    D getFourth();
}
