package com.john.ssm.controller;

import com.john.ssm.domain.User;
import com.john.ssm.service.UserService;
import com.john.ssm.util.ActionReturnUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value = "/login",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    ActionReturnUtil userLogin(@RequestBody  User user)
    {
        return userService.login(user.getUsername(),user.getPassword());
    }
    @RequestMapping(value = "/addUser",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    ActionReturnUtil addUser(@RequestBody User user)
    {
        return userService.addUser(user);
    }
    @RequestMapping(value = "/getUsers",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    ActionReturnUtil getAll()
    {
        return userService.getAll();
    }
    @RequestMapping(value = "/deleteUser",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    ActionReturnUtil deleteUser(@RequestBody User user)
    {
        return userService.deleteUser(user);
    }
    @RequestMapping(value = "/updateUser",method = RequestMethod.POST,consumes = "application/json",produces = "application/json")
    public @ResponseBody
    ActionReturnUtil updateUser(User user)
    {
        return userService.updateUser(user);
    }
}
