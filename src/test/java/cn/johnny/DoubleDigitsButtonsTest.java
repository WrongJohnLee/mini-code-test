package cn.johnny;

import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

public class DoubleDigitsButtonsTest {

    private AbstractDigitsButtons digitsButtons;

    @Before
    public void init() {
        digitsButtons = new DoubleDigitsButtons();
    }

    @org.junit.Test
    public void click1() throws DigitsException {
        List<String> output1 = digitsButtons.click(Arrays.asList(21, 33));
        Assert.assertEquals(String.valueOf(output1), "[ADD, ADE, ADF, AED, AEE, AEF, AFD, AFE, AFF, BDD, BDE, BDF, BED, BEE, BEF, BFD, BFE, BFF, CDD, CDE, CDF, CED, CEE, CEF, CFD, CFE, CFF]");
        List<String> output2 = digitsButtons.click(Arrays.asList(10, 10));
        Assert.assertEquals(String.valueOf(output2), "[]");
        List<String> output3 = digitsButtons.click(Arrays.asList(22, 99));
        Assert.assertEquals(String.valueOf(output3), "[AAWW, AAWX, AAWY, AAWZ, AAXW, AAXX, AAXY, AAXZ, AAYW, AAYX, AAYY, AAYZ, AAZW, AAZX, AAZY, AAZZ, ABWW, ABWX, ABWY, ABWZ, ABXW, ABXX, ABXY, ABXZ, ABYW, ABYX, ABYY, ABYZ, ABZW, ABZX, ABZY, ABZZ, ACWW, ACWX, ACWY, ACWZ, ACXW, ACXX, ACXY, ACXZ, ACYW, ACYX, ACYY, ACYZ, ACZW, ACZX, ACZY, ACZZ, BAWW, BAWX, BAWY, BAWZ, BAXW, BAXX, BAXY, BAXZ, BAYW, BAYX, BAYY, BAYZ, BAZW, BAZX, BAZY, BAZZ, BBWW, BBWX, BBWY, BBWZ, BBXW, BBXX, BBXY, BBXZ, BBYW, BBYX, BBYY, BBYZ, BBZW, BBZX, BBZY, BBZZ, BCWW, BCWX, BCWY, BCWZ, BCXW, BCXX, BCXY, BCXZ, BCYW, BCYX, BCYY, BCYZ, BCZW, BCZX, BCZY, BCZZ, CAWW, CAWX, CAWY, CAWZ, CAXW, CAXX, CAXY, CAXZ, CAYW, CAYX, CAYY, CAYZ, CAZW, CAZX, CAZY, CAZZ, CBWW, CBWX, CBWY, CBWZ, CBXW, CBXX, CBXY, CBXZ, CBYW, CBYX, CBYY, CBYZ, CBZW, CBZX, CBZY, CBZZ, CCWW, CCWX, CCWY, CCWZ, CCXW, CCXX, CCXY, CCXZ, CCYW, CCYX, CCYY, CCYZ, CCZW, CCZX, CCZY, CCZZ]");
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
            output = digitsButtons.click(Arrays.asList(1, 100));
        } catch (DigitsException e) {
            Assert.assertEquals(e.getMessage(), "input not validate! error message is input[1] not in range");
        }
    }
}