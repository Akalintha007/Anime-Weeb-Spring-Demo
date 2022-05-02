package com.zemoso.springboot.demo.project.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="genere")
public class Genre {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="idgenere")
    private int id;

    @Column(name="genere")
    private String genre;

    @ManyToMany(
            fetch=FetchType.LAZY,
            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
    @JoinTable(
            name="genere_has_anime",
            joinColumns =@JoinColumn(name="genere_idgenere"),
            inverseJoinColumns = @JoinColumn(name="anime_idanime")
    )
    private List<Anime> anime;

    public List<Anime> getAnime() {
        return anime;
    }

    public void setAnime(List<Anime> anime) {
        this.anime = anime;
    }

    public Genre() {
    }

    public Genre(String genre) {
        this.genre = genre;
    }

    public Genre(int id, String genre) {
        this.id = id;
        this.genre = genre;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Genre{" +
                "id=" + id +
                ", genre='" + genre + '\'' +
                '}';
    }

    public void addAnime(Anime theAnime){
        if(anime == null){
            anime= new ArrayList<>();
        }
        anime.add(theAnime);
    }
}
