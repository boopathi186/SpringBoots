package com.attendance.attendance_management.Services;

import com.attendance.attendance_management.Repository.UserRepository;
import com.attendance.attendance_management.Table.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

//import com.attendance.attendance_management.Table.UserDetails;

@Component
public class UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    public List<UserDetails> getUser() {
        return userRepository.findAll();
    }

    public UserDetails getUserById(int id) {
        return userRepository.getReferenceById(id);
    }

    public List<UserDetails> getUserByRoll(String roll) {
        return userRepository.findAll().stream().filter(r -> r.getRoll().equals(roll)).collect(Collectors.toList());
    }

    public List<UserDetails> getUserBydepartment(String department) {
        return userRepository.findAll().stream().filter(r -> r.getDepartment().equals(department)).collect(Collectors.toList());
    }
}
