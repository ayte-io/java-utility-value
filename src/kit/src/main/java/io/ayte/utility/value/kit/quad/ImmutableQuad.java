package io.ayte.utility.value.kit.quad;

import io.ayte.utility.value.api.AmpleQuad;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class ImmutableQuad<A, B, C, D> implements AmpleQuad<A, B, C, D> {
    private final A first;
    private final B second;
    private final C third;
    private final D fourth;

    @Override
    public <A1> ImmutableQuad<A1, B, C, D> withFirst(A1 first) {
        return new ImmutableQuad<>(first, second, third, fourth);
    }

    @Override
    public <B1> ImmutableQuad<A, B1, C, D> withSecond(B1 second) {
        return new ImmutableQuad<>(first, second, third, fourth);
    }

    @Override
    public <C1> ImmutableQuad<A, B, C1, D> withThird(C1 third) {
        return new ImmutableQuad<>(first, second, third, fourth);
    }

    @Override
    public <D1> ImmutableQuad<A, B, C, D1> withFourth(D1 fourth) {
        return new ImmutableQuad<>(first, second, third, fourth);
    }

    @Override
    public ImmutableQuad<A, B, C, D> setFirst(A first) {
        return withFirst(first);
    }

    @Override
    public ImmutableQuad<A, B, C, D> setSecond(B second) {
        return withSecond(second);
    }

    @Override
    public ImmutableQuad<A, B, C, D> setThird(C third) {
        return withThird(third);
    }

    @Override
    public ImmutableQuad<A, B, C, D> setFourth(D fourth) {
        return withFourth(fourth);
    }

    @Override
    public ImmutableQuad<D, A, B, C> rollForward() {
        return new ImmutableQuad<>(fourth, first, second, third);
    }

    @Override
    public ImmutableQuad<B, C, D, A> rollBackward() {
        return new ImmutableQuad<>(second, third, fourth, first);
    }

    @Override
    public ImmutableQuad<D, C, B, A> reverse() {
        return new ImmutableQuad<>(fourth, third, second, first);
    }
}
