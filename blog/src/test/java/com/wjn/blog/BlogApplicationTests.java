package com.wjn.blog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class BlogApplicationTests {
    @Autowired
    private com.wjn.blog.service.BlogService BlogService;


}
