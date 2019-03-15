package io.ayte.utility.value.kit.trio;

import io.ayte.utility.value.api.AmpleTrio;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class MutableTrio<F, S, T> implements AmpleTrio<F, S, T> {
    private F first;
    private S second;
    private T third;

    @Override
    public <V> MutableTrio<V, S, T> withFirst(V value) {
        return new MutableTrio<>(value, second, third);
    }

    @Override
    public <V> MutableTrio<F, V, T> withSecond(V value) {
        return new MutableTrio<>(first, value, third);
    }

    @Override
    public <V> MutableTrio<F, S, V> withThird(V value) {
        return new MutableTrio<>(first, second, value);
    }

    @Override
    public MutableTrio<T, F, S> rotate() {
        return new MutableTrio<>(third, first, second);
    }

    @Override
    public MutableTrio<T, S, F> reverse() {
        return new MutableTrio<>(third, second, first);
    }
}
