package com.wjn.admin.web;

import com.wjn.admin.service.AdminService;
import com.wjn.api.dto.AdminDto;
import com.wjn.base.util.ResultData;
import com.wjn.base.web.BaseController;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("admin")
@CrossOrigin
public class AdminController extends BaseController<AdminDto, AdminService> {

    /**
     * 登陆方法
     *
     * @author wujianong
     */
    @PostMapping("login")
    public ResultData login(HttpServletRequest request){
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        return service.login(username,password);
    }
}
