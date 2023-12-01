package lotto.domain;


import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import java.util.List;
import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("당첨 로또에 보너스 번호가 포함되면 예외 처리한다.")
    @Test
    void bonusNumberExceptionTest() {
        // given
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber bonusNumber = LottoNumber.from(1);

        // when & then
        assertThatThrownBy(() -> BonusNumber.of(bonusNumber, answerLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.ANSWER_LOTTO_HAS_BONUS_NUMBER.getMessage());
    }
}
