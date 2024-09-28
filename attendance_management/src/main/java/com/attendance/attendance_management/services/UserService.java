package com.attendance.attendance_management.services;


import com.attendance.attendance_management.dto.UserDto;
import com.attendance.attendance_management.repository.UserRepository;
import com.attendance.attendance_management.table.UserInfo;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;
    private final List<UserDto> userDtoList = new ArrayList<>();

    public List<UserDto> getUser() {
        userDtoList.clear();
        final List<UserInfo> userDetails = userRepository.findAll();
        userDetails.forEach(user -> {
            UserDto userDto = new UserDto();
            userDto.setDepartment(user.getDepartment());
            userDto.setRoll(user.getRoll());
            userDto.setName(user.getName());
            userDto.setUserId(user.getUserId());
            userDtoList.add(userDto);
        });
        return userDtoList;
    }

    public UserDto getUserById(long id) {
        if (userDtoList.isEmpty()) {
            getUser();
        }
        return userDtoList.stream().filter(user -> user.getUserId().equals(id)).findFirst()
                .orElse(null);
    }

    public UserDto getUserByRoll(String roll) {
        if (userDtoList.isEmpty()) {
            getUser();
        }
        return userDtoList.stream().filter(user -> user.getRoll().equals(roll)).findFirst()
                .orElse(null);
    }

    public UserDto getUserByDepartment(String department) {
        if (userDtoList.isEmpty()) {
            getUser();
        }
        return userDtoList.stream().filter(user -> user.getDepartment().equals(department)).findFirst()
                .orElse(null);
    }

    public void getDelete(long id) {
        userDtoList.removeIf(user -> user.getUserId().equals(id));
    }
}




