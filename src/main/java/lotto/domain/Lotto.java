package lotto.domain;

import java.util.List;
import lotto.exception.ErrorMessage;

public class Lotto {
    private final static int LOTTO_SIZE = 6;
    private final List<LottoNumber> numbers;

    public Lotto(List<Integer> numbers) {
        validate(numbers);
        this.numbers = numbers.stream()
                .sorted()
                .map(LottoNumber::from)
                .toList();
    }

    public String getLottoString() {
        return numbers.stream()
                .map((LottoNumber::getValue))
                .toList().toString();
    }

    public boolean has(LottoNumber bonusNumber) {
        return numbers.contains(bonusNumber);
    }

    public int calculateMatchCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter((lotto::has))
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicate(numbers);
    }

    private void validateDuplicate(List<Integer> numbers) {
        if (checkDuplicate(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.DUPLICATE_MEMBER_IN_LOTTO.getMessage());
        }
    }

    private boolean checkDuplicate(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private void validateLength(List<Integer> numbers) {
        if (checkLottoLength(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_LENGTH.getMessage());
        }
    }

    private boolean checkLottoLength(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }
}
