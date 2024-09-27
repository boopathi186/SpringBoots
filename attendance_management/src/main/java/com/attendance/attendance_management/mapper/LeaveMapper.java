package com.attendance.attendance_management.mapper;

import com.attendance.attendance_management.dto.LeaveDto;
import com.attendance.attendance_management.repository.LeaveRepository;
import com.attendance.attendance_management.table.LeaveInfo;
import com.attendance.attendance_management.table.UserDetails;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class LeaveMapper {
    private final LeaveRepository leaveRepo;
    private final List<LeaveDto> leaveDtoList = new ArrayList<>();

    public void  toDto()
    {
        for (LeaveInfo leaveInfo : leaveRepo.findAll())
        {
//            if(leaveInfo.getLeave_id() != null)
//            {
//                leaveDtoList.add(new LeaveDto());
//            }
        }
    }
    }

