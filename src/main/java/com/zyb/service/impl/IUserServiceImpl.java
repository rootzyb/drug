package com.zyb.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zyb.entity.User;
import com.zyb.mapper.UserMapper;
import com.zyb.service.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class IUserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User queryUserByName(User user) {
        QueryWrapper<User> queryWrapper=new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        return userMapper.selectOne(queryWrapper);
    }
}
