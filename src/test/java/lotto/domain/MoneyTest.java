package lotto.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import lotto.exception.ErrorMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class MoneyTest {
    @DisplayName("로또 구입 금액이 0원이거나 1,000원으로 나누어 떨어지지 않으면 예외 처리한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 100, 1200})
    void moneyExceptionTest(int money) {
        // when & then
        assertThatThrownBy(() -> Money.from(money))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.INVALID_MONEY.getMessage());
    }

    @DisplayName("입력 받은 금액으로 살 수 있는 로또의 개수를 구한다.")
    @ParameterizedTest
    @CsvSource(value = {"1000, 1", "3000, 3", "12000, 12"}, delimiter = ',')
    void calculateLottoBuyCountTest(int money, int expected) {
        // when & then
        assertThat(Money.from(money).calculateLottoBuyCount()).isEqualTo(expected);
    }
}
