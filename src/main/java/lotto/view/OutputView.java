package lotto.view;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.Rank;

public class OutputView {

    private static final String LOTTO_BUNDLE_TAG_FORMAT = "%d개를 구매했습니다.";
    private final static String EARNING_RATE_FORMAT = "총 수익률은 %.1f%%입니다.";
    public void printLottoBundle(List<String> lottoBundle) {
        ConsoleWriter.printlnFormat(LOTTO_BUNDLE_TAG_FORMAT, lottoBundle.size());
        for(String lotto : lottoBundle) {
            ConsoleWriter.printlnMessage(lotto);
        }
    }

    public void printEarningRate(double earningRate) {
        ConsoleWriter.printlnFormat(EARNING_RATE_FORMAT, earningRate);
    }

    public void printRankInfo(EnumMap<Rank, Integer> rankInfo) {
        ConsoleWriter.printlnFormat("당첨 통계");
        ConsoleWriter.printlnFormat("---");
        ConsoleWriter.printlnFormat("3개 일치 (5,000원) - %d개", rankInfo.getOrDefault(Rank.FIFTH, 0));
        ConsoleWriter.printlnFormat("4개 일치 (50,000원) - %d개", rankInfo.getOrDefault(Rank.FOURTH,0));
        ConsoleWriter.printlnFormat("5개 일치 (1,500,000원) - %d개", rankInfo.getOrDefault(Rank.THIRD,0));
        ConsoleWriter.printlnFormat("5개 일치, 보너스 볼 일치 (30,000,000원) - %d개", rankInfo.getOrDefault(Rank.SECOND,0));
        ConsoleWriter.printlnFormat("6개 일치 (2,000,000,000원) - %d개", rankInfo.getOrDefault(Rank.FIRST,0));
    }
}
