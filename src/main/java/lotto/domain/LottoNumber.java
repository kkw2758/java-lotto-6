package lotto.domain;

import lotto.exception.ErrorMessage;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;

    private final int value;

    private LottoNumber(int number) {
        value = number;
    }

    public static LottoNumber from(int number) {
        validateLottoNumber(number);
        return new LottoNumber(number);
    }

    public int getValue() {
        return value;
    }

    private static void validateLottoNumber(int number) {
        if (checkLottoNumberNotInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean checkLottoNumberNotInRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }
}
