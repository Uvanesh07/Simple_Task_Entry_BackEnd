package com.task.management.service;

import com.task.management.entity.UsersEntity;
import com.task.management.repository.UsersRepository;
import org.springframework.stereotype.Service;

@Service
public class UsersService {
    private final UsersRepository usersRepository;

    public UsersService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    public UsersEntity registerUser(String name,String email,String course,String college,String phone_no,String address,String city,String password) {
        if (email == null || password == null) {
            return null;
        }
        else{
            UsersEntity usersEntity = new UsersEntity();
            usersEntity.setName(name);
            usersEntity.setEmail(email);
            usersEntity.setCourse(course);
            usersEntity.setCollege(college);
            usersEntity.setPhoneNo(phone_no);
            usersEntity.setAddress(address);
            usersEntity.setCity(city);
            usersEntity.setPassword(password);
            return usersRepository.save(usersEntity);
            }
        }

    public UsersEntity authenticate(String email, String password){
        return usersRepository.findByEmailAndPassword(email, password).orElse(null);
    }
}
