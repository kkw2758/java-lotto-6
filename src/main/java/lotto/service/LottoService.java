package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.utils.Random;

public class LottoService {

    public List<Lotto> buyLotto(Money money) {
        int buyCount = money.calculateLottoBuyCount();
        List<Lotto> lottoBundle = new ArrayList<>();
        IntStream.range(0, buyCount)
                .forEach(i -> lottoBundle.add(new Lotto(Random.pickUniqueNumbersInRange(1, 6, 45))));
        return lottoBundle;
    }

    public EnumMap<Rank, Integer> getRankInfo(List<Lotto> lottoBundle, Lotto answerLotto, BonusNumber bonusNumber) {
        EnumMap<Rank, Integer> rankInfo = new EnumMap<>(Rank.class);
        for(Lotto lotto : lottoBundle) {
            Rank rank = Rank.findRank(lotto.calculateMatchNumberCount(answerLotto), lotto.has(bonusNumber.getValue()));
            rankInfo.put(rank, rankInfo.getOrDefault(rank, 0) + 1);
        }
        return rankInfo;
    }

    private int calculateTotalProfit(EnumMap<Rank, Integer> rankInfo) {
        return rankInfo.entrySet().stream()
                .map((entry) -> entry.getKey().getPrice() * entry.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }
}
