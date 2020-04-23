package com.example.lab3;

import com.example.lab3.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Controller
public class HomeController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("welcome");
    }

    @GetMapping("/")
    public String login(Model model,String account,String password) {
        model.addAttribute("user",new User());
        return "login";
    }
    @PostMapping("/login")
    public String check(@Validated User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute(user);
            return "login";
        }else {
            return "welcome";
        }
    }

    @GetMapping("/register")
    public String Register(Model model) {
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String Register(@Validated User user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasFieldErrors()) {
            model.addAttribute(user);
            return "register";
        }else {
            return "login";
        }
    }
}
