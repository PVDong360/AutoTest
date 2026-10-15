package Part1;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

public class TestFunction2 {


    // Bai 1 
    @Test
    public void testSoNgTo() {

        assertTrue(Function.SoNgTo(2));
        assertTrue(Function.SoNgTo(7));

        assertFalse(Function.SoNgTo(10));
        assertFalse(Function.SoNgTo(1));
        assertFalse(Function.SoNgTo(0));
    }

    @Test
    public void testSoNgTo49() {

        assertFalse(Function.SoNgTo(49));
    }

    @Test
    public void testLKSoBeHon() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;

        System.setOut(new PrintStream(output));

        Function.LKSoBehonn(10);

        System.setOut(oldOut);

        String result = output.toString();

        assertEquals("2 3 5 7 ", result);
    }



    // Bai 2
    @Test
    public void testLKSoNgto1st() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;

        System.setOut(new PrintStream(output));

        Function.LKSoNgto1st(5);

        System.setOut(oldOut);

        String result = output.toString();

        assertEquals("2 3 5 7 11 ", result);
    }



    // Bai 3
    @Test
    public void testLKSoNgTo5So() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;

        System.setOut(new PrintStream(output));

        Function.LKSoNgTo5So(0);

        System.setOut(oldOut);

        String result = output.toString();

        assertTrue(result.contains("10007"));
        assertFalse(result.contains("10000"));
    }



    // Bai 4
    @Test
    public void testSoNgThanhSoNgTo() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;

        System.setOut(new PrintStream(output));

        Function.SoNgThanhSoNgTo(60);

        System.setOut(oldOut);

        String result = output.toString();

        assertEquals("2 2 3 5 ", result);
    }

    @Test
    public void testSoNgThanhSoNgTo12() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;

        System.setOut(new PrintStream(output));

        Function.SoNgThanhSoNgTo(12);

        System.setOut(oldOut);

        String result = output.toString();

        assertEquals("2 2 3 ", result);
    }



    // Bai 5
    @Test
    public void testTongCacChuSo() {

        assertEquals(15, Function.TTsoNgTo(12345));

        assertEquals(1, Function.TTsoNgTo(100));

        assertEquals(24, Function.TTsoNgTo(987));

        assertEquals(0, Function.TTsoNgTo(0));
    }



    // Bai 6
    @Test
    public void testSoThuanNghich() {

        assertTrue(
                Function.ktraSoThuanNghich(123321)
        );

        assertTrue(
                Function.ktraSoThuanNghich(100001)
        );

        assertFalse(
                Function.ktraSoThuanNghich(123456)
        );
    }

    @Test
    public void testThuanNghich6So() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;

        System.setOut(new PrintStream(output));

        Function.ThuanNghich6So();

        System.setOut(oldOut);

        String result = output.toString();

        assertTrue(result.contains("100001"));
        assertTrue(result.contains("123321"));
        assertTrue(result.contains("999999"));
    }



    // Bai 7
    @Test
    public void TestFiboBeHonn() {

        ByteArrayOutputStream output = new ByteArrayOutputStream();
        PrintStream oldOut = System.out;

        System.setOut(new PrintStream(output));

        Function.FiboBeHonn(100);

        System.setOut(oldOut);

        String result = output.toString();

        assertEquals(
                "2 3 5 13 89 ",
                result
        );
    }
}