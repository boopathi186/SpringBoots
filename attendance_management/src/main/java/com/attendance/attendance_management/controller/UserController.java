package com.attendance.attendance_management.controller;

import com.attendance.attendance_management.dto.UserDto;
import com.attendance.attendance_management.services.UserService;
import com.attendance.attendance_management.table.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class UserController {

    @Autowired
    private  UserService userService;

    @GetMapping
    public List<UserDto> getUser() {
        return userService.getUser();
    }

    @GetMapping("/id/{id}")
    public UserDto getUserById(@PathVariable String id) {
        return (UserDto) userService.getUserById(Long.parseLong(id));
    }

    @GetMapping("/roll/{roll}")
    public UserDto getUserByRoll(@PathVariable String roll) {
        return userService.getUserByRoll(roll);
    }

    @GetMapping("/department/{department}")
    public UserDto getUserByDepartment(@PathVariable String department) {
        return userService.getUserByDepartment(department);
    }


    @DeleteMapping("/id/{id}")
    public String getDelete(@PathVariable String id) {
        userService.getDelete(Long.parseLong(id));
        return "User Deleted";
    }
}
