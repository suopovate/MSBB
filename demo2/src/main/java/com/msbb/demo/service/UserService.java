package com.msbb.demo.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.msbb.demo.dao.UserMapper;
import com.msbb.demo.entity.persistent.UserDO;
import org.springframework.stereotype.Service;

/**
 * @author vate
 */
@Service
public class UserService extends ServiceImpl<UserMapper,UserDO> {
}
