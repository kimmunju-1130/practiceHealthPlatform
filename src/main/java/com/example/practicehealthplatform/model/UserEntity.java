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
    }

    public UserEntity get() {
        return null;
    }
}
