package com.john.ssm.dao;

import com.john.ssm.domain.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {
    User login(User user);
    int addUser(User user);
    int updateUser(User user);
    int deleteUser(User user);
    List<User> getAllUser();
}
