package com.wjn.admin.service;

import com.wjn.admin.entity.Admin;
import com.wjn.admin.repository.AdminRepository;
import com.wjn.api.dto.AdminDto;
import com.wjn.admin.service.mapper.AdminMapper;
import com.wjn.base.service.BaseService;
import com.wjn.base.util.ResultData;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class AdminService extends BaseService<AdminDto,Admin,AdminMapper, AdminRepository> {
    /**
     * 登陆方法
     *
     * @author wujianong
     */
    public ResultData login(String username , String password){
        //判断用户名是否为空
        if (StringUtils.isEmpty(username)){
            return ResultData.build(0,"用户名为空",null);
        }
        //通过用户名查询当前用户
        try {
            Admin admin = repository.fingAdminByUsername(username);
            //如果用户为空，说明该用户不存在
            if (admin == null){
                return ResultData.build(0,"该用户不存在",null);
            }else{
                //该用户存在，比对密码
                if (admin.getPassword().equals(password)){
                    //密码正确
                    return ResultData.build(1,"登陆成功",mapper.entityToDto(admin));
                }else{
                    return ResultData.build(0,"密码错误",null);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
            String msg = StringUtils.isEmpty(e.getMessage()) ? "登陆失败" : e.getMessage();
            return ResultData.build(0,msg,e.getMessage());
        }
    }
}
