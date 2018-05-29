package com.enzo.demo.notes.entity;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.entity.base.BaseBean;
import com.enzo.demo.entity.sys.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhangyx
 * @desccription 笔记
 * @date 2018-05-2018/5/28-14:16
 */
@JsonIgnoreProperties({"del_flag", "created", "create_by", "updated", "update_by"})
public class Note<P extends Integer> extends BaseBean<P>{

    @JsonProperty("title")
    private String title;

    @JsonProperty("content")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String content;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", base={" + super.toString() +
                '}';
    }
}
