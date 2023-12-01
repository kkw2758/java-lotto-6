package lotto.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.utils.Random;

public class LottoService {

    public List<Lotto> buyLotto(Money money) {
        int buyCount = money.calculateLottoBuyCount();
        List<Lotto> lottoBundle = new ArrayList<>();
        IntStream.range(0, buyCount)
                .forEach(i -> lottoBundle.add(new Lotto(Random.pickUniqueNumbersInRange(1, 6, 45))));
        return lottoBundle;
    }
    
}
