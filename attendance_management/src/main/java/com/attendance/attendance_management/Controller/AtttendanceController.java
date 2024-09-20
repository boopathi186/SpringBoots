//package com.attendance.attendance_management.Controller;
//
//import com.attendance.attendance_management.Services.AttendanceService;
//import com.attendance.attendance_management.Table.AttendanceInfo;
//import com.attendance.attendance_management.Table.LeaveInfo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//
//@RestController
//public class AtttendanceController {
//
//    @Autowired
//    private AttendanceService attendanceService;
//
//    @GetMapping("/attendancerecords")
//    public List<AttendanceInfo> getAttendanceRecord()
//    {
//        return attendanceService.getAttendanceRecord();
//    }
//
//    @PostMapping("/attendancerecords")
//    public void postAttendanceRecord(@RequestBody AttendanceInfo data)
//    {
//        attendanceService.postAttendanceRecord(data);
//    }
//}
package com.attendance.attendance_management.Controller;

import com.attendance.attendance_management.Services.AttendanceService;
import com.attendance.attendance_management.Table.AttendanceInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/attendance")
class AttendanceController {

    private final AttendanceService attendanceService;

    @Autowired
    public AttendanceController(AttendanceService attendanceService) {
        this.attendanceService = attendanceService;
    }

    @GetMapping("/attendancerecords")
    public List<AttendanceInfo> getAttendanceRecord() {
        return attendanceService.getAttendanceRecord();
    }

    @PostMapping("/addattendance")
    public String addAttendanceRecord(@RequestBody AttendanceInfo attendanceInfo) {
        attendanceService.postAttendanceRecord(attendanceInfo);
        return "Attendance record added successfully";
    }
}
