package com.enzo.demo.common.notes.dao;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.common.notes.clause.NoteClause;
import com.enzo.demo.common.notes.entity.Note;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-14:30
 */
@Repository
public interface NotesDao {

    /**
    * @author zhangyx
    * @description 查询用户笔记信息
    * @date 2018/5/28 14:32
    * @todo
    * @param clause {userId} 用户ID
    * @return
    * @exception
    */
    List<Note> selectUserNotes(NoteClause clause);
}
