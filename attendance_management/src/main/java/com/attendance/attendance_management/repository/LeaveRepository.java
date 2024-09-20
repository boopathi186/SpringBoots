package com.attendance.attendance_management.repository;

import com.attendance.attendance_management.table.LeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveInfo,Integer> {
}
