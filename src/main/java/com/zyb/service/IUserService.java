package com.zyb.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.zyb.entity.User;

public interface IUserService extends IService<User> {
    User queryUserByName(User user);
}
