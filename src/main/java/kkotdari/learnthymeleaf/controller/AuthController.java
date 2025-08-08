package kkotdari.learnthymeleaf.controller;

import jakarta.servlet.http.HttpSession;
import kkotdari.learnthymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String getLoginFragment(Model model) {
        model.addAttribute("tab", "login");
        return "fragments/auth/index :: content";
    }

    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session, Model model) {
        System.out.println("username: " + username + " password: " + password);
        if (!"admin".equals(username) || !"1234".equals(password)) {
            model.addAttribute("tab", "login");
            return "fragments/auth/index :: content";
        }
        final User user = new User();
        user.setUsername(username);
        session.setAttribute("user", user);
        return "fragments/index :: content";
    }

    @GetMapping("/signup")
    public String getSignupFragment(Model model) {
        model.addAttribute("tab", "signup");
        return "fragments/auth/index :: content";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password) {
        System.out.println("username: " + username + " password: " + password);
        return "fragments/index :: content";
    }

    @PostMapping("/logout")
    public String logout(HttpSession session) {
        session.invalidate();
        return "fragments/index :: content";
    }

}
