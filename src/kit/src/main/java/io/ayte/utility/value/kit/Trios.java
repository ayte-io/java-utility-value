package io.ayte.utility.value.kit;

import io.ayte.utility.value.api.AmpleTrio;
import io.ayte.utility.value.api.Trio;
import io.ayte.utility.value.kit.trio.ImmutableTrio;
import io.ayte.utility.value.kit.trio.MutableTrio;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

/**
 * Factory class for {@link Trio} interface.
 */
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Trios {
    public static <F, S, T> AmpleTrio<F, S, T> immutable(F first, S second, T third) {
        return new ImmutableTrio<>(first, second, third);
    }

    public static <F, S, T> AmpleTrio<F, S, T> mutable(F first, S second, T third) {
        return new MutableTrio<>(first, second, third);
    }
}
