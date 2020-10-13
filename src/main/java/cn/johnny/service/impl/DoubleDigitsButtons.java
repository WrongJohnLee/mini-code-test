package cn.johnny.service.impl;

import cn.johnny.enums.ErrorCodeEnum;
import cn.johnny.exception.InputException;
import cn.johnny.service.AbstractDigitsButtons;
import cn.johnny.utils.ValidateUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * support double digits to output letters
 *
 * @author by johnny
 * @since 2020-10-12 18:32:11
 */
public class DoubleDigitsButtons extends AbstractDigitsButtons {

    @Override
    protected List<Integer> validateAndTransform(List<String> input)  throws InputException {
        final ErrorCodeEnum errorCodeEnum = ValidateUtils.validate(input, 2);
        if (errorCodeEnum != null) {
            throw errorCodeEnum.newInputException();
        }
        return input.stream()
                .flatMap(d -> Arrays.stream(d.split("")))
                .map(Integer::valueOf)
                .filter(dg -> dg != 0 && dg != 1)
                .collect(Collectors.toList());
    }

    @Override
    protected List<String> doGetLetters(List<Integer> input) {
        List<String> output = new ArrayList<>();
        recursiveCombination(output, "", input, new AtomicInteger(0));
        return output;
    }

    /**
     * recursive combination to output by digits
     *
     * @param output      output collection
     * @param combination combination string
     * @param digits      digits of input
     * @param index       recursive index
     */
    private void recursiveCombination(List<String> output, String combination, List<Integer> digits, AtomicInteger index) {
        if (index.get() == digits.size()) {
            output.add(combination);
        } else {
            int currentIndex = digits.get(index.get());
            List<String> letters = DIGITS_MAP.get(currentIndex);
            index.incrementAndGet();
            for (String letter : letters) {
                recursiveCombination(output, combination + letter, digits, index);
            }
            index.decrementAndGet();
        }
    }
}
