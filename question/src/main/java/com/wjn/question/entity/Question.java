package com.wjn.question.entity;

import com.wjn.base.entity.BaseEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "WITCH_QUESTION")
@Data
public class Question extends BaseEntity {
    private String title;
    private String itema;
    private String itemb;
    private String itemc;
    private String itemd;
    private String answer;
}
