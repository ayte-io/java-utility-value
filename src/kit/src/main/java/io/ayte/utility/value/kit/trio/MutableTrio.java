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
public class MutableTrio<A, B, C> implements AmpleTrio<A, B, C> {
    private A first;
    private B second;
    private C third;

    @Override
    public <A1> MutableTrio<A1, B, C> withFirst(A1 first) {
        return new MutableTrio<>(first, second, third);
    }

    @Override
    public <B1> MutableTrio<A, B1, C> withSecond(B1 second) {
        return new MutableTrio<>(first, second, third);
    }

    @Override
    public <C1> MutableTrio<A, B, C1> withThird(C1 third) {
        return new MutableTrio<>(first, second, third);
    }

    @Override
    public MutableTrio<C, A, B> rollForward() {
        return new MutableTrio<>(third, first, second);
    }

    @Override
    public MutableTrio<B, C, A> rollBackward() {
        return new MutableTrio<>(second, third, first);
    }

    @Override
    public MutableTrio<C, B, A> reverse() {
        return new MutableTrio<>(third, second, first);
    }
}
