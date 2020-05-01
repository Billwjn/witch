package com.wjn.admin.web.rest;

import com.wjn.admin.service.AdminService;
import com.wjn.api.AdminApi;
import com.wjn.api.dto.AdminDto;
import com.wjn.base.util.ResultData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminRest implements AdminApi {
    @Autowired
    private AdminService adminService;
    @Override
    @GetMapping("/getById")
    public ResultData getById(@RequestParam String id) {
        try {
            AdminDto adminDto = adminService.findOneById(id);
            return ResultData.build(1,"微服务调用查询详情成功",adminDto);
        }catch (Exception e){
            e.printStackTrace();
            String msg = StringUtils.isEmpty(e.getMessage()) ? "微服务调用查询详情失败" :e.getMessage();
            return ResultData.build(0,msg,e.getMessage());
        }

    }
}
