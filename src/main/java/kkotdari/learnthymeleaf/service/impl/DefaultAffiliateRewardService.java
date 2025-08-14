package kkotdari.learnthymeleaf.service.impl;

import jakarta.annotation.Resource;
import kkotdari.learnthymeleaf.model.Affiliate;
import kkotdari.learnthymeleaf.model.RewardConvertHistory;
import kkotdari.learnthymeleaf.service.AffiliateMasterService;
import kkotdari.learnthymeleaf.service.AffiliateRewardService;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.util.Tuple;


import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class DefaultAffiliateRewardService implements AffiliateRewardService {

    @Resource
    private AffiliateMasterService affiliateMasterService;

    private static List<RewardConvertHistory> rewardConvertHistoryList = null;

    @Override
    public List<RewardConvertHistory> getAll() {
        if (rewardConvertHistoryList != null) {
            return rewardConvertHistoryList;
        }

        List<Affiliate> affiliateList = affiliateMasterService.getAll();
        Random random = new Random();
        int[] convertRatePool = {1, 2, 5, 10};

        List<Tuple<Affiliate, Integer>> affiliatesAndConvertRateList = new ArrayList<>();
        for (Affiliate a : affiliateList) {
            affiliatesAndConvertRateList.add(new Tuple<Affiliate, Integer>(a, convertRatePool[random.nextInt(convertRatePool.length)]));
        }

        rewardConvertHistoryList = new ArrayList<>();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        for (int i = 0; i < 5000; i++) {
            RewardConvertHistory history = new RewardConvertHistory();
            Tuple<Affiliate, Integer> randAffiliateTuple = affiliatesAndConvertRateList.get(random.nextInt(affiliatesAndConvertRateList.size()));
            history.setId(randAffiliateTuple._1().getId());
            history.setTicker(randAffiliateTuple._1().getTicker());
            history.setConvertTargetPoint(random.nextInt(100) + 1);
            history.setConvertRate(randAffiliateTuple._2());
            history.setConvertedReward(Math.round((float) history.getConvertTargetPoint() / randAffiliateTuple._2()));
            history.setStatCode(random.nextBoolean() ? "SUCCESS" : "FAIL");

            LocalDateTime randomDateTime = LocalDateTime.now()
                    .minusDays(random.nextInt(30))
                    .minusHours(random.nextInt(24))
                    .minusMinutes(random.nextInt(60));
            history.setConvertDatetime(randomDateTime.format(formatter));

            rewardConvertHistoryList.add(history);
        }

        rewardConvertHistoryList.sort(Comparator.comparing(h -> LocalDateTime.parse(h.getConvertDatetime(), formatter)));

        return rewardConvertHistoryList;
    }

    @Override
    public List<RewardConvertHistory> getAllOfAffiliate(long id) {
        return getAll().stream()
                .filter(h -> h.getId() == id)
                .collect(Collectors.toList());
    }

}
