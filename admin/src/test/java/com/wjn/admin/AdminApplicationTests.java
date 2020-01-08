package com.wjn.admin;

import com.wjn.admin.entity.Admin;
import com.wjn.admin.repository.AdminRepository;
import com.wjn.admin.service.AdminService;
import com.wjn.api.dto.AdminDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class AdminApplicationTests {
    @Autowired
    private AdminService adminService;

    @Test
    void contextLoads() {
        List<AdminDto> all = adminService.findAll();
        for (AdminDto adminDto : all) {
            System.out.println(adminDto);
        }
    }

}
