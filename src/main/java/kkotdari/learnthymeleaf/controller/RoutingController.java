package kkotdari.learnthymeleaf.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import kkotdari.learnthymeleaf.model.Menu;
import kkotdari.learnthymeleaf.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class RoutingController {
    @Resource
    private MenuService menuService;

    @GetMapping
    public String home(HttpSession session) {
        List<Menu> menus = menuService.getMenus();
        session.setAttribute("menus", menus);
        return "index";
    }

    @GetMapping("/routes/{fragmentFileName}")
    public String routes(@PathVariable String fragmentFileName) {
        return "fragments/" + fragmentFileName + " :: content";
    }

    @GetMapping("/routes/auth/{action}")
    public String routesAuth(@PathVariable String action, Model model) {
        model.addAttribute("tab", action);
        return "fragments/auth/index :: content";
    }
}
