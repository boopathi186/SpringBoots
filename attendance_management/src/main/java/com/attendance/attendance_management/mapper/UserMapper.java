package com.attendance.attendance_management.mapper;

import com.attendance.attendance_management.dto.UserDto;
import com.attendance.attendance_management.repository.UserRepository;
import com.attendance.attendance_management.table.UserInfo;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Component
@RequiredArgsConstructor
public class UserMapper {
    private final UserRepository userRepository;
    private List<UserDto> userDto = new ArrayList<>();

    public void toDto() {
        for (UserInfo userDetails : userRepository.findAll()) {
            if (userDetails.getUserId() != null) {
                userDto.add(new UserDto());
            }
        }
    }

    public UserInfo toEntity(UserDto userDtoEntity) {
        UserInfo userInfo = new UserInfo();
        userInfo.setUserId(userDtoEntity.getUserId());
        userInfo.setName(userDtoEntity.getName());
        userInfo.setDepartment(userDtoEntity.getDepartment());
        userInfo.setRoll(userDtoEntity.getRoll());
        userRepository.save(userInfo);
        return userInfo;
    }
}
