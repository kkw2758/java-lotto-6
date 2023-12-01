package lotto.exception;

public enum ErrorMessage {
    NOT_NUMBER("숫자를 입력해 주세요."),
    INVALID_MONEY("구입 금액은 1,000원으로 나누어 져야합니다.");

    private final String message;
    private final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
