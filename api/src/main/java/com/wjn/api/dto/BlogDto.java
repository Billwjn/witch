package com.wjn.api.dto;

import com.wjn.base.dto.BaseDto;
import lombok.Data;

@Data
public class BlogDto extends BaseDto {
    private String code;
    private String title;
    private String content;
}
