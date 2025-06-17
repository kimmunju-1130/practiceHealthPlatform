package com.example.practicehealthplatform.controller;

import com.example.practicehealthplatform.model.UserRequestDto;
import com.example.practicehealthplatform.model.UserResponseDto;
import com.example.practicehealthplatform.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {
    @Autowired
    public UserService userService;
    //전체회원 조회
    @GetMapping("/get")
    public List<UserResponseDto> getAllUserByName() {
        List<UserResponseDto> getAllUserByName2 = userService.getAllUsers();
        return getAllUserByName2;
    }
    //특정회원 조회
    @GetMapping("/getName")
    public List<UserResponseDto> getUserByName(@RequestParam String userName){
        List<UserResponseDto> getUserByName2 = userService.getUserByName(userName);
        return getUserByName2;
    }
    //회원등록
    @PostMapping("/add")
    public UserResponseDto addUser(@RequestBody UserRequestDto userRequestDto) {
        UserResponseDto userResponseDto2 = userService.addUser(userRequestDto);
        return userResponseDto2;
    }
    //회원삭제
    @DeleteMapping("/delete/{userNumber}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }
}
