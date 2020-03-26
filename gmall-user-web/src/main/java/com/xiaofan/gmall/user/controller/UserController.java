package com.xiaofan.gmall.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofan.gmall.bean.UmsMember;
import com.xiaofan.gmall.bean.UmsMemberReceiveAddress;
import com.xiaofan.gmall.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Reference
    private UserService userService;

    @RequestMapping("/getReceiveAddressByMemeberId")
    @ResponseBody
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemeberId(String memberId){
        List<UmsMemberReceiveAddress> umsMemberReceiveAddresses = userService.getReceiveAddressByMemeberId(memberId);
        return umsMemberReceiveAddresses;
    }

    @RequestMapping("/getAllUser")
    @ResponseBody
    public List<UmsMember> getAllUser(){
        List<UmsMember> umsMembers = userService.getAllUser();

        return umsMembers;
    }

    @RequestMapping("/index")
    @ResponseBody
    public String index(){
        return "Hello user";
    }

}
