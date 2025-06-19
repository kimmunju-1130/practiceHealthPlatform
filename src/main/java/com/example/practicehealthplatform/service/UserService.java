package com.example.practicehealthplatform.service;

import com.example.practicehealthplatform.model.UserEntity;
import com.example.practicehealthplatform.model.UserRequestDto;
import com.example.practicehealthplatform.model.UserResponseDto;
import com.example.practicehealthplatform.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserService {
    @Autowired
    public UserRepository userRepository;
    //회원추가
    public UserResponseDto addUser(UserRequestDto userRequestDto){
        UserEntity saveUser = userRequestDto.toEntity();
        UserEntity savedUser = userRepository.save(saveUser);
        return UserResponseDto.fromEntity(savedUser);
    }
    //회원삭제
    public void deleteUser(Long id){
        Optional<UserEntity> user = userRepository.findById(id);
        if (user.isEmpty()) {
            throw new IllegalArgumentException("존재하지 않는 회원입니다.");
        }
        UserEntity deletedUser = user.get();
        userRepository.delete(deletedUser);
        System.out.println("회원이 삭제되었습니다.");
    }
    //전체회원조회
    public List<UserResponseDto> getAllUsers() {
        List<UserEntity> users = userRepository.findAll();
        return users.stream()
                .map(user -> new UserResponseDto(user.getId(),user.getUserName(), user.getUserNumber(), user.getStartDay(),user.getEndDay(),user.getGender())).collect(Collectors.toList());
    }//UserResponseDto의 생성자와 UserEntity 생성자 갯수가 맞지 않음, UserResponseDto 6개 포함하여 생성자를 생성해주면 (user) 사용 가능.
    //특정회원조회(이름으로)
    /*public List<UserResponseDto> getUserByName(String userName){
        List<UserEntity> users = userRepository.findByUserName(userName);
        return users.stream()
                .map(UserResponseDto::fromEntity)
                .collect(Collectors.toList());
    }*/
    public List<UserResponseDto> getUserByName(String userName){
        List<UserEntity> users = userRepository.findByUserNameContaining(userName);
        return users.stream()
                .map(UserResponseDto::fromEntity)
                .collect(Collectors.toList());
    }
    //회원정보 변경
    public UserResponseDto updateUser(UserRequestDto userRequestDto) {
        Optional<UserEntity> user = userRepository.findById(userRequestDto.getId());

        if (user.isEmpty()) {
            throw new IllegalArgumentException("사용자가 없습니다 " );
        }
        UserEntity updatedUser = user.get();
        updatedUser.setUserName(userRequestDto.getUserName());
        updatedUser.setStartDay(userRequestDto.getStartDay());
        updatedUser.setEndDay(userRequestDto.getEndDay());
        updatedUser.setGender(userRequestDto.getGender());
        userRepository.save(updatedUser);
        return new UserResponseDto(updatedUser.getId(),updatedUser.getUserName(), updatedUser.getUserNumber(), updatedUser.getStartDay(),updatedUser.getEndDay(),updatedUser.getGender());
    }

}
