//package com.zemoso.springboot.demo.project.controller;
//
//
//import com.zemoso.springboot.demo.project.entity.Anime;
//import com.zemoso.springboot.demo.project.entity.Users;
//import com.zemoso.springboot.demo.project.service.AnimeService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.CurrentSecurityContext;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import com.zemoso.springboot.demo.project.service.UserService;
//
//import java.util.List;
//
//@Controller
//@RequestMapping("/user")
//public class UserController {
//
//    private UserService userService;
//
//    @Autowired
//    public UserController(UserService theUserService) {
//        userService = theUserService;
//    }
//
////    @GetMapping("/user-list")
////    public String listAnime(Model theModel) {
////
////        // get employees from db
////        List<Users> theUser = userService.findAll();
////        // add to the spring model
////        theModel.addAttribute("user", theUser);
////        return "anime/list-user";
////    }
//
////    @PostMapping("/saveUser")
////    public String saveEmployee(@ModelAttribute("user1") Users theUser, Model theModel) {
////
////        Users theUsers = new Users();
////        theModel.addAttribute("user1", theUsers);
////        // save user
////        userService.save(theUser);
////        return "anime/login";
////    }
//
//    @GetMapping("/animeWatchList")
//    public String animeWatchList(@RequestParam("user-id") int theId, Model theModel) {
//        System.out.println(theId);
//
//        Users theUser = userService.findById(theId);
//
//        theModel.addAttribute("userw", theUser);
//        return "anime/watch-list";
//    }
//    @GetMapping("/hello")
//    public String hello(@CurrentSecurityContext(expression="authentication?.name")
//                        String username) {
//        //Users theUser = userService.findByUserame(username);
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
//        System.out.println(auth);
//
//        return "Hello, " + username + "!";
//
//    }
//
//
//
//
//}
