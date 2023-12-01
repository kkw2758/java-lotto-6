package lotto.exception;

public enum ErrorMessage {
    NOT_NUMBER("숫자를 입력해 주세요."),
    INVALID_MONEY("구입 금액은 1,000원으로 나누어 져야합니다."),
    INVALID_LOTTO_NUMBER("로또 번호는 1부터 45 사이의 숫자여야 합니다."),
    INVALID_LOTTO_SIZE("로또는 6개의 숫자로 이루어 져야합니다."),
    LOTTO_HAS_DUPLICATE_MEMBER("로또에 중복된 숫자가 포함될 수 없습니다.");

    private final String message;
    private final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
