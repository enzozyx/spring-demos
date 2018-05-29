package com.enzo.demo.notes.clause;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-14:31
 */
public class NoteClause {

    @JsonProperty("user_id")
    private Integer userId;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
