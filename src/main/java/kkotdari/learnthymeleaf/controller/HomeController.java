package kkotdari.learnthymeleaf.controller;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpSession;
import kkotdari.learnthymeleaf.model.Menu;
import kkotdari.learnthymeleaf.service.MenuService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Resource
    private MenuService menuService;

    @GetMapping
    public String showHomePage(HttpSession session) {
        List<Menu> menus = menuService.getMenus();
        session.setAttribute("menus", menus);
        return "index";
    }


    @GetMapping("/home")
    public String showHomeFragment() {
        return "fragments/index :: content";
    }
}
