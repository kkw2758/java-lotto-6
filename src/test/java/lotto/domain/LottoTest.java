package lotto.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

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
        // TODO: 이 테스트가 통과할 수 있게 구현 코드 작성
        assertThatThrownBy(() -> new Lotto(List.of(1, 2, 3, 4, 5, 5)))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @DisplayName("발행한 로또에 특정 번호가 포함되어 있는지 확인한다.")
    @Test
    void lottoNumberInLottoTest() {
        // given
        LottoNumber lottoNumber = LottoNumber.from(1);
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));

        // when
        boolean actual = lotto.has(lottoNumber);
        boolean expected = true;

        // then
        assertThat(actual).isEqualTo(expected);
    }

    @DisplayName("입력 받은 로또에 대해 일치 하는 로또 번호의 숫자를 구한다.")
    @Test
    void calculateMatchCountTest() {
        // given
        Lotto lotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 7, 8));

        // when
        int actual = lotto.calculateMatchCount(answerLotto);
        int expected = 4;

        // then
        assertThat(actual).isEqualTo(expected);
    }
}
