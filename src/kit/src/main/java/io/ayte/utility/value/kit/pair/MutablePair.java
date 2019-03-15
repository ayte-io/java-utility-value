package io.ayte.utility.value.kit.pair;

import io.ayte.utility.value.api.AmplePair;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MutablePair<F, S> implements AmplePair<F, S> {
    private F first;
    private S second;

    @Override
    public <V> MutablePair<V, S> withFirst(V value) {
        return new MutablePair<>(value, second);
    }

    @Override
    public <V> MutablePair<F, V> withSecond(V value) {
        return new MutablePair<>(first, value);
    }

    @Override
    public MutablePair<S, F> reverse() {
        return new MutablePair<>(second, first);
    }
}
