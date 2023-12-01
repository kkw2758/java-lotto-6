package lotto.domain;

import java.util.Arrays;
import java.util.function.BiPredicate;

public enum Rank {
    FIRST(6, 2_000_000_000, (matchCount, hasBonusNumber) -> matchCount.equals(6)),
    SECOND(5, 30_000_000, (matchCount, hasBonusNumber) -> matchCount.equals(5) && hasBonusNumber),
    THIRD(5, 1_500_000, (matchCount, hasBonusNumber) -> matchCount.equals(5)),
    FOURTH(4, 50_000, (matchCount, hasBonusNumber) -> matchCount.equals(4)),
    FIFTH(3, 5_000, (matchCount, hasBonusNumber) -> matchCount.equals(3)),
    NONE(0, 0, (matchCount, hasBonusNumber) -> matchCount < 3);

    private final int matchCount;
    private final int price;
    private final BiPredicate<Integer, Boolean> condition;

    Rank(int matchCount, int price, BiPredicate<Integer, Boolean> condition) {
        this.matchCount = matchCount;
        this.price = price;
        this.condition = condition;
    }

    public int getPrice() {
        return price;
    }

    public static Rank findRank(int matchCount, boolean hasBonusNumber) {
        return Arrays.stream(Rank.values())
                .filter(rank -> rank.condition.test(matchCount, hasBonusNumber))
                .findFirst()
                .orElse(NONE);
    }
}
