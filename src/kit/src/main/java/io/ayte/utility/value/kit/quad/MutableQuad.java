package io.ayte.utility.value.kit.quad;

import io.ayte.utility.value.api.AmpleQuad;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
public class MutableQuad<A, B, C, D> implements AmpleQuad<A, B, C, D> {
    private A first;
    private B second;
    private C third;
    private D fourth;

    @Override
    public <A1> MutableQuad<A1, B, C, D> withFirst(A1 first) {
        return new MutableQuad<>(first, second, third, fourth);
    }

    @Override
    public <B1> MutableQuad<A, B1, C, D> withSecond(B1 second) {
        return new MutableQuad<>(first, second, third, fourth);
    }

    @Override
    public <C1> MutableQuad<A, B, C1, D> withThird(C1 third) {
        return new MutableQuad<>(first, second, third, fourth);
    }

    @Override
    public <D1> MutableQuad<A, B, C, D1> withFourth(D1 fourth) {
        return new MutableQuad<>(first, second, third, fourth);
    }

    @Override
    public MutableQuad<D, A, B, C> rollForward() {
        return new MutableQuad<>(fourth, first, second, third);
    }

    @Override
    public MutableQuad<B, C, D, A> rollBackward() {
        return new MutableQuad<>(second, third, fourth, first);
    }

    @Override
    public MutableQuad<D, C, B, A> reverse() {
        return new MutableQuad<>(fourth, third, second, first);
    }
}
