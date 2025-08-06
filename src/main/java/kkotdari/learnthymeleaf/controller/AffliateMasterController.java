package kkotdari.learnthymeleaf.controller;

import jakarta.annotation.Resource;
import kkotdari.learnthymeleaf.model.Affiliate;
import kkotdari.learnthymeleaf.service.AffiliateMasterService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/affiliate/master")
public class AffliateMasterController {

    @Resource
    private AffiliateMasterService affiliateMasterService;

    @GetMapping
    public String showPage(Model model) {
        List<Affiliate> affiliates = affiliateMasterService.getAll();
        model.addAttribute("affiliates", affiliates);
        return "fragments/affiliate/master :: content";
    }

    @GetMapping("/{id}")
    public String showDetailPage(Model model, @PathVariable long id) {
        Affiliate details = affiliateMasterService.getDetails(id);
        model.addAttribute("details", details);
        return "fragments/affiliate/master-details :: content";
    }
}
