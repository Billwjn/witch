package com.wjn.api;

import com.wjn.api.dto.AdminDto;
import com.wjn.base.util.ResultData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public interface AdminApi {
    @GetMapping("/getById")
    ResultData getById(@RequestParam String id);
}
