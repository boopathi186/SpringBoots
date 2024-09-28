package com.attendance.attendance_management.services;

import com.attendance.attendance_management.dto.AttendanceDto;
import com.attendance.attendance_management.mapper.AttendanceMapper;
import com.attendance.attendance_management.repository.AttendanceRepository;
import com.attendance.attendance_management.table.AttendanceInfo;
import com.attendance.attendance_management.table.LeaveInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AttendanceService {

    private final AttendanceRepository attendanceRepository;
    private final AttendanceMapper attendanceMapper;
    private final LeaveService leaveService;

    public List<AttendanceDto> getAttendanceRecord() {
        attendanceMapper.toDto();
        return attendanceMapper.getDtoList();
    }


    public void postAttendanceRecord(AttendanceDto attendanceDto) {
        AttendanceInfo attendanceInfo = attendanceMapper.toEntity(attendanceDto);
        attendanceRepository.save(attendanceInfo);

        if ("leave".equalsIgnoreCase(attendanceDto.getStatus()) && "-".equals(attendanceDto.getRecordIn()) && "-".equals(attendanceDto.getRecordOut())) {
            LeaveInfo leaveInfo = new LeaveInfo();
            leaveInfo.setLeaveDate(attendanceDto.getDate());
            leaveInfo.setUser(attendanceDto.getUser());
            leaveService.addLeaveForm(leaveInfo);
        }

        if ("absent".equalsIgnoreCase(attendanceDto.getStatus()) && "-".equals(attendanceDto.getRecordIn()) && "-".equals(attendanceDto.getRecordOut())) {
            LeaveInfo leaveInfo = new LeaveInfo();
            leaveInfo.setLeaveDate(attendanceDto.getDate());
            leaveInfo.setUser(attendanceDto.getUser());
            leaveService.addAbsentForm(leaveInfo);
        }
    }
}
