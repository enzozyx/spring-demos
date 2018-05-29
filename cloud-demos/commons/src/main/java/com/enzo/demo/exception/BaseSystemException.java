package com.enzo.demo.exception;/**
 * Created by LENOVO on 2018/5/29.
 */

import com.enzo.demo.enums.CodeAndMessageEnum;
import com.sun.org.apache.bcel.internal.classfile.Code;

/**
 * @author zhangyx
 * @desccription 基础异常
 * @date 2018-05-2018/5/29-9:35
 */
public class BaseSystemException extends Throwable{

    private CodeAndMessageEnum codeAndMessage;

    private int majorCode;

    private int minorCode;

    public BaseSystemException(CodeAndMessageEnum codeAndMessage) {
        this.codeAndMessage = codeAndMessage;
    }

    public BaseSystemException(String message, int majorCode, int minorCode) {
        super(message);
        this.majorCode = majorCode;
        this.minorCode = minorCode;
        this.codeAndMessage = CodeAndMessageEnum.getCodeAndMessage(majorCode, minorCode);
    }

    public CodeAndMessageEnum getCodeAndMessage() {
        return codeAndMessage;
    }
}
