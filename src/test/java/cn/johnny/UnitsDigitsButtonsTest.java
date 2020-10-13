package cn.johnny;

import cn.johnny.exception.InputException;
import cn.johnny.service.AbstractDigitsButtons;
import cn.johnny.service.impl.UnitsDigitsButtons;
import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static cn.johnny.enums.ErrorCodeEnum.*;

/**
 * unit test for units digits input
 */
public class UnitsDigitsButtonsTest {
    private AbstractDigitsButtons digitsButtons;

    @Before
    public void init() {
        digitsButtons = new UnitsDigitsButtons();
    }

    /**
     * right test
     * @throws InputException no bug can't throw
     */
    @org.junit.Test
    public void click1() throws InputException {
        List<String> output = digitsButtons.click(Arrays.asList("0", "3", "9"));
        Assert.assertEquals(String.valueOf(output), "[DW, DX, DY, DZ, EW, EX, EY, EZ, FW, FX, FY, FZ]");
        List<String> output1 = digitsButtons.click(Arrays.asList("2", "3"));
        Assert.assertEquals(String.valueOf(output1), "[AD, AE, AF, BD, BE, BF, CD, CE, CF]");
        List<String> output2 = digitsButtons.click(Arrays.asList("0", "1", "0"));
        Assert.assertEquals(String.valueOf(output2), "[]");
    }

    /**
     * wrong test
     */
    @org.junit.Test
    public void click2() {
        List<String> output = null;
        try {
            output = digitsButtons.click(null);
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), CAN_NOT_NULL.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList("xx", "1sda12123"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), ILLEGAL_CHARACTER.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList(null, "3"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), CONTAINS_NULL_INPUT.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList("-1", "3"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), ILLEGAL_CHARACTER.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList("123132123132123", "300000000"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), NOT_IN_RANGE.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList("1", "10"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), NOT_IN_RANGE.getErrorMsg());
        }
    }
}