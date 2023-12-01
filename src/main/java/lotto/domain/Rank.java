package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, (matchCount, hasBonusNumber) -> matchCount.equals(6)),
    SECOND(5, (matchCount, hasBonusNumber) -> matchCount.equals(5) && hasBonusNumber),
    THIRD(5, (matchCount, hasBonusNumber) -> matchCount.equals(5)),
    FOURTH(4, (matchCount, hasBonusNumber) -> matchCount.equals(4)),
    FIFTH(3, (matchCount, hasBonusNumber) -> matchCount.equals(3)),
    NONE(0, (matchCount, hasBonusNumber) -> matchCount < 3);

    private final int matchCount;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(int matchCount, BiPredicate<Integer, Boolean> condition) {
        this.matchCount = matchCount;
        this.condition = condition;
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.test(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }
}
