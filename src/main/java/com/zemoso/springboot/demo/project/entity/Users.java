//package com.zemoso.springboot.demo.project.entity;
//
//import javax.persistence.*;
//import java.util.ArrayList;
//import java.util.List;
//
//@Entity
//@Table(name="users")
//public class Users {
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="user_id")
//    private int userId;
//    @Column(name="username")
//    private String user;
//    @Column(name="password")
//    private String password;
//
//    @Column(name="enabled")
//    private int enabled;
//
//
//   @OneToMany( fetch=FetchType.LAZY, cascade=CascadeType.ALL)
//   @JoinColumn(name="username")
//   private List<Authorities> authorities;
//
//    @ManyToMany(
//            fetch=FetchType.LAZY,
//            cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.DETACH, CascadeType.REFRESH})
//    @JoinTable(
//            name="anime_has_users",
//            joinColumns =@JoinColumn(name="user_userid"),
//            inverseJoinColumns = @JoinColumn(name="anime_idanime")
//    )
//    private List<Anime> anime;
//
//    public List<Authorities> getAuthorities() {
//        return authorities;
//    }
//
//    public void setAuthorities(List<Authorities> authorities) {
//        this.authorities = authorities;
//    }
//
//    public Users() {
//    }
//
//
//
//    public Users(String user, String password) {
//        this.user = user;
//        this.password = password;
//
//    }
//
//    public Users(int userId, String user, String password) {
//        this.userId = userId;
//        this.user = user;
//        this.password = password;
//    }
//
//    public String getUser() {
//        return user;
//    }
//
//    public void setUser(String user) {
//        this.user = user;
//    }
//
//    public String getPassword() {
//        return password;
//    }
//
//    public void setPassword(String password) {
//        this.password = password;
//    }
//
//    public int getUserId() {
//        return userId;
//    }
//
//    public void setUserId(int userId) {
//        this.userId = userId;
//    }
//
//    @Override
//    public String toString() {
//        return "Users{" +
//                "user='" + user + '\'' +
//                ", password='" + password + '\'' +
//
//                '}';
//    }
//
//    public void add(Authorities tempAuthorities){
//        if(authorities==null){
//            authorities= new ArrayList<>();
//        }
//        authorities.add(tempAuthorities);
//    }
//}
