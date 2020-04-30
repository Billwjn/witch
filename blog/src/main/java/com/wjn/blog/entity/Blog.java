package com.wjn.blog.entity;

import com.wjn.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "witch_blog")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Blog extends BaseEntity {
    private String code;
    private String title;
    private String content;
}
