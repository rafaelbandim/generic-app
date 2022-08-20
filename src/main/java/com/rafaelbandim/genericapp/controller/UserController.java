package com.rafaelbandim.genericapp.controller;

import com.rafaelbandim.genericapp.entity.User;
import com.rafaelbandim.genericapp.service.UserService;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/signIn")
    public String signIn(User user) {
        try {
            userService.signIn(user);
           return "redirect:/home";
        } catch (BadCredentialsException e) {
           return"login";
        }
    }
}
