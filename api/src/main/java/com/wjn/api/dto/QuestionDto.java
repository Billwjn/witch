package com.wjn.api.dto;

import com.wjn.base.dto.BaseDto;
import lombok.Data;

@Data
public class QuestionDto extends BaseDto {
    private String title;
    private String itema;
    private String itemb;
    private String itemc;
    private String itemd;
    private String answer;
}
