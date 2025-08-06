package kkotdari.learnthymeleaf.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/affiliate/master")
public class AffliateMasterController {

    @GetMapping
    public String showAffiliateMasterPage() {
        return "fragments/affiliate/master :: content";
    }

}
