package com.wjn.api.dto;

import com.wjn.base.dto.BaseDto;
import lombok.Data;

@Data
public class AdminDto extends BaseDto {
    private String code;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String email;
}
