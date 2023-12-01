package lotto.exception;

public enum ErrorMessage {
    NOT_NUMBER("숫자를 입력해 주세요."),
    INVALID_MONEY("구입 금액은 1,000원으로 나누어 져야합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다.");

    private final String message;
    private final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
