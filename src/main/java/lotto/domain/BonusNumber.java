package lotto.domain;

import lotto.exception.ErrorMessage;

public class BonusNumber {

    private final LottoNumber value;

    private BonusNumber(LottoNumber number) {
        this.value = number;
    }

    public LottoNumber getValue() {
        return value;
    }

    public static BonusNumber of(LottoNumber number, Lotto answerLotto) {
        validate(number, answerLotto);
        return new BonusNumber(number);
    }

    private static void validate(LottoNumber number, Lotto answerLotto) {
        if (checkBonusNumberInAnswerLotto(number, answerLotto)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_BONUS_NUMBER.getMessage());
        }
    }

    private static boolean checkBonusNumberInAnswerLotto(LottoNumber number, Lotto answerLotto) {
        return answerLotto.has(number);
    }
}
