package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(2_000_000_000, (matchCount, bonusNumber) -> matchCount.equals(6)),
    SECOND(30_000_000,(matchCount, bonusNumber) -> matchCount.equals(5) && bonusNumber),
    THIRD(1_500_000, (matchCount, bonusNumber) -> matchCount.equals(5)),
    FOURTH(50_000, (matchCount, bonusNumber) -> matchCount.equals(4)),
    FIFTH(5_000, (matchCount, bonusNumber) -> matchCount.equals(3)),
    NONE(0, (matchCount, bonusNumber) -> matchCount < 3);

    private final int prizeMoney;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(int prizeMoney, BiPredicate<Integer, Boolean> condition) {
        this.prizeMoney = prizeMoney;
        this.condition = condition;
    }

    public int getPrizeMoney() {
        return prizeMoney;
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.test(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }
}
