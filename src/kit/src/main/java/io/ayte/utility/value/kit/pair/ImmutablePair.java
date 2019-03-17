package io.ayte.utility.value.kit.pair;

import io.ayte.utility.value.api.AmplePair;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@RequiredArgsConstructor(access = AccessLevel.PUBLIC)
public class ImmutablePair<A, B> implements AmplePair<A, B> {
    private final A first;
    private final B second;

    public ImmutablePair<A, B> setFirst(A value) {
        return withFirst(value);
    }

    @Override
    public AmplePair<A, B> setSecond(B value) {
        return withSecond(value);
    }

    @Override
    public <A1> ImmutablePair<A1, B> withFirst(A1 first) {
        return new ImmutablePair<>(first, second);
    }

    @Override
    public <B1> ImmutablePair<A, B1> withSecond(B1 second) {
        return new ImmutablePair<>(first, second);
    }

    @Override
    public ImmutablePair<B, A> reverse() {
        return new ImmutablePair<>(second, first);
    }
}
