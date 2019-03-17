package io.ayte.utility.value.api;

import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Extended {@link Trio} with helper methods.
 *
 * @see io.ayte.utility.value.api
 */
public interface AmpleTrio<A, B, C> extends Trio<A, B, C> {
    AmpleTrio<A, B, C> setFirst(A value);
    AmpleTrio<A, B, C> setSecond(B second);
    AmpleTrio<A, B, C> setThird(C third);

    /**
     * @param first Replacement value.
     * @param <A1> Replacement type.
     *
     * @return New {@link AmpleTrio} (regardless whether it called on
     * mutable or immutable implementation) with first value set to
     * provided argument.
     */
    <A1> AmpleTrio<A1, B, C> withFirst(A1 first);

    /**
     * @param second Replacement value.
     * @param <B1> Replacement type.
     *
     * @return New {@link AmpleTrio} (regardless whether it called on
     * mutable or immutable implementation) with second value set to
     * provided argument.
     */
    <B1> AmpleTrio<A, B1, C> withSecond(B1 second);

    /**
     * @param third Replacement value.
     * @param <C1> Replacement type.
     *
     * @return New {@link AmpleTrio} (regardless whether it called on
     * mutable or immutable implementation) with third value set to
     * provided argument.
     */
    <C1> AmpleTrio<A, B, C1> withThird(C1 third);

    default AmpleTrio<C, A, B> rollForward() {
        return withFirst(getThird())
                .withSecond(getFirst())
                .withThird(getSecond());
    }

    default AmpleTrio<B, C, A> rollBackward() {
        return withFirst(getSecond())
                .withSecond(getThird())
                .withThird(getFirst());
    }

    default AmpleTrio<C, B, A> reverse() {
        return withFirst(getThird())
                .withThird(getFirst());
    }

    default <A1> AmpleTrio<A1, B, C> mapFirst(@NonNull Function<? super A, ? extends A1> transformer) {
        return withFirst(transformer.apply(getFirst()));
    }

    default <B1> AmpleTrio<A, B1, C> mapSecond(@NonNull Function<? super B, ? extends B1> transformer) {
        return withSecond(transformer.apply(getSecond()));
    }

    default <C1> AmpleTrio<A, B, C1> mapThird(@NonNull Function<? super C, ? extends C1> transformer) {
        return withThird(transformer.apply(getThird()));
    }

    default Stream<AmpleTrio<A, B, C>> stream() {
        return Stream.of(this);
    }
}
