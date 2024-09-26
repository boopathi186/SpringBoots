package com.attendance.attendance_management.table;

import com.attendance.attendance_management.table.UserDetails;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
@Table(name = "attendance_info")
public class AttendanceInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendance_id;
    @ManyToOne
    @JoinColumn(name = "user_id",referencedColumnName ="user_id")
    private UserDetails user;
    private String date;
    private String RecordIn;
    private String RecordOut;
    private String Status;

    @Override
    public String toString() {
        return "Attendance_info{" +
                "attendance_id=" + attendance_id +
                ", user_id=" + user +
                ", date='" + date + '\'' +
                ", RecordIn='" + RecordIn + '\'' +
                ", RecordOut='" + RecordOut + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
