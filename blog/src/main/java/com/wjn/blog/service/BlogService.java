package com.wjn.blog.service;

import com.wjn.api.dto.BlogDto;
import com.wjn.base.service.BaseService;
import com.wjn.blog.entity.Blog;
import com.wjn.blog.repository.BlogRepository;
import com.wjn.blog.service.mapper.BlogMapper;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class BlogService extends BaseService<BlogDto, Blog, BlogMapper, BlogRepository> {
    @Override
    public BlogDto create(BlogDto dto) {
        if (StringUtils.isEmpty(dto.getTitle())){
            throw new RuntimeException("标题不能为空！");
        }

        return super.create(dto);
    }
}
