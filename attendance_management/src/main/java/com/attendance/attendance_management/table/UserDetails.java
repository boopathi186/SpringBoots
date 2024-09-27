package com.attendance.attendance_management.table;

import com.attendance.attendance_management.repository.UserRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "name")
    private String name;
    @Column(name = "roll")
    private String roll;
    @Column(name = "department")
    private String department;

}
