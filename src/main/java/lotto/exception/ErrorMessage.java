package lotto.exception;


public enum ErrorMessage {
    INVALID_LOTTO_NUMBER("로도 번호의 숫자의 범위는 1 ~ 45 까지입니다.");

    private final String message;
    private final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
