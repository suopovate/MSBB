package com.msbb.demo.web;

import com.msbb.demo.entity.enums.Status;
import com.msbb.demo.entity.persistent.UserDO;
import com.msbb.demo.service.UserClient;
import com.msbb.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author vate
 */
@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;
    @Autowired
    UserClient userClient;

    @RequestMapping("/add")
    public boolean add(String userName,String password,Status status){
        return userClient.create(userName,password,status);
    }

    @RequestMapping("/list")
    public List<UserDO> get(){
        return userClient.list();
    }
}
