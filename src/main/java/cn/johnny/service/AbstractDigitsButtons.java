package cn.johnny.service;

import cn.johnny.exception.InputException;
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
    protected static final Map<Integer, List<String>> DIGITS_MAP = new LinkedHashMap<Integer, List<String>>();

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
     * @param input user's input
     * @return transform input
     */
    protected abstract List<Integer> validateAndTransform(List<String> input) throws InputException;

    /**
     * get combination letter
     *
     * @param input digits
     * @return combination letter
     */
    protected abstract List<String> doGetLetters(List<Integer> input);

    /**
     * input digits to output combination letter
     *
     * @param input digits
     * @return combination letter
     */
    public List<String> click(@NotNull List<String> input) throws InputException {
        List<Integer> digits = validateAndTransform(input);
        return doGetLetters(digits);
    }
}
