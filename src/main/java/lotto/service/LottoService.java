package lotto.service;

import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Money;
import lotto.domain.Rank;
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

    public Map<Rank, Integer> makeRankResult(List<Lotto> lottos, Lotto answerLotto, BonusNumber bonusNumber) {
        Map<Rank, Integer> rankResult = new EnumMap<Rank, Integer>(Rank.class);
        for (Lotto lotto : lottos) {
            Rank rank = Rank.findRank(lotto.calculateMatchCount(answerLotto), lotto.has(bonusNumber.getValue()));
            rankResult.put(rank, rankResult.getOrDefault(rank, DEFAULT_VALUE) + 1);
        }
        return rankResult;
    }

    public double calculateEarningRate(Map<Rank, Integer> rankResult, Money money) {
        return (double) calculateTotalProfit(rankResult) / money.getValue() * 100;
    }

    private int calculateTotalProfit(Map<Rank, Integer> rankResult) {
        return rankResult.entrySet().stream()
                .map((entrySet) -> entrySet.getKey().getPrizeMoney() * entrySet.getValue())
                .mapToInt(Integer::intValue)
                .sum();
    }
}
