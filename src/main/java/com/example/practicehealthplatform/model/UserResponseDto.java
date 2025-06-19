package com.example.practicehealthplatform.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.catalina.User;

import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponseDto {
    private Long id;
    private String userName;
    private String userNumber;
    private LocalDate startDay;
    private LocalDate endDay;
    private String gender;




    public static UserResponseDto fromEntity(UserEntity userEntity){
        UserResponseDto userResponseDto = new UserResponseDto();
        userResponseDto.id = userEntity.getId();
        userResponseDto.userName = userEntity.getUserName();
        userResponseDto.userNumber = userEntity.getUserNumber();
        userResponseDto.startDay = userEntity.getStartDay();
        userResponseDto.endDay = userEntity.getEndDay();
        userResponseDto.gender = userEntity.getGender();
        return userResponseDto;
    }
}
