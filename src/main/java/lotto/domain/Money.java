package lotto.domain;

import lotto.exception.ErrorMessage;

public class Money {
    private static final int LOTTO_PRICE = 1000;
    private static final int ZERO = 0;

    private final int value;

    public int getValue() {
        return value;
    }

    private Money(int money) {
        value = money;
    }

    public static Money from(int money) {
        validate(money);
        return new Money(money);
    }

    public int calculateLottoBuyCount() {
        return value / LOTTO_PRICE;
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
