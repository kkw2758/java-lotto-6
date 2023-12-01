package lotto.domain;

import java.util.Objects;
import lotto.exception.ErrorMessage;

public class LottoNumber {
    private static final int MIN_LOTTO_NUMBER = 1;
    private static final int MAX_LOTTO_NUMBER = 45;
    private final int value;

    private LottoNumber(int number) {
        value = number;
    }

    public static LottoNumber from(int number) {
        validate(number);
        return new LottoNumber(number);
    }

    public int getValue() {
        return value;
    }

    private static void validate(int number) {
        if (checkNumberNotInRange(number)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_NUMBER.getMessage());
        }
    }

    private static boolean checkNumberNotInRange(int number) {
        return number < MIN_LOTTO_NUMBER || number > MAX_LOTTO_NUMBER;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        LottoNumber that = (LottoNumber) o;
        return value == that.value;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
