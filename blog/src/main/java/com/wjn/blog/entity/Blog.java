package com.wjn.blog.entity;

import com.wjn.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

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
