package com.zemoso.springboot.demo.project.dao;



import com.zemoso.springboot.demo.project.entity.Anime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface AnimeRepository extends JpaRepository<Anime, Integer> {

    //method to sort by first name
    public List<Anime> findAllByOrderByAnimeNameAsc();

    @Modifying
    @Transactional
    @Query(value="delete from anime where  idanime=:id",nativeQuery = true)
    public void deleteAnimeById(int id);


}