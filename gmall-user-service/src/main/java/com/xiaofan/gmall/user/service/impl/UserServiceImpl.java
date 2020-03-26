package com.xiaofan.gmall.user.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofan.gmall.bean.UmsMember;
import com.xiaofan.gmall.bean.UmsMemberReceiveAddress;
import com.xiaofan.gmall.service.UserService;
import com.xiaofan.gmall.user.mapper.UmsMemberReceiveAddressMapper;
import com.xiaofan.gmall.user.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UmsMemberReceiveAddressMapper umsMemberReceiveAddressMapper;

    @Override
    public List<UmsMember> getAllUser() {

        //List <UmsMember> umsMemberList = userMapper.selectAllUser();
        List<UmsMember> umsMemberList = userMapper.selectAllUser();
        return umsMemberList;
    }

    @Override
    public List<UmsMemberReceiveAddress> getReceiveAddressByMemeberId(String memberId) {

        Example e = new Example(UmsMemberReceiveAddress.class);
        e.createCriteria().andEqualTo("memberId",memberId);

        return umsMemberReceiveAddressMapper.selectByExample(e);
    }
}
