package com.john.ssm.service;

import com.john.ssm.domain.User;
import com.john.ssm.util.ActionReturnUtil;

public interface UserService {
    ActionReturnUtil login(String userName, String passWord);
    ActionReturnUtil addUser(User user);
    ActionReturnUtil updateUser(User user);
    ActionReturnUtil deleteUser(User user);
    ActionReturnUtil  getAll();
}
