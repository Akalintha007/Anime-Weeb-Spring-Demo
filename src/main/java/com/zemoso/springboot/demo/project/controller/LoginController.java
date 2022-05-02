package com.zemoso.springboot.demo.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/loginPage")
    public String showMyLoginPage() {

        return "anime/login";

    }

//    @GetMapping("/logout")
//    public String showMyLogoutPage() {
//
//        return "anime/login";
//
//    }

    // add request mapping for /access-denied

    @GetMapping("/access-denied")
    public String showAccessDenied() {

        return "anime/access-denied";

    }
}
