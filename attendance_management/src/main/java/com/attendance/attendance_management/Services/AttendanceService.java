package com.attendance.attendance_management.Services;

import com.attendance.attendance_management.Controller.LeaveController;
import com.attendance.attendance_management.Repository.AttendanceRepository;
import com.attendance.attendance_management.Repository.LeaveRepository;
import com.attendance.attendance_management.Table.AttendanceInfo;
import com.attendance.attendance_management.Table.LeaveInfo;
import com.attendance.attendance_management.Table.UserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final LeaveRepository leaveRepository;
    private final LeaveInfo leaveInfo;
    private final LeaveController leaveController;
    private final UserService userService;

    @Autowired
    public AttendanceService(AttendanceRepository attendanceRepository, LeaveRepository leaveRepository, LeaveInfo leaveInfo, LeaveController leaveController, UserService userService) {
        this.attendanceRepository = attendanceRepository;
        this.leaveRepository = leaveRepository;
        this.leaveInfo = leaveInfo;
        this.leaveController = leaveController;
        this.userService = userService;
    }

    public List<AttendanceInfo> getAttendanceRecord() {
        return attendanceRepository.findAll();
    }

    public void postAttendanceRecord(AttendanceInfo attendanceInfo) {
            attendanceRepository.save(attendanceInfo);
            if(attendanceInfo.getStatus().equals("absent"))
            {
                leaveInfo.setLeave_date(attendanceInfo.getDate());
                UserDetails userDetails = userService.getUserById(attendanceInfo.getUser_id());
                leaveInfo.setUser(userDetails);
                leaveController.addLeaveForm(leaveInfo);
            }

    }
}
