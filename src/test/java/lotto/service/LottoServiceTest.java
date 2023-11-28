package lotto.service;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Rank;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {
    private static List<Lotto> lottos;
    private static Lotto answerLotto;
    private static BonusNumber bonusNumber;
    private static LottoService lottoService;

    @BeforeEach
    void beforeEach() {
        lottos = new ArrayList<>(List.of(new Lotto(List.of(1, 2, 3, 4, 5, 6)), new Lotto(List.of(2, 3, 4, 5, 6, 7))));
        answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        bonusNumber = BonusNumber.of(LottoNumber.from(7), answerLotto);
        lottoService = new LottoService();
    }

    @DisplayName("당첨 통계 테스트")
    @Test
    void makeRankResultTest() {
        //when
        Map<Rank, Integer> rankResult = lottoService.makeRankResult(lottos, answerLotto, bonusNumber);

        //then
        assertAll(
                () -> assertThat(rankResult.getOrDefault(Rank.FIRST, 0)).isEqualTo(1),
                () -> assertThat(rankResult.getOrDefault(Rank.SECOND, 0)).isEqualTo(1)
        );
    }
    
    @DisplayName("로또 구입 테스트")
    @ParameterizedTest
    @CsvSource(value = {"8000, 8", "10000, 10"}, delimiter = ',')
    void buyLottosTest(int money, int expected) {
        // when
        int actual = lottoService.buyLottos(Money.from(money)).size();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("총 수익률 계산 테스트")
    @ParameterizedTest
    @ValueSource(ints = {8000,10000})
    void calculateEarningRateTest(int money) {
        // given
        Map<Rank, Integer> rankResult = new EnumMap<>(Rank.class);
        rankResult.put(Rank.FIFTH, 1);
        rankResult.put(Rank.FOURTH, 1);

        // when
        double actual = lottoService.calculateEarningRate(rankResult, Money.from(money));
        double expected = (double) (5000 + 50000) / money * 100;

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
