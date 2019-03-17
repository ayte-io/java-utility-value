package io.ayte.utility.value.kit;

import io.ayte.utility.value.api.AmpleQuad;
import io.ayte.utility.value.api.Quad;
import io.ayte.utility.value.kit.quad.ImmutableQuad;
import io.ayte.utility.value.kit.quad.MutableQuad;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Factory class for {@link Quad} interface.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Quads {
    public static <A, B, C, D> AmpleQuad<A, B, C, D> mutable(A first, B second, C third, D fourth) {
        return new MutableQuad<>(first, second, third, fourth);
    }

    public static <A, B, C, D> AmpleQuad<A, B, C, D> immutable(A first, B second, C third, D fourth) {
        return new ImmutableQuad<>(first, second, third, fourth);
    }
}
