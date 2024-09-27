package com.attendance.attendance_management.dto;

import com.attendance.attendance_management.table.UserDetails;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AttendanceDto {
    private Long attendance_id;
    private String date;
    private String RecordIn;
    private UserDetails user;
    private String RecordOut;
    private String Status;

}

