package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.Rank;

public class OutputView {
    private final static String EARNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";
    private final static String BUY_LOTTOS_FORMAT = "%d개를 구매했습니다.";
    public void printBuyLottosInfo(List<String> lottosInfo) {
        ConsoleWriter.printlnFormat(BUY_LOTTOS_FORMAT, lottosInfo.size());
        for(String lottoInfo : lottosInfo) {
            ConsoleWriter.printlnMessage(lottoInfo);
        }
    }

    public void printEarningRate(double earningRate) {
        ConsoleWriter.printlnFormat(EARNING_RATE_FORMAT, earningRate);
    }

    public void printRankResult(Map<Rank, Integer> rankResult) {
        ConsoleWriter.printlnFormat("당첨 통계");
        ConsoleWriter.printlnFormat("---");
        ConsoleWriter.printlnFormat("3개 일치 (5,000원) - %d개", rankResult.getOrDefault(Rank.FIFTH, 0));
        ConsoleWriter.printlnFormat("4개 일치 (50,000원) - %d개", rankResult.getOrDefault(Rank.FOURTH,0));
        ConsoleWriter.printlnFormat("5개 일치 (1,500,000원) - %d개", rankResult.getOrDefault(Rank.THIRD,0));
        ConsoleWriter.printlnFormat("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", rankResult.getOrDefault(Rank.SECOND,0));
        ConsoleWriter.printlnFormat("6개 일치 (2,000,000,000원) - %d개", rankResult.getOrDefault(Rank.FIRST,0));
    }
}
