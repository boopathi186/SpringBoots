package com.attendance.attendance_management.services;

import com.attendance.attendance_management.repository.LeaveRepository;
import com.attendance.attendance_management.table.LeaveInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class LeaveService {

    private final LeaveRepository leaveRepository;
    public List<LeaveInfo> getLeaveData() {
        return leaveRepository.findAll();
    }

    public LeaveInfo getRecordById(int id) {
        return leaveRepository.findById(id).orElse(null);
    }

    public List<LeaveInfo> getRecordByDate(String date) {
        return leaveRepository.findAll().stream().filter(r -> r.getLeaveDate().equals(date)).collect(Collectors.toList());
    }

    public void addLeaveForm(LeaveInfo data) {
        leaveRepository.save(data);
    }

    public void getDelete(int id) {
      leaveRepository.deleteById(id);

    }
}
