package cn.johnny;

import com.sun.istack.internal.NotNull;

import java.util.*;

/**
 * digitsButtons basic class
 *
 * @author by johnny
 * @since 2020/10/12 16:21
 */
public abstract class AbstractDigitsButtons {
    /**
     * digits mapping letters
     **/
    static final Map<Integer, List<String>> DIGITS_MAP = new LinkedHashMap<Integer, List<String>>();

    static {
        DIGITS_MAP.put(0, Collections.singletonList(""));
        DIGITS_MAP.put(1, Collections.singletonList(""));
        DIGITS_MAP.put(2, Arrays.asList("A", "B", "C"));
        DIGITS_MAP.put(3, Arrays.asList("D", "E", "F"));
        DIGITS_MAP.put(4, Arrays.asList("G", "H", "I"));
        DIGITS_MAP.put(5, Arrays.asList("J", "K", "L"));
        DIGITS_MAP.put(6, Arrays.asList("M", "N", "O"));
        DIGITS_MAP.put(7, Arrays.asList("P", "Q", "R", "S"));
        DIGITS_MAP.put(8, Arrays.asList("T", "U", "V"));
        DIGITS_MAP.put(9, Arrays.asList("W", "X", "Y", "Z"));
    }

    /**
     * validate input
     *
     * @param input digits
     * @return error message
     */
    abstract String validate(List<Integer> input);

    /**
     * get combination letter
     *
     * @param input digits
     * @return combination letter
     */
    abstract List<String> doGetLetters(List<Integer> input);

    /**
     * input digits to output combination letter
     *
     * @param input digits
     * @return combination letter
     */
    public List<String> click(@NotNull List<Integer> input) throws DigitsException {
        final String errorMsg = validate(input);
        if (errorMsg != null) {
            throw new DigitsException("input not validate! error message is " + errorMsg);
        }
        return doGetLetters(input);
    }
}
