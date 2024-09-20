package com.attendance.attendance_management.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
@Table(name = "leave_info")
public class LeaveInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leave_id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails user;
    @Column(name = "leave_date")
    private String leaveDate;

}
