package cn.johnny.utils;

import cn.johnny.enums.ErrorCodeEnum;

import java.util.List;

import static cn.johnny.enums.ErrorCodeEnum.*;

/**
 * commons method for validate
 *
 * @author by johnny
 * @since 2020/10/13 14:41
 */
public class ValidateUtils {

    /**
     * validate input
     * @param input user input
     * @param digit 1:0-10 unit digit, 2: 0-99 double digit...
     * @return ErrorCodeEnum contains error message and code
     */
    public static ErrorCodeEnum validate(List<String> input, int digit) {
        if (input == null || input.size() == 0) {
            return CAN_NOT_NULL;
        }
        for (final String el : input) {
            if (el == null) {
                return CONTAINS_NULL_INPUT;
            }
            if (!el.matches("^[0-9]*$")) {
                return ILLEGAL_CHARACTER;
            }
            if (!el.matches("^\\d{1," + digit + "}$")) {
                return NOT_IN_RANGE;
            }
        }
        return null;
    }
}
