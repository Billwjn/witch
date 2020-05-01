package com.wjn.api.dto;

import com.wjn.base.dto.BaseDto;
import lombok.Data;

import java.util.List;

@Data
public class BlogDto extends BaseDto {
    private String code;
    private String title;
    private String content;
    private List<CommentDto> commentDtos;
}
