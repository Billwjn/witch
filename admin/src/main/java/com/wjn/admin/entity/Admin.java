package com.wjn.admin.entity;

import com.wjn.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WITCH_ADMIN")
@Data
public class Admin extends BaseEntity {
    private String code;
    private String username;
    private String password;
    private String nickname;
    private String phone;
    private String email;
}
