package org.junit;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HesapMakinesiTest {

    @Test
    @DisplayName("ebik gabık sayıları toplar")// @DisplayName-> kullanıcı veye yoneticinin bilgilendirlmesi içintest'e etiket create
                                             // eder ve console print eder
    void topla() {

        assertEquals(3, C01_HesapMakinesi.topla(1,2));//passed
       //assertEquals(5,HesapMakinesi.topla(1,2));//failed
    }

    @Test
    @DisplayName("ebik gabık sayıları carpar")
    void carp() {

        assertAll(()->assertEquals(2.6, C01_HesapMakinesi.carp(2,1.3)),
                ()->assertEquals(4.8, C01_HesapMakinesi.carp(2,2.4)),
                ()->assertEquals(-2.7, C01_HesapMakinesi.carp(-3,0.9)),
                ()->assertEquals(-18, C01_HesapMakinesi.carp(3,-6))

                );

       //assertEquals(2.6,HesapMakinesi.carp(2,1.3));
       //assertEquals(4.8,HesapMakinesi.carp(2,2.4));
       //assertEquals(-2.7,HesapMakinesi.carp(-3,0.9));
       //assertEquals(-18,HesapMakinesi.carp(3,-6));
    }
}