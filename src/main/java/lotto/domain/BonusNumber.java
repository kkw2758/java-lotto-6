package lotto.domain;


import lotto.exception.ErrorMessage;

public class BonusNumber {

    private final LottoNumber bonusNumber;

    private BonusNumber(LottoNumber bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public static BonusNumber of(LottoNumber bonusNumber, Lotto answerLotto) {
        validate(bonusNumber, answerLotto);
        return new BonusNumber(bonusNumber);
    }

    private static void validate(LottoNumber bonusNumber, Lotto answerLotto) {
        if (checkAnswerLottoHasBonusNumber(bonusNumber, answerLotto)) {
            throw new IllegalArgumentException(ErrorMessage.ANSWER_LOTTO_HAS_BONUS_NUMBER.getMessage());
        }
    }

    private static boolean checkAnswerLottoHasBonusNumber(LottoNumber bonusNumber, Lotto answerLotto) {
        return answerLotto.has(bonusNumber);
    }
}
