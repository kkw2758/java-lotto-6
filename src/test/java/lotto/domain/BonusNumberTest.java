package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberTest {
    @DisplayName("당첨 로또에 보너스 숫자가 포함되면 에러 발생")
    @Test
    void bonusNumberInAnswerLottoExceptionTest() {
        // given
        Lotto answerLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6));
        LottoNumber number = LottoNumber.from(6);
        // when & then
        assertThatThrownBy(() -> BonusNumber.of(number, answerLotto))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
    }
}
