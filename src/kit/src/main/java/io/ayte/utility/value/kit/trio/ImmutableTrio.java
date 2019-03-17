package io.ayte.utility.value.kit.trio;

import io.ayte.utility.value.api.AmpleTrio;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class ImmutableTrio<A, B, C> implements AmpleTrio<A, B, C> {
    private final A first;
    private final B second;
    private final C third;

    @Override
    public <A1> ImmutableTrio<A1, B, C> withFirst(A1 first) {
        return new ImmutableTrio<>(first, second, third);
    }

    @Override
    public <B1> ImmutableTrio<A, B1, C> withSecond(B1 second) {
        return new ImmutableTrio<>(first, second, third);
    }

    @Override
    public <C1> ImmutableTrio<A, B, C1> withThird(C1 third) {
        return new ImmutableTrio<>(first, second, third);
    }

    @Override
    public ImmutableTrio<A, B, C> setFirst(A value) {
        return withFirst(value);
    }

    @Override
    public ImmutableTrio<A, B, C> setSecond(B second) {
        return withSecond(second);
    }

    @Override
    public ImmutableTrio<A, B, C> setThird(C third) {
        return withThird(third);
    }

    @Override
    public ImmutableTrio<C, A, B> rollForward() {
        return new ImmutableTrio<>(third, first, second);
    }

    @Override
    public ImmutableTrio<B, C, A> rollBackward() {
        return new ImmutableTrio<>(second, third, first);
    }

    @Override
    public ImmutableTrio<C, B, A> reverse() {
        return new ImmutableTrio<>(third, second, first);
    }
}
