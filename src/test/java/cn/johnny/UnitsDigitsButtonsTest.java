package cn.johnny;

import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

public class UnitsDigitsButtonsTest {
    private AbstractDigitsButtons digitsButtons;

    @Before
    public void init() {
        digitsButtons = new UnitsDigitsButtons();
    }

    @org.junit.Test
    public void click1() throws DigitsException {
        List<String> output = digitsButtons.click(Arrays.asList(0, 3, 9));
        Assert.assertEquals(String.valueOf(output), "[DW, DX, DY, DZ, EW, EX, EY, EZ, FW, FX, FY, FZ]");
        List<String> output1 = digitsButtons.click(Arrays.asList(2, 3));
        Assert.assertEquals(String.valueOf(output1), "[AD, AE, AF, BD, BE, BF, CD, CE, CF]");
    }

    @org.junit.Test
    public void click2() {
        List<String> output = null;
        try {
            output = digitsButtons.click(null);
        } catch (DigitsException e) {
            Assert.assertEquals(e.getMessage(), "input not validate! error message is input can't be null");
        }

        try {
            output = digitsButtons.click(Arrays.asList(null, 3));
        } catch (DigitsException e) {
            Assert.assertEquals(e.getMessage(), "input not validate! error message is input[0] can't be null");
        }

        try {
            output = digitsButtons.click(Arrays.asList(-1, 3));
        } catch (DigitsException e) {
            Assert.assertEquals(e.getMessage(), "input not validate! error message is input[0] not in range");
        }

        try {
            output = digitsButtons.click(Arrays.asList(1, 10));
        } catch (DigitsException e) {
            Assert.assertEquals(e.getMessage(), "input not validate! error message is input[1] not in range");
        }
    }
}