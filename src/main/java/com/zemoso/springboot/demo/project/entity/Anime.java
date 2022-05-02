package com.zemoso.springboot.demo.project.entity;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="anime")
public class Anime {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idanime")
    private int id;

    @Column(name="anime_name")
    @NotNull(message="cannot be empty")
    @Size(min=1, max=50,message = "should be with in 50 characters")
    private String animeName;

    @NotNull(message="cannot be empty")
    @DecimalMin(value = "0.1",message = "The rating must be greater than 0")
    @DecimalMax(value = "10",message = "The rating must be lesser than 10")
    @Column(name="rating")
    private Double rating;

    @NotNull(message="cannot be empty")
    @Size(min=1, max=200,message = "should be with in 200 characters")
    @Column(name="descreption")
    private String description;

    @NotNull(message="cannot be empty")
    @Size(min=1, max=500,message = "should be with in 500 characters")
    @Column(name="display_img")
    private String displayImg;

    @Column(name="watch_list_id")
    private int watchListId;

    @ManyToMany(
            fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="genere_has_anime",
            joinColumns =@JoinColumn(name="anime_idanime"),
            inverseJoinColumns = @JoinColumn(name="genere_idgenere")
    )
    private List<Genre> genres;

    @OneToMany( mappedBy="anime",  cascade = CascadeType.ALL)
    private List<WatchList> watchList;



    public Anime() {
    }

    public String getAnimeName() {
        return animeName;
    }

    public void setAnimeName(String animeName) {
        this.animeName = animeName;
    }

    public List<WatchList> getWatchList() {
        return watchList;
    }

    public void setWatchList(List<WatchList> watchList) {
        this.watchList = watchList;
    }

    public List<Genre> getGenres() {
        return genres;
    }

    public void setGenres(List<Genre> genres) {
        this.genres = genres;
    }

    public Anime(String animeName, Double rating, String description, String displayImg) {
        this.animeName = animeName;
        this.rating = rating;
        this.description = description;
        this.displayImg = displayImg;
    }

    public Anime(int id, String animeName, Double rating, String description, String displayImg) {
        this.id = id;
        this.animeName = animeName;
        this.rating = rating;
        this.description = description;
        this.displayImg = displayImg;
    }

    public Anime(int id, String animeName, Double rating, String description, String displayImg, int watchListId) {
        this.id = id;
        this.animeName = animeName;
        this.rating = rating;
        this.description = description;
        this.displayImg = displayImg;
        this.watchListId = watchListId;
    }

    public int getWatchListId() {
        return watchListId;
    }

    public void setWatchListId(int watchListId) {
        this.watchListId = watchListId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

//    public String getName() {
//        return animeName;
//    }
//
//    public void setName(String name) {
//        this.animeName = animeName;
//    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDisplayImg() {
        return displayImg;
    }

    public void setDisplayImg(String displayImg) {
        this.displayImg = displayImg;
    }

    @Override
    public String toString() {
        return "Anime{" +
                "id=" + id +
                ", animeName='" + animeName + '\'' +
                ", rating=" + rating +
                ", description='" + description + '\'' +
                ", displayImg='" + displayImg + '\'' +
                ", watchListId='" + watchListId + '\'' +
                '}';
    }

    public void add(WatchList tempWatchList){
        if(watchList==null){
            watchList= new ArrayList<>();
        }
        watchList.add(tempWatchList);

        tempWatchList.setAnime(this);
    }


}
