package com.attendance.attendance_management.Table;

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
    private int leave_id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName ="user_id" )
    private UserDetails user;
    private String leave_date;

}
