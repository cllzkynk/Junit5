package org.junit;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
public class J07_TestingGroup {
    //Task : 0 içermeyen int degerler için multipylExact() methodunu test ediniz.
    //Task : 0 içeren int degerler için multipylExact() methodunu test ediniz.
    @ParameterizedTest
    @DisplayName("parametreli group dışı carpım  testi ")
    @CsvSource(value = {"12,3,4", "-16,8,-2,", "0,0,-5", "35,7,5"})
    void Carpim(int sonuc, int x, int y) {
        // assertEquals(sonuc,(x*y));
        assertEquals(sonuc, Math.multiplyExact(x, y));
    }
    @Nested//parent  test gibi kapsamındaki Class'ındakşi tum testleri aynı anda run eder
    // // @Nested --> parent'i oldg class level'da calışır
    @DisplayName("group test run edilir")
    class GroupTest {
        @ParameterizedTest
        @DisplayName("parametreli carpım  testi ")
        @CsvSource(value = {"0,0,4", "0,8,0,", "0,0,-5", "0,0,0"})
        void sifirIcerenCarpim(int sonuc, int x, int y) {
            // assertEquals(sonuc,(x*y));
            assertEquals(sonuc, Math.multiplyExact(x, y));
        }
        @ParameterizedTest
        @DisplayName("parametreli toplam test ")
        @CsvSource(value = {"4,0,4", "8,8,0,", "-5,0,-5", "0,0,0"})
        void sifirIcerenToplam(int sonuc, int x, int y) {
            // assertEquals(sonuc,(x+y));
            assertEquals(sonuc, Math.addExact(x, y));
        }
        @ParameterizedTest
        @DisplayName("parametreli bolme test ")
        @CsvSource(value = {"0,0,4", "0,8,0,", "0,0,-5", "0,1,0"})
        void sifirIcerenBolme(int sonuc, int x, int y) {
            if (y == 0) {
                assertThrows(ArithmeticException.class, () -> bol(x, y));
            } else {
                assertEquals(sonuc, bol(x, y));
            }
        }
        int bol(int a, int b) {
            return a / b;
        }
    }
}
