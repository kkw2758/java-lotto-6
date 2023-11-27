package lotto.domain;

import lotto.exception.ErrorMessage;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private final int value;

    private Money(int money) {
        value = money;
    }

    public static Money from(int money) {
        validate(money);
        return new Money(money);
    }

    public int getValue() {
        return value;
    }

    private static void validate(int money) {
        if (checkDivideByLottoPrice(money)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    private static boolean checkDivideByLottoPrice(int money) {
        return money % LOTTO_PRICE != ZERO;
    }
}
