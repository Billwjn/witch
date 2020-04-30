package com.wjn.blog.web;

import com.wjn.api.dto.BlogDto;
import com.wjn.base.web.BaseController;
import com.wjn.blog.service.BlogService;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("blog")
@CrossOrigin
public class BlogController extends BaseController<BlogDto, BlogService> {


}
