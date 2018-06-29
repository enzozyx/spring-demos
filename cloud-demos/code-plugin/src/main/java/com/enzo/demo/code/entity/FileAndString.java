package com.enzo.demo.code.entity;/**
 * Created by LENOVO on 2018/6/29.
 */

import java.io.File;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-06-2018/6/29-16:40
 */
public class FileAndString {

    private File file;

    private String string;

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public FileAndString(File file, String string) {
        this.file = file;
        this.string = string;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
