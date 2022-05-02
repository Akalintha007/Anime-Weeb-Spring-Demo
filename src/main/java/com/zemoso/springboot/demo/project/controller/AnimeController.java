package com.zemoso.springboot.demo.project.controller;


import com.zemoso.springboot.demo.project.entity.Anime;

import com.zemoso.springboot.demo.project.service.AnimeService;


import com.zemoso.springboot.demo.project.service.WatchListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.CurrentSecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/anime-weeb")
public class AnimeController {

    private AnimeService animeService;
    private WatchListService watchListService;


    @Autowired
    public AnimeController(WatchListService theWatchListService,AnimeService theAnimeService) {
        watchListService = theWatchListService;
        animeService = theAnimeService;
    }


    @GetMapping("/admin/anime-list")
    public String listAnime(Model theModel) {

        // get anime from db
        List<Anime> theAnime = animeService.findAll();
        // add to the spring model
        theModel.addAttribute("anime", theAnime);
        System.out.println("in anime list");
        return "anime/list-anime";
    }

    @GetMapping("/admin/admin-user")
    public String userAdmin() {

        return "anime/admin-user";
    }



    @GetMapping("/user/anime-list")
    public String userView(Model theModel2) {
        // get anime from db
        List<Anime> theAnime2 = animeService.findAll();
        // add to the spring model
        theModel2.addAttribute("anime", theAnime2);
        return "anime/list-anime-user-view";
    }




    @GetMapping("/admin/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Anime theAnime = new Anime();
        theModel.addAttribute("anime1", theAnime);
        return "anime/anime-form";
    }


    @GetMapping("/admin/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("animeId") int theId,
                                    Model theModel) {


        Anime theAnime = animeService.findById(theId);

        theModel.addAttribute("anime1", theAnime);

        return "anime/anime-form-update";
    }

    @GetMapping("/admin/animeGenre")
    public String animeGenre(@RequestParam("animeId") int theId, Model theModel) {


        Anime theAnime3 = animeService.findById(theId);


        theModel.addAttribute("animeg", theAnime3);
        return "anime/anime-genre";
    }
    @GetMapping("/user/animeGenreUser")
    public String animeGenreUser(@RequestParam("animeId") int theId, Model theModel) {


        Anime theAnime3 = animeService.findById(theId);

        theModel.addAttribute("animeg", theAnime3);
        return "anime/anime-genre-user-view";
    }


    @PostMapping("/admin/save")
    public String saveAnimeUPDATE(@ModelAttribute("anime1") @Valid Anime theAnime, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "anime/anime-form-update";
        }

        animeService.save(theAnime);
        return "redirect:/anime-weeb/admin/anime-list";
    }

    @PostMapping("/admin/save-a")
    public String saveAnimeADD(@ModelAttribute("anime1") @Valid Anime theAnime, BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            return "anime/anime-form";
        }

        animeService.save(theAnime);
        return "redirect:/anime-weeb/admin/anime-list";
    }

//    @GetMapping("/admin/delete")
//    public String delete(@RequestParam("animeId") int theId) {
//
//
//        animeService.deleteById(theId);
//        return "redirect:/anime-weeb/admin/anime-list";
//
//    }

    @GetMapping("/admin/delete")
    public String delete(@RequestParam("animeId") int theId, @RequestParam("watchListId") int watchListId) {

        watchListService.deleteFromWatchList(watchListId);
        animeService.deleteAnimeById(theId);
        return "redirect:/anime-weeb/admin/anime-list";

    }


    @GetMapping("/admin/kill-code")
    public String noFunctionalityPage() {

        return "anime/page-under-construction";
    }

    @GetMapping("/admin/kill-code-g")
    public String noFunctionalityPage2() {

        return "anime/page-under-construction-2";
    }





}
