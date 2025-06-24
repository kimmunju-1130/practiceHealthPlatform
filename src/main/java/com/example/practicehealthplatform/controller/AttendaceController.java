package com.example.practicehealthplatform.controller;

import com.example.practicehealthplatform.model.UserEntity;
import com.example.practicehealthplatform.repository.UserRepository;
import com.example.practicehealthplatform.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/attendance")
public class AttendaceController {
    @Autowired
    private final AttendanceService attendanceService;
    private final UserRepository userRepository;
    //출석조회
    @GetMapping("/{userId}/days")
    public long getAttendaceDays(@PathVariable("userId") Long userId){
        return attendanceService.getAttendanceDays(userId);
    }
    //출석
    @PostMapping("/{userId}")
    public void attendance(@PathVariable("userId") Long userId){
        Optional<UserEntity> user = userRepository.findById(userId);
        attendanceService.attendance(user.orElse(null));
    }
}
