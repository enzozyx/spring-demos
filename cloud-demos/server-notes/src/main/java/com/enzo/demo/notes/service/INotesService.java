package com.enzo.demo.notes.service;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.notes.entity.Note;

import java.util.List;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-14:20
 */
public interface INotesService {
    /**
    * @author zhangyx
    * @description 查询用户所有笔记
    * @date 2018/5/28 14:21
    * @todo
    * @param userId 用户ID
    * @return [ {title, 忽略content(太大)}]
    * @exception
    */
    public List<Note> queryUserNotes(Integer userId);
}
