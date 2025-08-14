package kkotdari.learnthymeleaf.controller;

import jakarta.annotation.Resource;
import kkotdari.learnthymeleaf.model.Affiliate;
import kkotdari.learnthymeleaf.model.PageInfo;
import kkotdari.learnthymeleaf.model.RewardConvertHistory;
import kkotdari.learnthymeleaf.service.AffiliateMasterService;
import kkotdari.learnthymeleaf.service.AffiliateRewardService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
        model.addAttribute("affiliateList", affiliateList.subList(0, Math.min(20, affiliateList.size())));
        return "fragments/affiliates/rewards/index :: content";
    }

    @GetMapping("/histories/affiliate/{affiliateId}")
    public String getAffiliateHistoryList(@PathVariable long affiliateId, @RequestParam int currPage, @RequestParam int pageSize, Model model) {
        try {
            List<RewardConvertHistory> rewardConvertHistoryList = affiliateRewardService.getAllOfAffiliate(affiliateId);
            List<RewardConvertHistory> pageDRewardConvertHistoryList = rewardConvertHistoryList.subList((currPage - 1) * pageSize, Math.min((currPage * pageSize), rewardConvertHistoryList.size()));
            model.addAttribute("rewardConvertHistoryList", pageDRewardConvertHistoryList);

            PageInfo pageInfo = new PageInfo();
            pageInfo.setCurrPage(currPage);
            pageInfo.setPageSize(pageSize);
            pageInfo.setTotalPages((int) Math.ceil((double) rewardConvertHistoryList.size() / pageSize));
            model.addAttribute("pageInfo", pageInfo);

            model.addAttribute("affiliateId", affiliateId);
        } catch (Exception e) {
            model.addAttribute("affiliateId", null);
            model.addAttribute("rewardConvertHistoryList", null);
            model.addAttribute("pageInfo", null);
        }
        return "fragments/affiliates/rewards/convert-history-list :: content";
    }
}
