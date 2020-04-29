package com.wjn.base.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.util.Date;

/**
 * 实体类的抽象基类
 *
 * @author wujianong
 */
@MappedSuperclass
public class BaseEntity implements Serializable {
    @Id
    @Column(name = "ID")
    private String id;
    @Column(name = "DR")
    private Integer dr;
    @Column(name = "TS")
    private Date ts;
    @Column(name = "CREATOR")
    private String creator;
    @Column(name = "CREATE_TIME")
    private Date createTime;
    @Column(name = "MODIFIER")
    private String modifier;
    @Column(name = "MODIFY_TIME")
    private Date modifyTime;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getDr() {
        return dr;
    }

    public void setDr(Integer dr) {
        this.dr = dr;
    }

    public Date getTs() {
        return ts;
    }

    public void setTs(Date ts) {
        this.ts = ts;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}
