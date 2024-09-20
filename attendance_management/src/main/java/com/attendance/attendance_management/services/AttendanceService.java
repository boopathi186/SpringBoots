package com.attendance.attendance_management.services;

import com.attendance.attendance_management.controller.LeaveController;
import com.attendance.attendance_management.repository.AttendanceRepository;
import com.attendance.attendance_management.repository.LeaveRepository;
import com.attendance.attendance_management.table.AttendanceInfo;
import com.attendance.attendance_management.table.LeaveInfo;
import com.attendance.attendance_management.table.UserDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final LeaveRepository leaveRepository;
    private final LeaveInfo leaveInfo;
    private final LeaveController leaveController;
    private final UserService userService;


    public List<AttendanceInfo> getAttendanceRecord() {
        return attendanceRepository.findAll();
    }

    public void postAttendanceRecord(AttendanceInfo attendanceInfo) {
            attendanceRepository.save(attendanceInfo);
            if(attendanceInfo.getStatus().equals("absent"))
            {
                leaveInfo.setLeaveDate(attendanceInfo.getDate());
                UserDetails userDetails = userService.getUserById(attendanceInfo.getUser().getUser_id());
                leaveInfo.setUser(userDetails);
                leaveController.addLeaveForm(leaveInfo);
            }

    }
}
