package lotto.exception;


public enum ErrorMessage {
    INVALID_LOTTO_NUMBER("로도 번호의 숫자의 범위는 1 ~ 45 까지입니다."),
    INVALID_LOTTO_LENGTH("로또 번호의 길이는 6이여야 합니다."),
    DUPLICATE_MEMBER_IN_LOTTO("로또에 중복된 번호가 포함되어 있습니다."),
    INVALID_MONEY("로도 구입 금액은 1,000원으로 나누어 떨어져야 합니다.");


    private final String message;
    private final String PREFIX = "[ERROR] ";

    ErrorMessage(String message) {
        this.message = PREFIX + message;
    }

    public String getMessage() {
        return message;
    }
}
