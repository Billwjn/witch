package com.wjn.blog.service;

import com.wjn.api.dto.CommentDto;
import com.wjn.base.service.BaseService;
import com.wjn.base.util.ResultData;
import com.wjn.blog.entity.Comment;
import com.wjn.blog.repository.CommentRepository;
import com.wjn.blog.service.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService extends BaseService<CommentDto, Comment, CommentMapper, CommentRepository> {
    @Autowired
    private CommentRepository commentRepository;

    /**
     * 根据博客id获取所有评论
     * @param blogId
     * @return
     */
    public ResultData findByBlogId(String blogId){
        List<Comment> comments = commentRepository.findByBlogId(blogId);
        List<CommentDto> commentDtos = this.mapper.entitiesToDtos(comments);
        return ResultData.build(1,"根据博客id查询评论列表成功",commentDtos);
    }
}
