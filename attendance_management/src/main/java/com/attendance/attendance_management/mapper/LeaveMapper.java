package com.attendance.attendance_management.mapper;

import com.attendance.attendance_management.dto.LeaveDto;
import com.attendance.attendance_management.table.LeaveInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@RequiredArgsConstructor
public class LeaveMapper {

    public LeaveDto toDto(LeaveInfo leaveInfo) {
        LeaveDto leaveDto = new LeaveDto();
        leaveDto.setLeave_id(leaveInfo.getLeave_id());
        leaveDto.setLeaveDate(leaveInfo.getLeaveDate());
        leaveDto.setUser(leaveInfo.getUser());
        return leaveDto;
    }

    public LeaveInfo toEntity(LeaveDto leaveDto) {
        LeaveInfo leaveInfo = new LeaveInfo();
        leaveInfo.setLeaveDate(leaveDto.getLeaveDate());
        leaveInfo.setLeave_id(leaveDto.getLeave_id());
        leaveInfo.setUser(leaveDto.getUser());
        return leaveInfo;
    }

    public List<LeaveDto> toDtoList(List<LeaveInfo> leaveInfoList) {
        List<LeaveDto> leaveDtoList = new ArrayList<>();
        for (LeaveInfo leaveInfo : leaveInfoList) {
            leaveDtoList.add(toDto(leaveInfo));
        }
        return leaveDtoList;
    }
}
