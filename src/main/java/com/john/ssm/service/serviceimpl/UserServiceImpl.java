package com.john.ssm.service.serviceimpl;

import com.john.ssm.dao.UserMapper;
import com.john.ssm.domain.User;
import com.john.ssm.service.UserService;
import com.john.ssm.util.ActionReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

  public ActionReturnUtil login(String userName, String passWord)
  {
      User  user = new User(1l,userName,passWord);
      if(userMapper.login(user)==null)return ActionReturnUtil.returnSuccess();
      return  ActionReturnUtil.returnError();
  }

  public ActionReturnUtil addUser(User user) {
        if(userMapper.addUser(user)==1) return ActionReturnUtil.returnSuccess();
        return ActionReturnUtil.returnError();
  }

    public ActionReturnUtil deleteUser(User user) {
      if(userMapper.deleteUser(user)==1) return ActionReturnUtil.returnSuccess();
        return ActionReturnUtil.returnError();
    }

    public ActionReturnUtil updateUser(User user) {
      if(userMapper.updateUser(user)==1) return ActionReturnUtil.returnSuccess();
        return ActionReturnUtil.returnError();
    }
    public ActionReturnUtil  getAll(){
        List<User> userList = userMapper.getAllUser();
        List<Map<String,Object>> list = new ArrayList<Map<String, Object>>();
        for(int i=0;i<userList.size();i++){
            User user = userList.get(i);
            Map<String,Object> map = new HashMap<String, Object>();
            map.put("userName",user.getUsername());
            map.put("passWord",user.getPassword());
            list.add(map);
        }
        return ActionReturnUtil.returnSuccessWithData(list);
    }
}
