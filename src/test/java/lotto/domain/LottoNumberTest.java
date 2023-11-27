package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoNumberTest {
    @DisplayName("로또 번호의 숫자 범위가 1 ~ 45 사이가 아니라면 에러 발생")
    @ParameterizedTest
    // given
    @ValueSource(ints = {0, 46})
    void lottoNumberRangeExceptionTest(int number) {
        // when & then
        assertThatThrownBy(() -> LottoNumber.from(number))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
    }
}
