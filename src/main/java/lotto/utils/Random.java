package lotto.utils;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class Random {

    public static List<Integer> pickUniqueNumbersInRange(int start, int end, int size) {
        return Randoms.pickUniqueNumbersInRange(start, end, size);
    }
}
