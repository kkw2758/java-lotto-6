package lotto;

import constants.NumberType;

public class BonusNumber {

    private final int bonusNumber;

    public BonusNumber(int bonusNumber, AnswerLotto answerLotto) {
        validateBonusNumber(bonusNumber, answerLotto);
        this.bonusNumber = bonusNumber;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    private void validateBonusNumber(int bonusNumber, AnswerLotto answerLotto) {
        validateBonusNumberInAnswerLotto(bonusNumber, answerLotto);
        validateInRange(bonusNumber);
    }

    private void validateBonusNumberInAnswerLotto(int bonusNumber, AnswerLotto answerLotto) {
        if (checkBonusNumberInAnswerLotto(bonusNumber, answerLotto)) {
            throw new IllegalArgumentException("당첨번호에 포함된 숫자는 보너스 번호가 될 수 없습니다.");
        }
    }

    private boolean checkBonusNumberInAnswerLotto(int bonusNumber, AnswerLotto answerLotto) {
        return answerLotto.hasNumber(bonusNumber);
    }

    private void validateInRange(int bonusNumber) {
        if (checkBonusNumberInRange(bonusNumber)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean checkBonusNumberInRange(int bonusNumber) {
        return bonusNumber >= NumberType.MIN_LOTTO_NUMBER.getValue()
                && bonusNumber <= NumberType.MAX_LOTTO_NUMBER.getValue();
    }
}
