package com.zemoso.springboot.demo.project.entity;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="watch_list")
public class WatchList {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idwatch_list")
    private int watchListId;
    @Column(name="username")
    private String user;

    @Column(name="anime_watch_list_id")
    private int animeWatchListId;

    @ManyToOne
    @JoinColumn(name="watch_list_id")
    private Anime anime;

    public Anime getAnime() {
        return anime;
    }

    public void setAnime(Anime anime) {
        this.anime = anime;
    }


//    public List<Anime getAnime() {
//        return anime;
//    }
//
//    public void setAnime(List<Anime> anime) {
//        this.anime = anime;
//    }

    public WatchList() {
    }

    public WatchList(String user, int animeWatchListId) {
        this.user = user;
        this.animeWatchListId = animeWatchListId;
    }

    public WatchList(int watchListId, String user, int animeWatchListId) {
        this.watchListId = watchListId;
        this.user = user;
        this.animeWatchListId = animeWatchListId;
    }

    public int getWatchListId() {
        return watchListId;
    }

    public void setWatchListId(int watchListId) {
        this.watchListId = watchListId;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getAnimeWatchListId() {
        return animeWatchListId;
    }

    public void setAnimeWatchListId(int animeWatchListId) {
        this.animeWatchListId = animeWatchListId;
    }

    @Override
    public String toString() {
        return "WatchList{" +
                "watchListId=" + watchListId +
                ", user='" + user + '\'' +
                ", animeWatchListId=" + animeWatchListId +
                '}';
    }
}
