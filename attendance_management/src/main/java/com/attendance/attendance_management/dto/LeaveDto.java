package com.attendance.attendance_management.dto;

import com.attendance.attendance_management.table.UserDetails;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
public class LeaveDto {
    private Long leave_id;
    private UserDetails user;
    private String leaveDate;

    public void setUser(UserDto userDto1) {
    }
}
