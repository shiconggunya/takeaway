package com.apply.reggie.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.apply.reggie.entity.User;
import com.apply.reggie.service.UserService;
import com.apply.reggie.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
* @author a
* @description 针对表【user(用户信息)】的数据库操作Service实现
* @createDate 2023-10-29 10:57:55
*/
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
    implements UserService{

}




