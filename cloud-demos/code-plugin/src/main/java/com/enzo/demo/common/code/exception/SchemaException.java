package com.enzo.demo.common.code.exception;/**
 * Created by LENOVO on 2018/5/29.
 */

import com.enzo.demo.common.enums.CodeAndMessageEnum;
import com.enzo.demo.common.exception.BaseSystemException;

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/29-9:42
 */
public class SchemaException extends BaseSystemException {

    public final static short EXCEPTION_MINOR_CODE_INCORRECT_SCHEMA_NAME = 1;
    public final static String EXCEPTION_MESSAGE_INCORRECT_SCHEMA_NAME = "不正确的schema名称";
    public final static short EXCEPTION_MINOR_CODE_INCORRECT_SCHEMA_NAME_OR_RELATION_NAME = 2;
    public final static String EXCEPTION_MESSAGE_INCORRECT_SCHEMA_NAME_OR_RELATION_NAME = "不正确的schema/table名称";

    public SchemaException(CodeAndMessageEnum codeAndMessage) {
        super(codeAndMessage);
    }

    public SchemaException(String message, int minorCode) {
        super(message, 10000, minorCode);
    }
}
