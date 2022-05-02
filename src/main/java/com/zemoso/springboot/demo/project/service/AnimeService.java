package com.zemoso.springboot.demo.project.service;

import com.zemoso.springboot.demo.project.entity.Anime;


import java.util.List;

public interface AnimeService {

    public List<Anime> findAll();

    public Anime findById(int theId);

    public void save(Anime theAnime);

    public void deleteById(int theId);

    public void deleteAnimeById(int id);
}
