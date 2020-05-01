package com.wjn.blog.repository;

import com.wjn.base.repository.BaseRepository;
import com.wjn.blog.entity.Comment;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends BaseRepository<Comment> {
    @Query(value = "select * from witch_comment where blog_id = ?1 and dr = 0 order by ts asc",nativeQuery = true)
    List<Comment> findByBlogId(String blogId);
}
