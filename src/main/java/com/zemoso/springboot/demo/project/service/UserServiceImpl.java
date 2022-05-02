//package com.zemoso.springboot.demo.project.service;
//
//
//import com.zemoso.springboot.demo.project.dao.UserRepository;
//import com.zemoso.springboot.demo.project.entity.Anime;
//import com.zemoso.springboot.demo.project.entity.Users;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class UserServiceImpl implements UserService{
//
//    private UserRepository userRepository;
//
//    @Autowired
//    public UserServiceImpl(UserRepository theUserRepository) {
//        userRepository = theUserRepository;
//    }
//
//
////    @Override
////    public List<Users> findAll() {
////        return userRepository.findAllByOrderByUsernameAsc();
////
////
////    }
////    @Override
////    public void save(Users theUser) {
////        userRepository.save(theUser);
////    }
//
////    @Override
////    public Users findByUsername(String theUser) {
////        Optional<Users> result = userRepository.findByUsername(theUser);
////
////         Users theUsers = null;
////
////        if (result.isPresent()) {
////            theUsers = result.get();
////        }
////        else {
////            // we didn't find the anime
////            throw new RuntimeException("Did not find user - " + theUser);
////        }
////
////        return theUsers;
////    }
//
//    @Override
//    public Users findById(int theId) {
//        Optional<Users> result = userRepository.findById(theId);
//
//         Users theUsers = null;
//
//        if (result.isPresent()) {
//            theUsers = result.get();
//        }
//        else {
//            // we didn't find the anime
//            throw new RuntimeException("Did not find user - " + theId);
//        }
//
//        System.out.println(theUsers);
//
//        return theUsers;
//
//    }
//
//
//
//
//}
