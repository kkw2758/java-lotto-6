package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {

    @DisplayName("로또 구입 금액이 1000원으로 나누어 떨어지지 않으면 예외 발생")
    @ParameterizedTest
    // given
    @ValueSource(ints = {100, 2100})
    void moneyExceptionTest(int money) {
        // when & then
        assertThatThrownBy(() -> Money.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
    }
}
