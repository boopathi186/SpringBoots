package com.attendance.attendance_management.mapper;

import com.attendance.attendance_management.dto.AttendanceDto;
import com.attendance.attendance_management.repository.AttendanceRepository;
import com.attendance.attendance_management.table.AttendanceInfo;
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
public class AttendanceMapper {
    private final AttendanceRepository attendanceRepo;
    private List<AttendanceDto> dtoList = new ArrayList<>();

    public void toDto() {
        dtoList.clear();
        for (AttendanceInfo att : attendanceRepo.findAll()) {
            if (att.getStatus() != null) {
                AttendanceDto attendanceDto = new AttendanceDto();
                attendanceDto.setAttendance_id(att.getAttendance_id());
                attendanceDto.setRecordIn(att.getRecordIn());
                attendanceDto.setRecordOut(att.getRecordOut());
                attendanceDto.setStatus(att.getStatus());
                attendanceDto.setDate(att.getDate());
                attendanceDto.setUser(att.getUser());
                dtoList.add(attendanceDto);
            }
        }
    }

    public AttendanceInfo toEntity(AttendanceDto attendanceDto) {
        AttendanceInfo attendanceDetails = new AttendanceInfo();
        attendanceDetails.setAttendance_id(attendanceDto.getAttendance_id());
        attendanceDetails.setDate(attendanceDto.getDate());
        attendanceDetails.setStatus(attendanceDto.getStatus());
        attendanceDetails.setRecordIn(attendanceDto.getRecordIn());
        attendanceDetails.setRecordOut(attendanceDto.getRecordOut());
        attendanceRepo.save(attendanceDetails);
        return attendanceDetails;
    }

}

