package lotto.exception;

import java.util.function.Supplier;
import lotto.view.ConsoleWriter;

public class ExceptionHandler {
    public static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}
