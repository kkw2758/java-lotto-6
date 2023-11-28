package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;

public class InputView {
    private static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "\\d+";
    private static final String MONEY_INPUT_MESSAGE = "구매 금액을 입력해 주세요.";
    private static final String BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String ANSWER_LOTTO_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String COMMA_DELIMITER = ",";


    public int requestMoney() {
        ConsoleWriter.printlnMessage(MONEY_INPUT_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public int requestBonusNumber() {
        ConsoleWriter.printlnMessage(BONUS_NUMBER_INPUT_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public List<Integer> requestAnswerLotto() {
        try {
            ConsoleWriter.printlnMessage(ANSWER_LOTTO_INPUT_MESSAGE);
            String userInput = ConsoleReader.enterMessage();
            return parseStringListToIntegerList(parseStringToList(userInput, COMMA_DELIMITER));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER_LOTTO_INPUT.getMessage());
        }
    }

    private static List<Integer> parseStringListToIntegerList(List<String> strings) throws NumberFormatException {
        return strings.stream()
                .map(Integer::parseInt)
                .toList();
    }

    private static List<String> parseStringToList(String message, String seperator) {
        return Arrays.stream(split(message, seperator)).toList();
    }

    private static String[] split(String message, String separator) {
        return message.split(separator, -1);
    }

    private static void validateNumber(String userInput) {
        if (isNotNumber(userInput)) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_NUMBER_INPUT.getMessage());
        }
    }

    private static boolean isNotNumber(String userInput) {
        return !userInput.matches(NATURAL_NUMBER_REGULAR_EXPRESSION);
    }
}
