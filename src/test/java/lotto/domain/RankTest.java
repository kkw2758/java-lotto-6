package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RankTest {
    @DisplayName("구매한 로또가 몇등 당첨인지 구한다.")
    @Test
    void findRankTest() {
        assertAll(
                () -> assertThat(Rank.findRank(6, false)).isEqualTo(Rank.FIRST),
                () -> assertThat(Rank.findRank(5, true)).isEqualTo(Rank.SECOND),
                () -> assertThat(Rank.findRank(5, false)).isEqualTo(Rank.THIRD),
                () -> assertThat(Rank.findRank(4, false)).isEqualTo(Rank.FOURTH),
                () -> assertThat(Rank.findRank(3, false)).isEqualTo(Rank.FIFTH),
                () -> assertThat(Rank.findRank(2, false)).isEqualTo(Rank.NONE)
        );
    }
}
