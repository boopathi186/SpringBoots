package com.attendance.attendance_management.Controller;

import com.attendance.attendance_management.Services.LeaveService;
import com.attendance.attendance_management.Table.LeaveInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class LeaveController {

    @Autowired
    private LeaveService leaveService;

    @RequestMapping("/leaverecords")
    public List<LeaveInfo> getLeaveData() {
        return leaveService.getLeaveData();
    }

    @GetMapping("/leaverecords/id/{id}")
    public LeaveInfo getRecordById(@PathVariable String id) {
        return leaveService.getRecordById(Integer.parseInt(id));
    }

    @GetMapping("/leaverecords/date/{date}")
    public List<LeaveInfo> getRecordByDate(@PathVariable String date) {
        return leaveService.getRecordByDate(date);
    }


    public void addLeaveForm(LeaveInfo data) {
        leaveService.addLeaveForm(data);

    }
}
