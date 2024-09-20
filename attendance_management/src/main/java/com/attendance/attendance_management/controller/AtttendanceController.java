package com.attendance.attendance_management.controller;

import com.attendance.attendance_management.services.AttendanceService;
import com.attendance.attendance_management.table.AttendanceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
class AttendanceController {

    private final AttendanceService attendanceService;

    @GetMapping
    public List<AttendanceInfo> getAttendanceRecord() {
        return attendanceService.getAttendanceRecord();
    }

    @PostMapping("/addattendance")
    public String addAttendanceRecord(@RequestBody AttendanceInfo attendanceInfo) {
        attendanceService.postAttendanceRecord(attendanceInfo);
        return "Attendance record added successfully";
    }
}
