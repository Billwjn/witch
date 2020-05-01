package com.wjn.blog.service.mapper;

import com.wjn.api.dto.CommentDto;
import com.wjn.base.mapper.BaseMapper;
import com.wjn.blog.entity.Comment;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public abstract class CommentMapper extends BaseMapper<Comment, CommentDto> {
    @Override
    @Mapping(source = "sourceAdmin.id" , target = "sourceId")
    @Mapping(source = "sourceAdmin.code" , target = "sourceCode")
    @Mapping(source = "sourceAdmin.username" , target = "sourceName")
    @Mapping(source = "targetAdmin.id" , target = "targetId")
    @Mapping(source = "targetAdmin.code" , target = "targetCode")
    @Mapping(source = "targetAdmin.username" , target = "targetName")
    public abstract CommentDto entityToDto(Comment entity);
}
