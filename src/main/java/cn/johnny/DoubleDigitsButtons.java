package cn.johnny;

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
    String validate(List<Integer> input) {
        if (input == null || input.size() == 0) {
            return "input can't be null";
        }
        for (int i = 0; i < input.size(); i++) {
            if (input.get(i) == null) {
                return String.format("input[%s] can't be null", i);
            }
            if (input.get(i) < 0 || input.get(i) > 99) {
                return String.format("input[%s] not in range", i);
            }
        }
        return null;
    }

    @Override
    List<String> doGetLetters(List<Integer> input) {
        List<String> output = new ArrayList<>();
        final List<Integer> transformInput = input.stream()
                .flatMap(d -> Arrays.stream(d.toString().split("")))
                .map(Integer::valueOf)
                .filter(dg -> dg != 0 && dg != 1)
                .collect(Collectors.toList());
        recursiveCombination(output, "", transformInput, new AtomicInteger(0));
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
