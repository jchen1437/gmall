package com.xiaofan.gmall.manage.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.xiaofan.gmall.bean.PmsBaseCatalog1;
import com.xiaofan.gmall.bean.PmsBaseCatalog2;
import com.xiaofan.gmall.bean.PmsBaseCatalog3;
import com.xiaofan.gmall.service.CatalogService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
//解决跨域请求
@CrossOrigin
public class CatalogController {

    @Reference
    private CatalogService catalogService;

    @RequestMapping("getCatalog3")
    @ResponseBody
    public List<PmsBaseCatalog3> getCatalog3(@RequestParam(value = "catalog2Id") String catalog2Id) {

        List<PmsBaseCatalog3> catalog3s = catalogService.getCatalog3(catalog2Id);
        System.out.println(catalog3s);
        return catalog3s;
    }

    @RequestMapping("getCatalog2")
    @ResponseBody
    public List<PmsBaseCatalog2> getCatalog2(@RequestParam(value = "catalog1Id") String catalog1Id) {

        List<PmsBaseCatalog2> catalog2s = catalogService.getCatalog2(catalog1Id);
        return catalog2s;
    }

    @RequestMapping("getCatalog1")
    @ResponseBody
    public List<PmsBaseCatalog1> getCatalog1() {

        List<PmsBaseCatalog1> catalog1s = catalogService.getCatalog1();
        return catalog1s;
    }

}
