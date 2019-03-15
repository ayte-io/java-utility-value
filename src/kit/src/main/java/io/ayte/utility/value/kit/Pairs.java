package io.ayte.utility.value.kit;

import io.ayte.utility.value.api.AmplePair;
import io.ayte.utility.value.kit.pair.ImmutablePair;
import io.ayte.utility.value.kit.pair.MutablePair;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Pairs {
    public static <F, S> AmplePair<F, S> immutable(F first, S second) {
        return new ImmutablePair<>(first, second);
    }

    public static <F, S> AmplePair<F, S> mutable(F first, S second) {
        return new MutablePair<>(first, second);
    }
}
