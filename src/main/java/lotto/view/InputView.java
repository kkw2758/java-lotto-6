package lotto.view;

import java.util.Arrays;
import java.util.List;
import lotto.exception.ErrorMessage;

public class InputView {
    private static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "\\d+";
    private static final String REQUEST_MONEY_MESSAGE = "구입 금액을 입력해 주세요.";
    private static final String REQUEST_ANSWER_LOTTO_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";


    public int requestMoney(){
        ConsoleWriter.printlnMessage(REQUEST_MONEY_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public int requestBonusNumber(){
        ConsoleWriter.printlnMessage(REQUEST_BONUS_NUMBER_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Integer.parseInt(userInput);
    }

    public List<Integer> requestAnswerLotto() {
        try {
            ConsoleWriter.printlnMessage(REQUEST_ANSWER_LOTTO_MESSAGE);
            String userInput = ConsoleReader.enterMessage();
            return parseStringListToIntegerList(parseStringToList(userInput, ","));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.INVALID_ANSWER_LOTT_INPUT.getMessage());
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
            throw new IllegalArgumentException(ErrorMessage.NOT_NUMBER.getMessage());
        }
    }

    private static boolean isNotNumber(String userInput) {
        return !userInput.matches(NATURAL_NUMBER_REGULAR_EXPRESSION);
    }
}
