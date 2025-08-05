package kkotdari.thymeleaf.controller;

import jakarta.servlet.http.HttpSession;
import kkotdari.thymeleaf.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/auth")
public class AuthController {
    @PostMapping("/login")
    public String login(@RequestParam String username, @RequestParam String password, HttpSession session) {
        if (!"admin".equals(username) || !"1234".equals(password)) {
            return "/login?error";
        }
        final User user = new User();
        user.setUsername(username);
        session.setAttribute("user", user);
        return "redirect:/";
    }

    @PostMapping("/signup")
    public String signup(@RequestParam String username, @RequestParam String password, Model model) {
        if (!"admin".equals(username) || !"1234".equals(password)) {
            return "/signup?error";
        }
        final User user = new User();
        user.setUsername(username);
        model.addAttribute("resultMsg", "회원가입 성공!");
        return "redirect:/routes/auth/login";
    }
}
