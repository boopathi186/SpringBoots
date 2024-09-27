package com.attendance.attendance_management.services;

import com.attendance.attendance_management.dto.AttendanceDto;
import com.attendance.attendance_management.dto.LeaveDto;
import com.attendance.attendance_management.dto.UserDto;
import com.attendance.attendance_management.repository.AttendanceRepository;
import com.attendance.attendance_management.table.AttendanceInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {
//
//    private final AttendanceRepository attendanceRepository;
//    private final LeaveRepository leaveRepository;
//    private final LeaveInfo leaveInfo;
//    private final LeaveController leaveController;
//    private final UserService userService;
//
//    public List<AttendanceDto> getAttendanceRecord() {
//        return attendanceRepository;
//    }
//
//    public void postAttendanceRecord(AttendanceInfo attendanceInfo) {
//            attendanceRepository.save(attendanceInfo);
//            if(attendanceInfo.getStatus().equals("absent"))
//            {
//                leaveInfo.setLeaveDate(attendanceInfo.getDate());
//                UserDetails userDetails = userService.getUserById(attendanceInfo.getUser().getUser_id());
//                leaveInfo.setUser(userDetails);
//                leaveController.addLeaveForm(leaveInfo);
//            }

//    }
    private final AttendanceRepository attendanceRepository;
    private final List<AttendanceDto> attendanceDtoList = new ArrayList<>();
    private final LeaveDto leaveDto;
    private final UserDto userDto;
    public List<AttendanceDto> getAttendanceRecord() {
       attendanceDtoList.clear();
        final List<AttendanceInfo> attendanceInfos = attendanceRepository.findAll();
        attendanceInfos.forEach(user -> {
            AttendanceDto attendanceDto = new AttendanceDto();
            attendanceDto.setAttendance_id(user.getAttendance_id());
            attendanceDto.setRecordIn(user.getRecordIn());
            attendanceDto.setRecordOut(user.getRecordOut());
            attendanceDto.setStatus(user.getStatus());
            attendanceDto.setDate(user.getDate());

            attendanceDtoList.add(attendanceDto);
        });
        return  attendanceDtoList;
    }


    public void postAttendanceRecord(AttendanceDto attendanceInfo) {
//        if(attendanceInfo.getStatus().equals("absent"))
//            {
//                leaveDto.setLeaveDate(attendanceInfo.getDate());
//                UserDto userDto1 = userDto;
//                leaveDto.setUser(userDto1);
//                leave
//            }
    }
}
