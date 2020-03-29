package com.xiaofan.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofan.gmall.bean.PmsProductImage;
import com.xiaofan.gmall.bean.PmsProductInfo;
import com.xiaofan.gmall.bean.PmsProductSaleAttr;
import com.xiaofan.gmall.bean.PmsProductSaleAttrValue;
import com.xiaofan.gmall.manage.mapper.PmsProductImageMapper;
import com.xiaofan.gmall.manage.mapper.PmsProductSaleAttrMapper;
import com.xiaofan.gmall.manage.mapper.PmsProductSaleAttrValueMapper;
import com.xiaofan.gmall.manage.mapper.PmsproductinfoMapper;
import com.xiaofan.gmall.service.SpuService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class SpuServiceImpl implements SpuService {

    @Autowired
    private PmsproductinfoMapper pmsproductinfoMapper;

    @Autowired
    private PmsProductImageMapper pmsProductImageMapper;

    @Autowired
    private PmsProductSaleAttrMapper pmsProductSaleAttrMapper;

    @Autowired
    private PmsProductSaleAttrValueMapper pmsProductSaleAttrValueMapper;

    @Override
    public List<PmsProductInfo> spuList(String catalog3Id) {

        Example e = new Example(PmsProductInfo.class);
        e.createCriteria().andEqualTo("catalog3Id", catalog3Id);
        return pmsproductinfoMapper.selectByExample(e);
    }

    @Override
    public void saveSpuInfo(PmsProductInfo pmsProductInfo) {

        //保存商品信息
        pmsproductinfoMapper.insertSelective(pmsProductInfo);

        //保存商品主键
        String productId = pmsProductInfo.getId();

        //保存商品图片信息
        List<PmsProductImage> spuImageList = pmsProductInfo.getSpuImageList();
        for (PmsProductImage pmsProductImage : spuImageList) {
            pmsProductImage.setProductId(productId);
            pmsProductImageMapper.insertSelective(pmsProductImage);
        }

        //保存销售属性信息
        List<PmsProductSaleAttr> spuSaleAttrList = pmsProductInfo.getSpuSaleAttrList();
        for (PmsProductSaleAttr pmsProductSaleAttr : spuSaleAttrList) {
            pmsProductSaleAttr.setProductId(productId);
            pmsProductSaleAttrMapper.insertSelective(pmsProductSaleAttr);

            //保存销售属性值
            List<PmsProductSaleAttrValue> spuSaleAttrValueList = pmsProductSaleAttr.getSpuSaleAttrValueList();
            for (PmsProductSaleAttrValue pmsProductSaleAttrValue : spuSaleAttrValueList) {
                pmsProductSaleAttrValue.setProductId(productId);
                pmsProductSaleAttrValueMapper.insertSelective(pmsProductSaleAttrValue);
            }
        }
    }

    @Override
    public List<PmsProductSaleAttr> spuSaleAttrList(String spuId) {

        Example e = new Example(PmsProductSaleAttr.class);
        e.createCriteria().andEqualTo("productId", spuId);
        List<PmsProductSaleAttr> pmsProductSaleAttrs = pmsProductSaleAttrMapper.selectByExample(e);
        for (PmsProductSaleAttr pmsProductSaleAttr : pmsProductSaleAttrs) {
            Example example = new Example(PmsProductSaleAttrValue.class);
            //多组条件继续在后面加andEqualTo();
            example.createCriteria().andEqualTo("productId", spuId).andEqualTo("saleAttrId", pmsProductSaleAttr.getSaleAttrId());
            //example.createCriteria().andEqualTo("saleAttrId",pmsProductSaleAttr.getSaleAttrId());
            List<PmsProductSaleAttrValue> pmsProductSaleAttrValues = pmsProductSaleAttrValueMapper.selectByExample(example);
            pmsProductSaleAttr.setSpuSaleAttrValueList(pmsProductSaleAttrValues);
        }
        return pmsProductSaleAttrs;
    }

    @Override
    public List<PmsProductImage> spuImageList(String spuId) {
        Example e = new Example(PmsProductImage.class);
        e.createCriteria().andEqualTo("productId", spuId);
        return pmsProductImageMapper.selectByExample(e);
    }
}
