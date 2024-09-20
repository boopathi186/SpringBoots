package com.attendance.attendance_management.table;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Entity
@Getter
@Setter
@Table(name = "attendance_info")
public class AttendanceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendance_id;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private UserDetails user;
    @Column(name = "date")
    private String date;
    @Column(name = "record_in")
    private String RecordIn;
    @Column(name = "record_out")
    private String RecordOut;
    @Column(name = "status")
    private String Status;

}
