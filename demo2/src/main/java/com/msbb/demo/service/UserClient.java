package com.msbb.demo.service;

import com.msbb.demo.entity.enums.Status;
import com.msbb.demo.entity.persistent.UserDO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("demo")
public interface UserClient {
    @RequestMapping(method = RequestMethod.GET, value = "/users/list")
    List<UserDO> list();

    @RequestMapping(method = RequestMethod.GET, value = "/users/add")
    boolean create(@RequestParam String userName, @RequestParam String password, @RequestParam Status status);
}