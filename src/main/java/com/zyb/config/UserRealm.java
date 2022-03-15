package com.zyb.config;

import com.zyb.entity.User;
import com.zyb.service.IUserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import javax.annotation.Resource;

public class UserRealm extends AuthorizingRealm {
    @Resource
    private IUserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    //登录认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        UsernamePasswordToken token= (UsernamePasswordToken) authenticationToken;
        String username=token.getUsername();
        User queryUser=new User();
        queryUser.setUsername(username);
        //根据用户名查询用户是否存在
        User user=userService.queryUserByName(queryUser);
        if (user==null){
            return null;
        }
        return new SimpleAuthenticationInfo(user,user.getPassword(),getName());
    }
}
