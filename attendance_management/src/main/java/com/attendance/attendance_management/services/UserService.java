package com.attendance.attendance_management.services;

import com.attendance.attendance_management.repository.UserRepository;
import com.attendance.attendance_management.table.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

//import com.attendance.attendance_management.Table.UserDetails;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public List<UserDetails> getUser() {
        return userRepository.findAll();
    }

    public UserDetails getUserById(Long id) {
        return userRepository.getReferenceById(Math.toIntExact(id));
    }

    public List<UserDetails> getUserByRoll(String roll) {
        return userRepository.findAll().stream().filter(r -> r.getRoll().equals(roll)).collect(Collectors.toList());
    }

    public List<UserDetails> getUserByDepartment(String department) {
        return userRepository.findAll().stream().filter(r -> r.getDepartment().equals(department)).collect(Collectors.toList());
    }

    public void getDelete(int id) {
        userRepository.deleteById(id);
    }
}
