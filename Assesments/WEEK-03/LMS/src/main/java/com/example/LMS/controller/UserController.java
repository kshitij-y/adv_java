package com.example.LMS.controller;


import com.example.LMS.model.User;
import com.example.LMS.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@RequestMapping("/user")
@SessionAttributes("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String showRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute User user, BindingResult result){

        if(result.hasErrors()){
            return "register";
        }
        userService.registerUser(user);

        return "redirect:/user/login";
    }

    @GetMapping("/login")
    public String showLoginPage(Model model){
        model.addAttribute(new User());
        return "login";
    }

    @PostMapping("/login")
    public String loginUser(@ModelAttribute User user, Model model){
        User loggedInUser = userService.loginUser(user.getEmail(), user.getPassword());
        if(loggedInUser == null){
            model.addAttribute("errorMessage", "Invalid Email or Password");
            return "login";
        }
        model.addAttribute("user", loggedInUser);
        return "redirect:/user/dashboard";
    }

    @GetMapping("/dashboard")
    public String showDashboard(@ModelAttribute("user") User user) {
        if(user == null || user.getEmail() == null){
            return "redirect:/user/login";
        }
        return "dashboard";
    }

    @GetMapping("/logout")
    public String logout(SessionStatus status){
        status.setComplete();
        return "redirect:/user/login";
    }





}
