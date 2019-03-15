package io.ayte.utility.value.kit.trio;

import io.ayte.utility.value.api.AmpleTrio;
import lombok.Data;

@Data
public class ImmutableTrio<F, S, T> implements AmpleTrio<F, S, T> {
    private final F first;
    private final S second;
    private final T third;

    @Override
    public ImmutableTrio<F, S, T> setFirst(F value) {
        return withFirst(value);
    }

    @Override
    public ImmutableTrio<F, S, T> setSecond(S second) {
        return withSecond(second);
    }

    @Override
    public ImmutableTrio<F, S, T> setThird(T third) {
        return withThird(third);
    }

    @Override
    public <V> ImmutableTrio<V, S, T> withFirst(V value) {
        return new ImmutableTrio<>(value, second, third);
    }

    @Override
    public <V> ImmutableTrio<F, V, T> withSecond(V value) {
        return new ImmutableTrio<>(first, value, third);
    }

    @Override
    public <V> ImmutableTrio<F, S, V> withThird(V value) {
        return new ImmutableTrio<>(first, second, value);
    }

    @Override
    public ImmutableTrio<T, F, S> rotate() {
        return new ImmutableTrio<>(third, first, second);
    }

    @Override
    public ImmutableTrio<T, S, F> reverse() {
        return new ImmutableTrio<>(third, second, first);
    }
}
