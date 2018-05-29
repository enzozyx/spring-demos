package com.enzo.demo.enums;/**
 * Created by LENOVO on 2018/5/29.
 */

/**
 * @author zhangyx
 * @desccription
 * @date 2018-05-2018/5/29-9:17
 */
public enum CodeAndMessageEnum {
    SUCCESS(0, "SUCCESS"),
    UNKNOW(-1, "UNKNOW");

    private short code;

    private String message;

    CodeAndMessageEnum(int code, String message) {
        this.code = (short) code;
        this.message = message;
    }

    public short getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }

    public static CodeAndMessageEnum getCodeAndMessage(int majorCode, int minorCode) {
        short code = (short) (majorCode + minorCode);
        for(CodeAndMessageEnum e: CodeAndMessageEnum.values()){
            if(e.getCode() == code){
                return e;
            }
        }
        return UNKNOW;
    }
}
