package com.xiaofan.gmall.service;

import com.xiaofan.gmall.bean.PmsProductImage;
import com.xiaofan.gmall.bean.PmsProductInfo;
import com.xiaofan.gmall.bean.PmsProductSaleAttr;

import java.util.List;

public interface SpuService {
    List<PmsProductInfo> spuList(String catalog3Id);

    void saveSpuInfo(PmsProductInfo pmsProductInfo);

    List<PmsProductSaleAttr> spuSaleAttrList(String spuId);

    List<PmsProductImage> spuImageList(String spuId);
}
