package lotto.domain;

import lotto.domain.Lotto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class LottoTest {
    @DisplayName("로또 번호의 개수가 6개가 넘어가면 예외가 발생한다.")
    @Test
    void createLottoByOverSize() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 6, 7)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 중복된 숫자가 있으면 예외가 발생한다.")
    @Test
    void createLottoByDuplicatedNumber() {
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("로또 번호에 특정한 숫자가 있으면 true, 없으면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"1, true", "6, true", "10, false", "12, false"}, delimiter = ',')
    void lottoHasLottoNumberTest(int number, boolean expected) {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber lottoNumber = LottoNumber.from(number);
        // when
        boolean actual = lotto.has(lottoNumber);

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
