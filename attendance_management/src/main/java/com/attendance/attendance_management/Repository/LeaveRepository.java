package com.attendance.attendance_management.Repository;

import com.attendance.attendance_management.Table.LeaveInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LeaveRepository extends JpaRepository<LeaveInfo,Integer> {
}
