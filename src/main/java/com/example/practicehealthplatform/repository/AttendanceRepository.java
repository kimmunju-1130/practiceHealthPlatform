package com.example.practicehealthplatform.repository;

import com.example.practicehealthplatform.model.AttendanceEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AttendanceRepository extends JpaRepository<AttendanceEntity,Long> {
    @Query("SELECT COUNT(DISTINCT a.attendanceTime )FROM AttendanceEntity a WHERE a.userEntity.id = :userId")//:다음 띄워쓰기 인식됨.
    long countAttendanceByUserId(@Param("userId") Long userId);
}
