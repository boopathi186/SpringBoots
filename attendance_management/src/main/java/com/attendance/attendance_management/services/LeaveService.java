package com.attendance.attendance_management.services;

import com.attendance.attendance_management.dto.LeaveDto;
import com.attendance.attendance_management.mapper.LeaveMapper;
import com.attendance.attendance_management.repository.LeaveRepository;
import com.attendance.attendance_management.table.LeaveInfo;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveRepository leaveRepository;
    private final LeaveMapper leaveMapper;

    public List<LeaveDto> getLeaveData() {
        List<LeaveDto> leaveDtoList = new ArrayList<>();
        final List<LeaveInfo> leaveInfoList = leaveRepository.findAll();
        leaveInfoList.forEach(leaveInfo -> {
            LeaveDto leaveDto = leaveMapper.toDto(leaveInfo);
            leaveDtoList.add(leaveDto);
        });
        return leaveDtoList;
    }

    public LeaveDto getRecordById(int id) {
        LeaveInfo leaveInfo = leaveRepository.findById(id).orElse(null);
        return leaveMapper.toDto(leaveInfo);
    }

    public List<LeaveDto> getRecordByDate(String date) {
        List<LeaveInfo> leaveInfoList = leaveRepository.findByLeaveDate(date);
        return leaveMapper.toDtoList(leaveInfoList);
    }

    public void addLeaveForm(LeaveInfo leaveInfo) {
        leaveRepository.save(leaveInfo);
    }

    public void getDelete(int id) {
        leaveRepository.deleteById(id);
    }


    public void addAbsentForm(LeaveInfo leaveInfo) {
        leaveRepository.save(leaveInfo);
    }
}
