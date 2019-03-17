package io.ayte.utility.value.api;

import lombok.NonNull;

import java.util.function.Function;
import java.util.stream.Stream;

/**
 * Extended {@link Quad} with helper methods.
 *
 * @see io.ayte.utility.value.api
 *
 * @param <A> First value type
 * @param <B> Second value type
 * @param <C> Third value type
 * @param <D> Fourth value type
 */
public interface AmpleQuad<A, B, C, D> extends Quad<A, B, C, D> {
    AmpleQuad<A, B, C, D> setFirst(A first);

    AmpleQuad<A, B, C, D> setSecond(B second);

    AmpleQuad<A, B, C, D> setThird(C third);

    AmpleQuad<A, B, C, D> setFourth(D fourth);

    <A1> AmpleQuad<A1, B, C, D> withFirst(A1 first);

    <B1> AmpleQuad<A, B1, C, D> withSecond(B1 second);

    <C1> AmpleQuad<A, B, C1, D> withThird(C1 third);

    <D1> AmpleQuad<A, B, C, D1> withFourth(D1 fourth);

    default AmpleQuad<D, A, B, C> rollForward() {
        return withFirst(getFourth())
                .withSecond(getFirst())
                .withThird(getSecond())
                .withFourth(getThird());
    }

    default AmpleQuad<B, C, D, A> rollBackward() {
        return withFirst(getSecond())
                .withSecond(getThird())
                .withThird(getFourth())
                .withFourth(getFirst());
    }

    default AmpleQuad<D, C, B, A> reverse() {
        return withFirst(getFourth())
                .withSecond(getThird())
                .withThird(getSecond())
                .withFourth(getFirst());
    }

    default <A1> AmpleQuad<A1, B, C, D> mapFirst(@NonNull Function<? super A, ? extends A1> transformer) {
        return withFirst(transformer.apply(getFirst()));
    }

    default <B1> AmpleQuad<A, B1, C, D> mapSecond(@NonNull Function<? super B, ? extends B1> transformer) {
        return withSecond(transformer.apply(getSecond()));
    }

    default <C1> AmpleQuad<A, B, C1, D> mapThird(@NonNull Function<? super C, ? extends C1> transformer) {
        return withThird(transformer.apply(getThird()));
    }

    default <D1> AmpleQuad<A, B, C, D1> mapFourth(@NonNull Function<? super D, ? extends D1> transformer) {
        return withFourth(transformer.apply(getFourth()));
    }

    default Stream<Quad<A, B, C, D>> stream() {
        return Stream.of(this);
    }
}
