package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @DisplayName("로또 번호가 1부터 45 사이의 숫자가 아니라면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 46, 100})
    void lottoNumberExceptionTest(int number) {
        // when & then
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
    }
}
