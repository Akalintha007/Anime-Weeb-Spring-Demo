package com.zemoso.springboot.demo.project.service;


import java.util.List;
import java.util.Optional;

import com.zemoso.springboot.demo.project.dao.AnimeRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class AnimeServiceImpl implements AnimeService {

    private AnimeRepository animeRepository;

    @Autowired
    public AnimeServiceImpl(AnimeRepository theAnimeRepository) {
        animeRepository = theAnimeRepository;
    }

    @Override
    public List<Anime> findAll() {
        return animeRepository.findAllByOrderByAnimeNameAsc();
    }

    @Override
    public Anime findById(int theId) {
        Optional<Anime> result = animeRepository.findById(theId);

        Anime theAnime = null;

        if (result.isPresent()) {
            theAnime = result.get();
        }
        else {
            // we didn't find the anime
            throw new RuntimeException("Did not find anime id - " + theId);
        }

        return theAnime;
    }

    @Override
    public void save(Anime theAnime) {
        animeRepository.save(theAnime);
    }

    @Override
    public void deleteById(int theId) {
        animeRepository.deleteById(theId);
    }

    @Override
    public void deleteAnimeById(int id) {
        animeRepository.deleteAnimeById(id);
    }

}






