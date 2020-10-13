package cn.johnny;

import cn.johnny.exception.InputException;
import cn.johnny.service.AbstractDigitsButtons;
import cn.johnny.service.impl.DoubleDigitsButtons;
import org.junit.Assert;
import org.junit.Before;

import java.util.Arrays;
import java.util.List;

import static cn.johnny.enums.ErrorCodeEnum.*;
import static cn.johnny.enums.ErrorCodeEnum.NOT_IN_RANGE;

public class DoubleDigitsButtonsTest {

    private AbstractDigitsButtons digitsButtons;

    @Before
    public void init() {
        digitsButtons = new DoubleDigitsButtons();
    }

    /**
     * right test
     * @throws InputException no bug can't throw
     */
    @org.junit.Test
    public void click1() throws InputException {
        List<String> output1 = digitsButtons.click(Arrays.asList("21", "33"));
        Assert.assertEquals(String.valueOf(output1), "[ADD, ADE, ADF, AED, AEE, AEF, AFD, AFE, AFF, BDD, BDE, BDF, BED, BEE, BEF, BFD, BFE, BFF, CDD, CDE, CDF, CED, CEE, CEF, CFD, CFE, CFF]");
        List<String> output2 = digitsButtons.click(Arrays.asList("10", "10"));
        Assert.assertEquals(String.valueOf(output2), "[]");
        List<String> output3 = digitsButtons.click(Arrays.asList("22", "99"));
        Assert.assertEquals(String.valueOf(output3), "[AAWW, AAWX, AAWY, AAWZ, AAXW, AAXX, AAXY, AAXZ, AAYW, AAYX, AAYY, AAYZ, AAZW, AAZX, AAZY, AAZZ, ABWW, ABWX, ABWY, ABWZ, ABXW, ABXX, ABXY, ABXZ, ABYW, ABYX, ABYY, ABYZ, ABZW, ABZX, ABZY, ABZZ, ACWW, ACWX, ACWY, ACWZ, ACXW, ACXX, ACXY, ACXZ, ACYW, ACYX, ACYY, ACYZ, ACZW, ACZX, ACZY, ACZZ, BAWW, BAWX, BAWY, BAWZ, BAXW, BAXX, BAXY, BAXZ, BAYW, BAYX, BAYY, BAYZ, BAZW, BAZX, BAZY, BAZZ, BBWW, BBWX, BBWY, BBWZ, BBXW, BBXX, BBXY, BBXZ, BBYW, BBYX, BBYY, BBYZ, BBZW, BBZX, BBZY, BBZZ, BCWW, BCWX, BCWY, BCWZ, BCXW, BCXX, BCXY, BCXZ, BCYW, BCYX, BCYY, BCYZ, BCZW, BCZX, BCZY, BCZZ, CAWW, CAWX, CAWY, CAWZ, CAXW, CAXX, CAXY, CAXZ, CAYW, CAYX, CAYY, CAYZ, CAZW, CAZX, CAZY, CAZZ, CBWW, CBWX, CBWY, CBWZ, CBXW, CBXX, CBXY, CBXZ, CBYW, CBYX, CBYY, CBYZ, CBZW, CBZX, CBZY, CBZZ, CCWW, CCWX, CCWY, CCWZ, CCXW, CCXX, CCXY, CCXZ, CCYW, CCYX, CCYY, CCYZ, CCZW, CCZX, CCZY, CCZZ]");
        List<String> output4 = digitsButtons.click(Arrays.asList("8", "9"));
        Assert.assertEquals(String.valueOf(output4), "[TW, TX, TY, TZ, UW, UX, UY, UZ, VW, VX, VY, VZ]");
        List<String> output5 = digitsButtons.click(Arrays.asList("77", "8"));
        Assert.assertEquals(String.valueOf(output5), "[PPT, PPU, PPV, PQT, PQU, PQV, PRT, PRU, PRV, PST, PSU, PSV, QPT, QPU, QPV, QQT, QQU, QQV, QRT, QRU, QRV, QST, QSU, QSV, RPT, RPU, RPV, RQT, RQU, RQV, RRT, RRU, RRV, RST, RSU, RSV, SPT, SPU, SPV, SQT, SQU, SQV, SRT, SRU, SRV, SST, SSU, SSV]");

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
            output = digitsButtons.click(Arrays.asList("-121312", "3"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), ILLEGAL_CHARACTER.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList(null, "3"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), CONTAINS_NULL_INPUT.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList("123132123132123", "300000000"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), NOT_IN_RANGE.getErrorMsg());
        }

        try {
            output = digitsButtons.click(Arrays.asList("100", "10"));
        } catch (InputException e) {
            Assert.assertEquals(e.getMessage(), NOT_IN_RANGE.getErrorMsg());
        }
    }
}