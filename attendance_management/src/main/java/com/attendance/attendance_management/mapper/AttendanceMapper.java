package com.attendance.attendance_management.mapper;

import com.attendance.attendance_management.dto.AttendanceDto;
import com.attendance.attendance_management.repository.AttendanceRepository;
import com.attendance.attendance_management.table.AttendanceInfo;
import com.attendance.attendance_management.table.UserDetails;
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

   public  void toDto()
   {
       for (AttendanceInfo att : attendanceRepo.findAll())
       {
           if(att.getStatus() != null)
           {
               dtoList.add(new AttendanceDto(att.getAttendance_id(),
                       att.getDate(),att.getStatus(),att.getRecordIn(),att.getRecordOut(),att.getUser()));
           }
       }
   }

   public  void toEntity(AttendanceDto attendanceDto)
   {
       AttendanceInfo attendanceDetails = new AttendanceInfo();
       attendanceDetails.setAttendance_id(attendanceDto.getAttendance_id());
       attendanceDetails.setDate(attendanceDto.getDate());
       attendanceDetails.setStatus(attendanceDto.getStatus());
       attendanceDetails.setRecordIn(attendanceDto.getRecordIn());
       attendanceDetails.setRecordOut(attendanceDto.getRecordOut());
       UserDetails userDetails = new UserDetails();
       userDetails.setUserId(attendanceDto.getUser().getUserId());
       attendanceRepo.save(attendanceDetails);
   }

}

