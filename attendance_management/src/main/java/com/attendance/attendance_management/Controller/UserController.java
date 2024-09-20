package com.attendance.attendance_management.Controller;

import com.attendance.attendance_management.Services.UserService;
import com.attendance.attendance_management.Table.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping("/user")
    public List<UserDetails> getUser() {
        return userService.getUser();
    }

    @GetMapping("/user/{id}")
    public UserDetails getUserById(@PathVariable String id) {
        return userService.getUserById(Integer.parseInt(id));
    }

    @GetMapping("/user/roll={roll}")
    public List<UserDetails> getUserByRoll(@PathVariable String roll) {
        return userService.getUserByRoll(roll);
    }

    @GetMapping("/user/department={department}")
    public List<UserDetails> getUserByDepartment(@PathVariable String department) {
        return userService.getUserBydepartment(department);
    }
}
