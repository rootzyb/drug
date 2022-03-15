package com.zyb.controller;

import com.zyb.common.ResultMapUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {

    @RequestMapping("/login")
    public String login(){
        return "login";
    }

    @RequestMapping(value = "/toLogin",method = RequestMethod.POST)
    @ResponseBody
    public Object toLogin(String username,String password){
        if (username==null||password==null){
            return ResultMapUtil.getHashMapLogin("用户名和密码不能为空","2");
        }
        Subject subject= SecurityUtils.getSubject();
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);

        try {
            subject.login(token);
        } catch (UnknownAccountException e) {
            return ResultMapUtil.getHashMapLogin("账号不存在","2");
        }catch (IncorrectCredentialsException e){
            return ResultMapUtil.getHashMapLogin("密码错误","2");
        }

        return ResultMapUtil.getHashMapLogin("验证成功","1");
    }

    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("/logout")
    public String logout(){
        Subject subject= SecurityUtils.getSubject();
        subject.logout();
        return "redirect:/login";
    }
}
