package cn.johnny;

import java.util.ArrayList;
import java.util.List;

/**
 * support units digits to output letters
 *
 * @author by johnny
 * @since 2020-10-12 18:32:11
 */
public class UnitsDigitsButtons extends AbstractDigitsButtons {

    @Override
    String validate(List<Integer> input) {
        if (input == null || input.size() == 0) {
            return "input can't be null";
        }
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == null) {
                return String.format("input[%s] can't be null", i);
            }
            if (input.get(i) < 0 || input.get(i) > 9) {
                return String.format("input[%s] not in range", i);
            }
        }
        return null;
    }

    @Override
    List<String> doGetLetters(List<Integer> input) {
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
