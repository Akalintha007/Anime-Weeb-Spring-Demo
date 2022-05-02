package com.zemoso.springboot.demo.project.service;

import com.zemoso.springboot.demo.project.dao.AnimeRepository;
import com.zemoso.springboot.demo.project.dao.WatchListRepository;
import com.zemoso.springboot.demo.project.entity.Anime;
import com.zemoso.springboot.demo.project.entity.WatchList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WatchListServiceImpl implements WatchListService{

    private WatchListRepository watchListRepository;

    @Autowired
    public WatchListServiceImpl(WatchListRepository theWatchListRepository) {
        watchListRepository = theWatchListRepository;
    }
//    @Override
//    public List<Anime> getWatchListByUser(String userName) {
//        List<Anime> result = watchListRepository.getWatchListByUser(userName);
//
//        Anime theAnime = null;
//
//        if (result.isEmpty()) {
//
//            // we didn't find the anime
//            throw new RuntimeException("Did not find anime fro user name - " + userName);
//
//        }
//        else {
//            theAnime = result.get(7);
//        }
//
//        return theAnime;
//    }


    @Override
    public List<Anime> getWatchListByUser(String userName) {
        List<Anime> result = watchListRepository.getWatchListByUser(userName);


        return result;
    }

    @Override
    public void removeFromWatchList(String userName, int theId){

        watchListRepository.removeFromWatchList(userName,theId);

        System.out.println("in service layer");

    }

    @Override
    public void addToWatchList(String userName, int theId) {

        watchListRepository.addToWatchList(userName,theId);

        System.out.println("in service layer");
    }

    @Override
    public void deleteFromWatchList(int theId) {
        watchListRepository.deleteFromWatchList(theId);
    }

    @Override
    public int checkBeforeAddToWatchList(String userName, int theId) {


        int check = watchListRepository.checkBeforeAddToWatchList(userName,theId);

        return check;
    }
}
