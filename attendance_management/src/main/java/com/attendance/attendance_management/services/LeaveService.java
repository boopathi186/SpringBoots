package com.attendance.attendance_management.services;

import com.attendance.attendance_management.dto.LeaveDto;
import com.attendance.attendance_management.dto.UserDto;
import com.attendance.attendance_management.repository.LeaveRepository;
import com.attendance.attendance_management.repository.UserRepository;
import com.attendance.attendance_management.table.LeaveInfo;
import com.attendance.attendance_management.table.UserDetails;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final List<LeaveDto> leaveDtoList = new ArrayList<>();

    public List<LeaveDto> getLeaveData() {
        leaveDtoList.clear();
        final List<LeaveInfo> leaveInfoList = leaveRepository.findAll();
        leaveInfoList.forEach(user -> {
            LeaveDto leaveDto = new LeaveDto();
            leaveDto.setLeave_id(user.getLeave_id());
            leaveDto.setLeaveDate(user.getLeaveDate());
            leaveDtoList.add(leaveDto);
        });
       return  leaveDtoList;
    }

    public LeaveDto getRecordById(int id) {
        if(leaveDtoList.isEmpty())
        {
            getLeaveData();
        }
        return leaveDtoList.stream().filter(user -> user.getLeave_id()==id).findFirst()
                .orElse(null);
    }

    public List<LeaveDto> getRecordByDate(String date) {
        return leaveDtoList.stream().filter(user -> user.getLeaveDate().equals(date)).toList();
    }

    public void addLeaveForm(LeaveInfo data) {
        leaveDtoList.add((LeaveDto) getLeaveData());
    }

    public void getDelete(int id) {
      leaveDtoList.removeIf(user -> user.getLeave_id()==(id));

    }
}
