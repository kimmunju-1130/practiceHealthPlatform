package com.example.practicehealthplatform.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Setter
@Getter
@NoArgsConstructor
public class AttendanceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long attendanceId;
    @Column
    private LocalDateTime attendanceTime;

    @ManyToOne
    @JoinColumn(name="user_id") // user의 키 이름
    private UserEntity userEntity;

    public AttendanceEntity(LocalDateTime attendanceTime, UserEntity userEntity){
        this.attendanceTime = attendanceTime;
        this.userEntity =userEntity;
    }


}
