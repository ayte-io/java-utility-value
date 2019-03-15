package io.ayte.utility.value.api;

import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Extended {@link Pair} interface with helper methods.
 *
 * @param <F>
 * @param <S>
 */
public interface AmplePair<F, S> extends Pair<F, S> {
    /**
     * Sets first value to provided argument.
     *
     * @return Same or new instance at the discretion of implementation.
     */
    AmplePair<F, S> setFirst(F value);

    /**
     * Sets second value to provided argument.
     *
     * @return Same or new instance at the discretion of implementation.
     */
    AmplePair<F, S> setSecond(S value);

    /**
     * Creates new instance with first value set to provided argument
     * and second one used from current instance.
     *
     * @return New pair instance, regardless of implementation.
     */
    <V> AmplePair<V, S> withFirst(V value);

    /**
     * Creates new instance with second value set to provided argument
     * and first one used from current instance.
     *
     * @return New pair instance, regardless of implementation.
     */
    <V> AmplePair<F, V> withSecond(V value);

    /**
     * @return New {@link AmplePair} with inverse order of values. It
     * has to be new even if mutable implementation is used.
     */
    default AmplePair<S, F> reverse() {
        return withFirst(getSecond())
                .withSecond(getFirst());
    }

    default <F1> AmplePair<F1, S> mapFirst(@NonNull Function<? super F, ? extends F1> transformer) {
        return withFirst(transformer.apply(getFirst()));
    }

    default <S2> AmplePair<F, S2> mapSecond(@NonNull Function<? super S, ? extends S2> transformer) {
        return withSecond(transformer.apply(getSecond()));
    }

    /**
     * @return Stream consisting of current pair only.
     */
    default Stream<AmplePair<F, S>> stream() {
        return Stream.of(this);
    }
}
