package com.wjn.blog.service.mapper;

import com.wjn.api.dto.BlogDto;
import com.wjn.base.mapper.BaseMapper;
import com.wjn.blog.entity.Blog;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface BlogMapper extends BaseMapper<Blog, BlogDto> {
}
