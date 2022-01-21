package org.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class J01_Assertions {

    @Test
    @DisplayName("ToAssert Testi")
    void testToAssert() {
        int actual = "zekeriya".length();
        int beklenen = 8;
        // assertEquals(8,actual);//inline style : her zaman kullanılmaz tavsiye edilmez
        //assertEquals(beklenen,actual);
        // assertEquals(actual,beklenen);//expected ve actual değer yer değiştirebilir.
        assertEquals(beklenen, actual, "beklenen ve actual değer eşit değil");//message hata durumunda (test failed) print edilir....

        //1  assertEquals--> pozitif test :expected ve actual durmlarının eş,t olamsını test eder eşit olası halinde test passed
        //  assertEquals(4, "islam".length(), "inline style tavsiye edilmez cıssss.");

        //2  assertNotEquals--> negatif test :expected ve actual durmlarının eşit OLMAMASINI test eder eşit olmaması halinde test passed
        assertNotEquals(9, actual);

        //3  assertTrue--> pozitif test :olustrulan sart(blooen) true ise  test passed
        assertTrue(beklenen == actual);//passed
        beklenen = 7;
        // assertTrue(beklenen==actual);//failed --> 7!=8

        //4  assertFalse--> negatif test :olustrulan sart(blooen) false ise  test passed
        assertFalse(beklenen == actual);
    }

    @Test
    @DisplayName("ConvertUpper Testi")
    void testConvertUpper() {

        String beklenen = "ABDULLAH";
        String olusan = "abdullah".toUpperCase();

        assertEquals(beklenen, olusan);//test dataları eşitse passed
        beklenen = "ABDULLAh";
        //  assertTrue(beklenen.equals(olusan));//failed
        assertFalse(beklenen.equals(olusan));//passed

        olusan = null;
        assertNull(olusan, "olusan değer null değil");//passed
        //assertNotNull(olusan);//failed
        olusan = "kursat";
        assertNotNull(olusan);//passed

    }

    @Test
    @DisplayName("ToContain test")
    void testToContain() {

        boolean olusan = "mustafa".contains("hi");//false
        boolean beklenen = false;
        assertEquals(olusan, beklenen, "strin degeri barındırmaz");
    }

    @Test
    @DisplayName("arrays test")
    void testArray() {
        String str = "javacanlara selam olsun ayagınza das degmesin";
        String olusan[] = str.split(" ");
        String beklenen[] = {"javacanlara", "selam", "olsun", "ayagınza", "das", "degmesin"};
        assertArrayEquals(beklenen, olusan, "agam arraylerin farklı");//passed
        assertArrayEquals(beklenen, olusan, "agam arraylerin farklı");//failed-->array contents differ at index [1], expected: <sela> but was: <selam>

    }

}
