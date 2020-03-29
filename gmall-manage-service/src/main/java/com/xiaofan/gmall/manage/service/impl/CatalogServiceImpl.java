package com.xiaofan.gmall.manage.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.xiaofan.gmall.bean.PmsBaseCatalog1;
import com.xiaofan.gmall.bean.PmsBaseCatalog2;
import com.xiaofan.gmall.bean.PmsBaseCatalog3;
import com.xiaofan.gmall.manage.mapper.PmsBaseCatalog1Mapper;
import com.xiaofan.gmall.manage.mapper.PmsBaseCatalog2Mapper;
import com.xiaofan.gmall.manage.mapper.PmsBaseCatalog3Mapper;
import com.xiaofan.gmall.service.CatalogService;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

@Service
public class CatalogServiceImpl implements CatalogService {

    @Autowired
    PmsBaseCatalog1Mapper pmsBaseCatalog1Mapper;

    @Autowired
    PmsBaseCatalog2Mapper pmsBaseCatalog2Mapper;

    @Autowired
    PmsBaseCatalog3Mapper pmsBaseCatalog3Mapper;

    @Override
    public List<PmsBaseCatalog1> getCatalog1() {
        return pmsBaseCatalog1Mapper.selectAll();
    }

    @Override
    public List<PmsBaseCatalog2> getCatalog2(String catalog1Id) {

        Example e = new Example(PmsBaseCatalog2.class);
        e.createCriteria().andEqualTo("catalog1Id", catalog1Id);
        return pmsBaseCatalog2Mapper.selectByExample(e);
    }

    @Override
    public List<PmsBaseCatalog3> getCatalog3(String catalog2Id) {

        Example e = new Example(PmsBaseCatalog3.class);
        e.createCriteria().andEqualTo("catalog2Id", catalog2Id);
        return pmsBaseCatalog3Mapper.selectByExample(e);

        /*PmsBaseCatalog3 pmsBaseCatalog3 = new PmsBaseCatalog3();
        pmsBaseCatalog3.setCatalog2Id(catalog2Id);
        List<PmsBaseCatalog3> pmsBaseCatalog3s = pmsBaseCatalog3Mapper.select(pmsBaseCatalog3);
        return pmsBaseCatalog3s;*/
    }
}
