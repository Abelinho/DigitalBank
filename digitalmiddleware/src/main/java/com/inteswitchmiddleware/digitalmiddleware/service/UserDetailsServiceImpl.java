//package com.inteswitchmiddleware.digitalmiddleware.service;
//
//import com.inteswitchmiddleware.digitalmiddleware.entity.UserEntity;
//import com.inteswitchmiddleware.digitalmiddleware.repository.UserRepository;
//import lombok.RequiredArgsConstructor;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.stereotype.Service;
//
//@Service
//@RequiredArgsConstructor
//public class UserDetailsServiceImpl implements UserDetailsService {
//
//    //@Autowired
//    private final UserRepository userRepository;
//
//   // @Autowired
//    private final PasswordEncoder passwordEncoder;
//
//    @Override
//    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//
//        UserEntity user = userRepository.findByUsername(username);
//        if (user == null) {
//            throw new UsernameNotFoundException("User not found");
//        }
//        return User.withUsername(user.getUsername())
//        .password(user.getPassword())
//        .roles("USER")
//        .build();
//    }
//
//    public UserEntity registerUser(String username, String password) {
//        UserEntity user = new UserEntity();
//        user.setUsername(username);
//        user.setPassword(passwordEncoder.encode(password));
//        return userRepository.save(user);
//    }
//
//        //return null;
//    }
////}
