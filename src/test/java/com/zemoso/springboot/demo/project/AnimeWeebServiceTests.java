package com.zemoso.springboot.demo.project;


import com.zemoso.springboot.demo.project.dao.AnimeRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.service.AnimeService;
import org.hamcrest.MatcherAssert;
import org.junit.Assert;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.assertj.core.internal.bytebuddy.matcher.ElementMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AnimeWeebServiceTests {

    @Autowired
    private AnimeService service;

    @MockBean
    private AnimeRepository repository;

    @Test
    public void findall_should_Return2_when_2ElementsArePresentInList() {
        List<Anime> tempList=new ArrayList<>();

        tempList.add(new Anime("one piece",8.9,"join a sea of adventures with luffy and his crew","image URL"));
        tempList.add(new Anime("naruto",8.7,"world of shinobi","image URL"));
        Mockito.when(repository.findAllByOrderByAnimeNameAsc()).thenReturn(tempList);

        assertEquals(2,service.findAll().size());
    }

//    @Test
//    void findById_should_returnTheMovieWithMatchingId() {
//        int id=1;
//        Anime anime=new Anime("one piece",8.9,"join a sea of adventures with luffy and his crew","image URL");
//        Optional<Anime> optionalAnime=Optional.ofNullable(anime);
//        Mockito.when(repository.findById(id)).thenReturn(optionalAnime);
//
//        //MatcherAssert.assertThat(service.findById(id),is(anime));
//        MatcherAssert.assertThat(service.findById(id), is(anime));
//    }

//    @Test
//    public void save_should_returnMovie_when_saved() {
//        Anime anime=new Anime("one piece",8.9,"join a sea of adventures with luffy and his crew","image URL");
//
//        Mockito.when(repository.save(anime)).thenReturn(anime);
//
//        assertEquals(anime,service.save(anime));
//
//    }



}
