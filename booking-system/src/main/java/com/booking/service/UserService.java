package com.booking.service;

import com.booking.model.User;
import com.booking.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository){
        this.userRepository = userRepository;
    }

    List<User> getUsers(){
        return userRepository.findAll();
    }

    Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    User update(Long id, User user){
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            User existingUser = optionalUser.get();
            //existingUser.setUsername(user.getUsername());
            //weiter mit den anderen Fällen ....
        }
        else{
            throw new RuntimeException("User not found with id: " + id);
        }
        return user;
    }

    void deleteUserById(Long id){
        userRepository.deleteById(id);
    }
}
