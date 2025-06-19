package com.example.practicehealthplatform.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String userName;
    private String userNumber;
    private LocalDate startDay;
    private LocalDate endDay;
    private String gender;

    public UserEntity(String userName, String userNumber, LocalDate startDay, LocalDate endDay, String gender) {
        this.userName=userName;
        this.userNumber=userNumber;
        this.startDay=startDay;
        this.endDay=endDay;
        this.gender=gender;
    }
    //id는 자동으로 생성되는 것이므로 생성자에서 제외해서 만들어야 오류가 안남.



}
