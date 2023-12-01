package lotto.domain;

import java.util.List;
import java.util.stream.Collectors;
import lotto.exception.ErrorMessage;

public class Lotto {
    private static final int LOTTO_SIZE = 6;
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
                .map(LottoNumber::getValue)
                .toList().toString();
    }

    public boolean has(LottoNumber lottoNumber) {
        return numbers.contains(lottoNumber);
    }

    public int calculateMatchNumberCount(Lotto lotto) {
        return (int) numbers.stream()
                .filter(lotto::has)
                .count();
    }

    private void validate(List<Integer> numbers) {
        validateLottoSize(numbers);
        validateLottoMember(numbers);
    }

    private void validateLottoMember(List<Integer> numbers) {
        if (checkLottoHasDuplicateMember(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_HAS_DUPLICATE_MEMBER.getMessage());
        }
    }

    private boolean checkLottoHasDuplicateMember(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }

    private void validateLottoSize(List<Integer> numbers) {
        if (checkLottoSize(numbers)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_LOTTO_SIZE.getMessage());
        }
    }

    private static boolean checkLottoSize(List<Integer> numbers) {
        return numbers.size() != LOTTO_SIZE;
    }
}
