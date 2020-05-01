package com.wjn.blog.entity;

import com.wjn.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "witch_comment")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Comment extends BaseEntity {
    private String blogId;
    private String sourceId;
    private String targetId;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "sourceId",insertable=false,updatable=false)
    private Admin sourceAdmin;
    @ManyToOne
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "targetId",insertable=false,updatable=false)
    private Admin targetAdmin;
    private String content;
}
