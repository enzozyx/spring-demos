package com.enzo.demo.notes.service.impl;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.entity.sys.User;
import com.enzo.demo.notes.clause.NoteClause;
import com.enzo.demo.notes.dao.NotesDao;
import com.enzo.demo.notes.entity.Note;
import com.enzo.demo.notes.providers.IUserServiceProvider;
import com.enzo.demo.notes.service.INotesService;
import org.hibernate.validator.internal.util.logging.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/28-14:29
 */
@Service
public class NotesService implements INotesService{

    private static Logger log = org.slf4j.LoggerFactory.getLogger(NotesService.class);

    @Autowired
    private NotesDao dao;
    @Autowired
    private IUserServiceProvider userService;


    /**
     * 查询用户笔记
     * @param userId 用户ID
     * @return
     */
    @Override
    public List<Note> queryUserNotes(Integer userId) {
        NoteClause clause = new NoteClause();
        clause.setUserId(userId);
        return this.dao.selectUserNotes(clause);
    }
}
