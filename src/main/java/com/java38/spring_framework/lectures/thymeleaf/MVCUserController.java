package com.java38.spring_framework.lectures.thymeleaf;

import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MVCUserController {

    private final MVCUserRepository MVCUserRepository;

    public MVCUserController(MVCUserRepository MVCUserRepository) {
        this.MVCUserRepository = MVCUserRepository;
    }

    @GetMapping("/signup")
    public String showSignUpForm(MVCUser user) {
        return "add-user";
    }

    @PostMapping("/adduser")
    public String addUser(@Valid MVCUser user, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "add-user";
        }

        MVCUserRepository.save(user);
        return "redirect:/index";
    }

    @GetMapping("/index")
    public String showUserList(Model model) {
        model.addAttribute("users", MVCUserRepository.findAll());
        return "index";
    }
}
