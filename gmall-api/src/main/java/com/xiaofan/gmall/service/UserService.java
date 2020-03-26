package com.xiaofan.gmall.service;

import com.xiaofan.gmall.bean.UmsMember;
import com.xiaofan.gmall.bean.UmsMemberReceiveAddress;

import java.util.List;

public interface UserService {
    List<UmsMember> getAllUser();

    List<UmsMemberReceiveAddress> getReceiveAddressByMemeberId(String memberId);
}
