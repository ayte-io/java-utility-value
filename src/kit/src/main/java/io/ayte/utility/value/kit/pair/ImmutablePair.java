package io.ayte.utility.value.kit.pair;

import io.ayte.utility.value.api.AmplePair;
import lombok.Data;

@Data
public class ImmutablePair<F, S> implements AmplePair<F, S> {
    private final F first;
    private final S second;

    public ImmutablePair<F, S> setFirst(F value) {
        return withFirst(value);
    }

    @Override
    public AmplePair<F, S> setSecond(S value) {
        return withSecond(value);
    }

    @Override
    public <V> ImmutablePair<V, S> withFirst(V value) {
        return new ImmutablePair<>(value, second);
    }

    @Override
    public <V> ImmutablePair<F, V> withSecond(V value) {
        return new ImmutablePair<>(first, value);
    }

    @Override
    public ImmutablePair<S, F> reverse() {
        return new ImmutablePair<>(second, first);
    }
}
