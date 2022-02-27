package org.artoni.todo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/login")
    public static String login() {
        return "login";
    }

    @GetMapping("/login-error")
    public static String loginError(Model model) {
        model.addAttribute("loginError", true);
        return "login";
    }

}
