package lotto.controller;

import java.util.EnumMap;
import java.util.List;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.LottoNumber;
import lotto.domain.Money;
import lotto.domain.Rank;
import lotto.exception.ExceptionHandler;
import lotto.service.LottoService;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoService lottoService;

    public LottoController(InputView inputView, OutputView outputView, LottoService lottoService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoService = lottoService;
    }

    public void run() {
        Money money = generateMoney();
        List<Lotto> lottoBundle = lottoService.buyLotto(money);
        outputView.printLottoBundle(lottoBundle.stream()
                .map(Lotto::getLottoString)
                .toList());
        Lotto answerLotto = generateAnswerLotto();
        BonusNumber bonusNumber = generateBonusNumber(answerLotto);
        EnumMap<Rank, Integer> rankInfo = lottoService.getRankInfo(lottoBundle, answerLotto, bonusNumber);
        outputView.printRankInfo(rankInfo);
        outputView.printEarningRate(lottoService.calculateEarningRate(rankInfo, money));
    }

    private Money generateMoney() {
        return ExceptionHandler.retry(() -> Money.from(inputView.requestMoney()));
    }

    private Lotto generateAnswerLotto() {
        return ExceptionHandler.retry(() -> new Lotto(inputView.requestAnswerLotto()));
    }

    private BonusNumber generateBonusNumber(Lotto answerLotto) {
        return ExceptionHandler.retry(() -> BonusNumber.of(LottoNumber.from(inputView.requestBonusNumber()), answerLotto));
    }

}
