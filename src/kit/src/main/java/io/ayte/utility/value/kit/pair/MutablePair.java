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
public class MutablePair<A, B> implements AmplePair<A, B> {
    private A first;
    private B second;

    @Override
    public <A1> MutablePair<A1, B> withFirst(A1 first) {
        return new MutablePair<>(first, second);
    }

    @Override
    public <B1> MutablePair<A, B1> withSecond(B1 second) {
        return new MutablePair<>(first, second);
    }

    @Override
    public MutablePair<B, A> reverse() {
        return new MutablePair<>(second, first);
    }
}
