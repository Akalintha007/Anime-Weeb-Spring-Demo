package com.zemoso.springboot.demo.project.service;

import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.entity.WatchList;

import java.util.List;

public interface WatchListService {

    public List<Anime> getWatchListByUser(String userName);

    public void removeFromWatchList(String userName, int theId);

    public void addToWatchList(String userName, int theId);


    public void deleteFromWatchList( int theId);

    public int checkBeforeAddToWatchList(String userName, int theId);
}
