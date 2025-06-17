package com.example.practicehealthplatform.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDto {
    private Long id;
    private String userName;
    private String userNumber;
    private LocalDate startDay;
    private LocalDate endDay;
    private String gender;

    public UserEntity toEntity(){
        return new UserEntity(this.userName,this.userNumber,this.startDay,this.endDay,this.gender);
    }
}
