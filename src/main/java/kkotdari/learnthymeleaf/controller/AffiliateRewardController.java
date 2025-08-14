package kkotdari.learnthymeleaf.controller;

import jakarta.annotation.Resource;
import kkotdari.learnthymeleaf.model.Affiliate;
import kkotdari.learnthymeleaf.model.RewardConvertHistory;
import kkotdari.learnthymeleaf.service.AffiliateMasterService;
import kkotdari.learnthymeleaf.service.AffiliateRewardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/affiliates/rewards")
public class AffiliateRewardController {

    @Resource
    private AffiliateMasterService affiliateMasterService;
    @Resource
    private AffiliateRewardService affiliateRewardService;

    @GetMapping
    public String showPage(Model model) {
        List<Affiliate> affiliateList = affiliateMasterService.getAll();
        model.addAttribute("affiliates", affiliateList.subList(0, Math.min(20, affiliateList.size())));
        List<RewardConvertHistory> rewardConvertHistories = affiliateRewardService.getAll();
        model.addAttribute("rewardConvertHistories", rewardConvertHistories.subList(0, Math.min(20, affiliateList.size())));
        return "fragments/affiliates/rewards/index :: content";
    }

    @GetMapping("/histories/affiliate/{id}")
    public String getAffiliateHistoryList(@PathVariable long id, Model model) {
        List<RewardConvertHistory> rewardConvertHistories = affiliateRewardService.getAllOfAffiliate(id);
        model.addAttribute("rewardConvertHistories", rewardConvertHistories.subList(0, Math.min(20, rewardConvertHistories.size())));
        return "fragments/affiliates/rewards/convert-history-list :: content";
    }
}
