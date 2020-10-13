package cn.johnny.service.impl;

import cn.johnny.enums.ErrorCodeEnum;
import cn.johnny.exception.InputException;
import cn.johnny.service.AbstractDigitsButtons;
import cn.johnny.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * support units digits to output letters
 *
 * @author by johnny
 * @since 2020-10-12 18:32:11
 */
public class UnitsDigitsButtons extends AbstractDigitsButtons {

    @Override
    protected List<Integer> validateAndTransform(List<String> input) throws InputException {
        final ErrorCodeEnum errorCodeEnum = ValidateUtils.validate(input, 1);
        if (errorCodeEnum != null) {
            throw errorCodeEnum.newInputException();
        }
        return input.stream()
                .map(Integer::valueOf)
                .collect(Collectors.toList());
    }

    @Override
    protected List<String> doGetLetters(List<Integer> input) {
        List<String> output = new ArrayList<>();
        for (int i = 0; i < input.size(); i++) {
            Integer digit = input.get(i);
            List<String> letters = DIGITS_MAP.get(digit);
            List<String> tmp = new ArrayList<>();
            if (i == 0) {
                output.addAll(letters);
            } else {
                for (String beforeCmb : output) {
                    for (String letter : letters) {
                        String afterCmb = beforeCmb + "" + letter;
                        tmp.add(afterCmb);
                    }
                }
                output = tmp;
            }
        }
        return output;
    }
}
