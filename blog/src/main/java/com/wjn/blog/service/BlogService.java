package com.wjn.blog.service;

import com.wjn.api.dto.BlogDto;
import com.wjn.api.dto.CommentDto;
import com.wjn.base.service.BaseService;
import com.wjn.base.util.ResultData;
import com.wjn.blog.entity.Blog;
import com.wjn.blog.repository.BlogRepository;
import com.wjn.blog.service.mapper.BlogMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

@Service
public class BlogService extends BaseService<BlogDto, Blog, BlogMapper, BlogRepository> {
    @Autowired
    private CommentService commentService;
    @Override
    public BlogDto create(BlogDto dto) {
        if (StringUtils.isEmpty(dto.getTitle())){
            throw new RuntimeException("标题不能为空！");
        }

        return super.create(dto);
    }

    @Override
    public BlogDto findOneById(String id) {
        ResultData resultData = commentService.findByBlogId(id);
        BlogDto blogDto = super.findOneById(id);
        blogDto.setCommentDtos((List<CommentDto>) resultData.getData());
        return blogDto;
    }
}
