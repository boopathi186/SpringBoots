package com.attendance.attendance_management.Repository;

import com.attendance.attendance_management.Table.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {
}
