package com.attendance.attendance_management.Services;

import com.attendance.attendance_management.Repository.LeaveRepository;
import com.attendance.attendance_management.Table.LeaveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LeaveService {

    private final LeaveRepository leaveRepository;

    public LeaveService(LeaveRepository leaveRepository) {
        this.leaveRepository = leaveRepository;
    }

    public List<LeaveInfo> getLeaveData() {
        return leaveRepository.findAll();
    }

    public LeaveInfo getRecordById(int id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public List<LeaveInfo> getRecordByDate(String date) {
        return leaveRepository.findAll().stream().filter(r -> r.getLeave_date().equals(date)).collect(Collectors.toList());
    }

    public void addLeaveForm(LeaveInfo data) {
        leaveRepository.save(data);
    }
}
