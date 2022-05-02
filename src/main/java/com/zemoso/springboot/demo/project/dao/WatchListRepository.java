package com.zemoso.springboot.demo.project.dao;

import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.entity.WatchList;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface WatchListRepository extends CrudRepository<Anime, Integer> {

    @Query(value="select a.idanime, a.anime_name, a.rating, a.descreption, a.display_img, a.watch_list_id from watch_list wl join anime a on wl.anime_watch_list_id=a.watch_list_id where wl.username=:userName",nativeQuery=true)
    List<Anime> getWatchListByUser(String userName);

    @Modifying
    @Transactional
    @Query(value="delete from watch_list where username=:userName and anime_watch_list_id=:theId",nativeQuery = true)
    public void removeFromWatchList(String userName, int theId);


    @Modifying
    @Transactional
    @Query(value="delete from watch_list where anime_watch_list_id=:theId",nativeQuery = true)
    public void deleteFromWatchList( int theId);

    @Modifying
    @Transactional
    @Query(value="insert into watch_list (username, anime_watch_list_id)values(:userName , :theId)",nativeQuery = true)
    public void addToWatchList(String userName, int theId);

//    @Modifying
//    @Transactional
    @Query(value="SELECT count(*) FROM watch_list WHERE username = :userName and anime_watch_list_id =:theId",nativeQuery = true)
    public int checkBeforeAddToWatchList(String userName, int theId);



}
