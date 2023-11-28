package lotto.service;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.utils.RandomUtil;

public class LottoService {
    private final static int DEFAULT_VALUE = 0;

    public List<Lotto> buyLottos(Money money) {
        int lottoBuyCount = money.calculateLottoBuyCount();
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoBuyCount; i++) {
            lottos.add(new Lotto(RandomUtil.generateRandomNumbers(1, 45, 6)));
        }
        return lottos;
    }
}
