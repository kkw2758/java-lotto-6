package lotto;

import java.util.List;

public class AnswerLotto {
    private final List<Integer> numbers;

    public AnswerLotto(List<Integer> numbers) {
        validateAnswerLotto(numbers);
        this.numbers = numbers;
    }

    private void validateAnswerLotto(List<Integer> numbers) {
        validateLength(numbers);
        validateDuplicateMember(numbers);
    }

    private void validateLength(List<Integer> numbers) {
        if (checkLength(numbers)) {
            throw new IllegalArgumentException("당첨번호의 길이가 6이 아닙니다");
        }
    }

    private boolean checkLength(List<Integer> numbers) {
        return numbers.size() != 6;
    }

    private void validateDuplicateMember(List<Integer> numbers) {
        if (checkHasDuplicateMember(numbers)) {
            throw new IllegalArgumentException("당첨번호에 중복된 숫자가 포함되어 있습니다.");
        }
    }
    private boolean checkHasDuplicateMember(List<Integer> numbers) {
        return numbers.stream()
                .distinct()
                .count() != numbers.size();
    }
}
