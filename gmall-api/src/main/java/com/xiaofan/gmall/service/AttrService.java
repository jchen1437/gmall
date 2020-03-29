package com.xiaofan.gmall.service;

import com.xiaofan.gmall.bean.PmsBaseAttrInfo;
import com.xiaofan.gmall.bean.PmsBaseAttrValue;
import com.xiaofan.gmall.bean.PmsBaseSaleAttr;

import java.util.List;

public interface AttrService {
    List<PmsBaseAttrInfo> attrInfoList(String catalog3Id);

    String saveAttrInfo(PmsBaseAttrInfo pmsBaseAttrInfo);

    List<PmsBaseAttrValue> getAttrValueList(String attrId);

    List<PmsBaseSaleAttr> baseSaleAttrList();

}
