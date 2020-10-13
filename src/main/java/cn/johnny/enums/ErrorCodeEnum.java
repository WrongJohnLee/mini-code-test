package cn.johnny.enums;

import cn.johnny.exception.InputException;

/**
 * mark for input not validate
 * @author by johnny
 * @since 2020/10/13 14:24
 */
public enum ErrorCodeEnum {

    CAN_NOT_NULL(10001, "input can't be null!"),
    CONTAINS_NULL_INPUT(10002, "input contains null!"),
    NOT_IN_RANGE(10003, "input not in range!"),
    ILLEGAL_CHARACTER(10004, "input contains illegal character!");

    /** mark code of error **/
    private Integer errorCode;
    /** mark message of error **/
    private String errorMsg;

    ErrorCodeEnum(Integer errorCode, String errorMsg) {
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

    public InputException newInputException() {
        return new InputException(errorMsg);
    }

    public Integer getErrorCode() {
        return errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }
}
