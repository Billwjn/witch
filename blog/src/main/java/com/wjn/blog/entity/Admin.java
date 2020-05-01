package com.wjn.blog.entity;

import com.wjn.base.entity.BaseEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "witch_admin")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Admin extends BaseEntity {
    private String code;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String email;
}
