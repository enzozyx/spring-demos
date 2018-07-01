package com.enzo.demo.common.entity.base;/**
 * Created by LENOVO on 2018/5/22.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;

/**
 * @author zhangyx
 * @desccription 基础bean
 * @date 2018-05-2018/5/22-11:31
 */
public class BaseBean<P> {

    @JsonProperty("id")
    private P id;
    @JsonProperty("del_flag")
    private short delFlag;
    @JsonProperty("created")
    private Date created;
    @JsonProperty("create_by")
    private P createBy;
    @JsonProperty("updated")
    private Date updated;
    @JsonProperty("update_by")
    private P updateBy;

    public P getId() {
        return id;
    }

    public void setId(P id) {
        this.id = id;
    }

    public short getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(short delFlag) {
        this.delFlag = delFlag;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public P getCreateBy() {
        return createBy;
    }

    public void setCreateBy(P createBy) {
        this.createBy = createBy;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }

    public P getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(P updateBy) {
        this.updateBy = updateBy;
    }

    @Override
    public String toString() {
        return "BaseBean{" +
                "id=" + id +
                ", delFlag=" + delFlag +
                ", created=" + created +
                ", createBy=" + createBy +
                ", updated=" + updated +
                ", updateBy=" + updateBy +
                '}';
    }
}
