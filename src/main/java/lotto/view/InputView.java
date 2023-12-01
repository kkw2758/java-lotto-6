package lotto.view;

import lotto.exception.ErrorMessage;

public class InputView {
    private static final String NATURAL_NUMBER_REGULAR_EXPRESSION = "\\d+";
    private static final String REQUEST_MONEY_MESSAGE = "구입 금액을 입력해주세요";


    public int requestMoney(){
        ConsoleWriter.printlnMessage(REQUEST_MONEY_MESSAGE);
        String userInput = ConsoleReader.enterMessage();
        validateNumber(userInput);
        return Integer.parseInt(userInput);
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
