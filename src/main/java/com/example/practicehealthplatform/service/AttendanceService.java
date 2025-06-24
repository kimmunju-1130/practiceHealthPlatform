package com.example.practicehealthplatform.service;

import com.example.practicehealthplatform.model.AttendanceEntity;
import com.example.practicehealthplatform.model.UserEntity;
import com.example.practicehealthplatform.repository.AttendanceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@RequiredArgsConstructor //생성자 요구를 자동으로 만들어줌
@Service
public class AttendanceService {
    private final AttendanceRepository attendanceRepository;

    //유저id로 출석조회
    public Long getAttendanceDays(Long userId){
        return attendanceRepository.countAttendanceByUserId(userId);
    }
    //유저id로 출석
    public void attendance(UserEntity user){
        AttendanceEntity attendanceEntity = new AttendanceEntity(LocalDateTime.now(), user);
        attendanceRepository.save(attendanceEntity);



    }
}
