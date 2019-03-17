package io.ayte.utility.value.api;

import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Extended {@link Pair} interface with helper methods.
 *
 * @see io.ayte.utility.value.api
 *
 * @param <A> First value type
 * @param <B> Second value type
 */
public interface AmplePair<A, B> extends Pair<A, B> {
    /**
     * Sets first value to provided argument.
     *
     * @param first Replacement value.
     *
     * @return Same or new instance at the discretion of implementation.
     */
    AmplePair<A, B> setFirst(A first);

    /**
     * Sets second value to provided argument.
     *
     * @param second Replacement value.
     *
     * @return Same or new instance at the discretion of implementation.
     */
    AmplePair<A, B> setSecond(B second);

    /**
     * Creates new instance with first value set to provided argument
     * and second one used from current instance.
     *
     * @param first Replacement for first value.
     * @param <A1> Replacement type.
     *
     * @return New pair instance, regardless of implementation.
     */
    <A1> AmplePair<A1, B> withFirst(A1 first);

    /**
     * Creates new instance with second value set to provided argument
     * and first one used from current instance.
     *
     * @param second Replacement for second value.
     * @param <B1> Replacement type.
     *
     * @return New pair instance, regardless of implementation.
     */
    <B1> AmplePair<A, B1> withSecond(B1 second);

    /**
     * @return New {@link AmplePair} with inverse order of values. It
     * has to be new even if mutable implementation is used.
     */
    default AmplePair<B, A> reverse() {
        return withFirst(getSecond())
                .withSecond(getFirst());
    }

    default <A1> AmplePair<A1, B> mapFirst(@NonNull Function<? super A, ? extends A1> transformer) {
        return withFirst(transformer.apply(getFirst()));
    }

    default <B1> AmplePair<A, B1> mapSecond(@NonNull Function<? super B, ? extends B1> transformer) {
        return withSecond(transformer.apply(getSecond()));
    }

    /**
     * @return Stream consisting of current pair only.
     */
    default Stream<AmplePair<A, B>> stream() {
        return Stream.of(this);
    }
}
