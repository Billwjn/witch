package com.wjn.api.dto;

import com.wjn.base.dto.BaseDto;
import lombok.Data;

@Data
public class CommentDto extends BaseDto {
    private String blogId;
    /**
     * 评论人
     */
    private String sourceId;
    private String sourceCode;
    private String sourceName;

    /**
     * 回复目标人
     */
    private String targetId;
    private String targetCode;
    private String targetName;

    /**
     * 评论内容
     */
    private String content;
}
