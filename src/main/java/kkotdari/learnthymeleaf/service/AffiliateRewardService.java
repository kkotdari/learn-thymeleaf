package kkotdari.learnthymeleaf.service;

import kkotdari.learnthymeleaf.model.RewardConvertHistory;

import java.util.List;

public interface AffiliateRewardService {

    List<RewardConvertHistory> getAll();

    List<RewardConvertHistory> getAllOfAffiliate(long id);

}
