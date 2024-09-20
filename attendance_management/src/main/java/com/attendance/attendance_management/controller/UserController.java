package com.attendance.attendance_management.controller;

import com.attendance.attendance_management.services.UserService;
import com.attendance.attendance_management.table.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {


    private final UserService userService;

    @GetMapping
    public List<UserDetails> getUser() {
        return userService.getUser();
    }

    @GetMapping("/id/{id}")
    public UserDetails getUserById(@PathVariable String id) {
        return userService.getUserById(Long.parseLong(id));
    }

    @GetMapping("/roll/{roll}")
    public List<UserDetails> getUserByRoll(@PathVariable String roll) {
        return userService.getUserByRoll(roll);
    }

    @GetMapping("/department/{department}")
    public List<UserDetails> getUserByDepartment(@PathVariable String department) {
        return userService.getUserByDepartment(department);
    }


    @DeleteMapping("/id/{id}")
    public String getDelete(@PathVariable String id) {
        userService.getDelete(Integer.parseInt(id));
        return "User Deleted";
    }
}
