package com.attendance.attendance_management.repository;

import com.attendance.attendance_management.dto.UserDto;
import com.attendance.attendance_management.table.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer> {

}
