package lotto.controller;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.service.LottoService;
import lotto.view.ConsoleWriter;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    private final LottoService lottoService;
    private final InputView inputView;
    private final OutputView outputView;

    public LottoController(LottoService lottoService, InputView inputView, OutputView outputView) {
        this.lottoService = lottoService;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        Money money = generateMoney();
        List<Lotto> lottos = lottoService.buyLottos(money);
        outputView.printBuyLottosInfo(
                lottos.stream()
                .map(Lotto::getLottoString)
                .toList()
        );
        Lotto answerLotto = generateAnswerLotto();
        BonusNumber bonusNumber = generateBonusNumber(answerLotto);
        Map<Rank, Integer> rankResult = lottoService.makeRankResult(lottos, answerLotto, bonusNumber);
        outputView.printRankResult(rankResult);
        outputView.printEarningRate(lottoService.calculateEarningRate(rankResult, money));
    }

    private Money generateMoney() {
        return retry(() -> {
            return Money.from(inputView.requestMoney());
        });
    }

    private Lotto generateAnswerLotto() {
        return retry(() -> {
            return new Lotto(inputView.requestAnswerLotto());
        });
    }

    private BonusNumber generateBonusNumber(Lotto answerLotto) {
        return retry(() -> {
            return BonusNumber.of(LottoNumber.from(inputView.requestBonusNumber()), answerLotto);
        });
    }

    private static <T> T retry(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                ConsoleWriter.printlnMessage(e.getMessage());
            }
        }
    }
}
