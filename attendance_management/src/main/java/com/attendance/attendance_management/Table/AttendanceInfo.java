package com.attendance.attendance_management.Table;

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
    private int attendance_id;
    @JoinColumn
    private int user_id;
    private String date;
    private String RecordIn;
    private String RecordOut;
    private String Status;

    @Override
    public String toString() {
        return "Attendance_info{" +
                "attendance_id=" + attendance_id +
                ", user_id=" + user_id +
                ", date='" + date + '\'' +
                ", RecordIn='" + RecordIn + '\'' +
                ", RecordOut='" + RecordOut + '\'' +
                ", Status='" + Status + '\'' +
                '}';
    }
}
