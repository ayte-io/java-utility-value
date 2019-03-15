package io.ayte.utility.value.api;

import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Extended {@link Trio} with bunch of helper methods.
 */
public interface AmpleTrio<F, S, T> extends Trio<F, S, T> {
    AmpleTrio<F, S, T> setFirst(F value);
    AmpleTrio<F, S, T> setSecond(S second);
    AmpleTrio<F, S, T> setThird(T third);

    /**
     * @return New {@link AmpleTrio} (regardless whether it called on
     * mutable or immutable implementation) with first value set to
     * provided argument.
     */
    <V> AmpleTrio<V, S, T> withFirst(V value);

    /**
     * @return New {@link AmpleTrio} (regardless whether it called on
     * mutable or immutable implementation) with second value set to
     * provided argument.
     */
    <V> AmpleTrio<F, V, T> withSecond(V value);

    /**
     * @return New {@link AmpleTrio} (regardless whether it called on
     * mutable or immutable implementation) with third value set to
     * provided argument.
     */
    <V> AmpleTrio<F, S, V> withThird(V value);


    default AmpleTrio<T, F, S> rotate() {
        return withFirst(getThird())
                .withSecond(getFirst())
                .withThird(getSecond());
    }

    default AmpleTrio<T, S, F> reverse() {
        return withFirst(getThird())
                .withThird(getFirst());
    }

    default <F1> AmpleTrio<F1, S, T> mapFirst(@NonNull Function<? super F, ? extends F1> transformer) {
        return withFirst(transformer.apply(getFirst()));
    }

    default <S1> AmpleTrio<F, S1, T> mapSecond(@NonNull Function<? super S, ? extends S1> transformer) {
        return withSecond(transformer.apply(getSecond()));
    }

    default <T1> AmpleTrio<F, S, T1> mapThird(@NonNull Function<? super T, ? extends T1> transformer) {
        return withThird(transformer.apply(getThird()));
    }

    default Stream<AmpleTrio<F, S, T>> stream() {
        return Stream.of(this);
    }
}
