package com.attendance.attendance_management.Table;

import com.attendance.attendance_management.Repository.UserRepository;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component
@Entity
@Getter
@Setter
@Table(name = "user_info")
public class UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int user_id;
    private String name;
    private String roll;
    private String department;



    @Override
    public String toString() {
        return "User_details{" +
                "department='" + department + '\'' +
                ", user_id=" + user_id +
                ", name='" + name + '\'' +
                ", roll='" + roll + '\'' +
                '}';
    }
}
