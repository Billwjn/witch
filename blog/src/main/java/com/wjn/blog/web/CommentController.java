package com.wjn.blog.web;

import com.wjn.api.dto.CommentDto;
import com.wjn.base.web.BaseController;
import com.wjn.blog.service.CommentService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("comment")
@CrossOrigin
public class CommentController extends BaseController<CommentDto, CommentService> {
}
