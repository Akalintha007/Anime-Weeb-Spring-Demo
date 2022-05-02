//package com.zemoso.springboot.demo.project.entity;
//
//import javax.persistence.*;
//
//@Entity
//@Table(name="authorities")
//public class Authorities {
//
//    @Column(name="username")
//    private String userName;
//
//    @Column(name="authority")
//    private String authority;
//
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name="a_id")
//    private String id;
//
//
//
//
//
//    public Authorities() {
//    }
//
//    public Authorities(String userName, String authority) {
//        this.userName = userName;
//        this.authority = authority;
//    }
//
//    public Authorities(String userName, String authority, String id) {
//        this.userName = userName;
//        this.authority = authority;
//        this.id = id;
//    }
//
//    public String getUserName() {
//        return userName;
//    }
//
//    public void setUserName(String userName) {
//        this.userName = userName;
//    }
//
//    public String getAuthority() {
//        return authority;
//    }
//
//    public void setAuthority(String authority) {
//        this.authority = authority;
//    }
//
//    public String getId() {
//        return id;
//    }
//
//    public void setId(String id) {
//        this.id = id;
//    }
//
//    @Override
//    public String toString() {
//        return "Authorities{" +
//                "userName='" + userName + '\'' +
//                ", authority='" + authority + '\'' +
//                ", id='" + id + '\'' +
//                '}';
//    }
//
//
//}
