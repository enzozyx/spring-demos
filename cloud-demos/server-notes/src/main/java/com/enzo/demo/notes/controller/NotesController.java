package com.enzo.demo.notes.controller;/**
 * Created by LENOVO on 2018/5/28.
 */

import com.enzo.demo.entity.sys.User;
import com.enzo.demo.notes.entity.Note;
import com.enzo.demo.notes.providers.IUserServiceProvider;
import com.enzo.demo.notes.service.INotesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * @author zhangyx
 * @desccription 笔记
 * @date 2018-05-2018/5/28-14:15
 */
@RestController
public class NotesController {

    @Autowired
    private INotesService service;
    @Autowired
    private IUserServiceProvider userProvider;
    @RequestMapping(value = "/notes/{name}", method = RequestMethod.GET)
    public List<Note> test(@PathVariable("name") String name){
        User user = userProvider.queryUser(name);
        return this.service.queryUserNotes((Integer) user.getId());
    }
}
