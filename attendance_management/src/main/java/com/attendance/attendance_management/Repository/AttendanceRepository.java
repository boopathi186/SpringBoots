package com.attendance.attendance_management.Repository;

import com.attendance.attendance_management.Table.AttendanceInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceInfo, Integer> {

}
