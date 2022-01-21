package org.junit;

import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class J02_BeforeAfterEachAll {
    /* =========================================== @BeforeEach - @AfterEach ============================================

       A-) @BeforeEach anatosyonu kullanılan bir method, her test methodu çalışmadan önce çalıştırılır.
           Bu özelliği sayesinde test verilerinin ayarlanması (başlatılması) için kullanılabilir.
           Araç --> her vites'te debriyaja basma   Namaz --> her rekatın Fatiha'sı

       B-) @AfterEach anatosyonu kullanılan bir method, her test metodu bittikten sonra çalıştırılır.
           Bu özelliği sayesinde test verilerinin temizlenmesi için kullanılabilir.
           Araç --> her vites'te debriyajdan ayagı cekme   Namaz --> her rekatın ayaga kalkma'sı

       C-) JUnit4 de bu anatosyonlar yerine @Before ve @After kullanıyordu.

       D-) AHAN DA TRİCKKK:  @AfterEach veya  @BeforeEach anotasyonunda yazım sırası önemli değildir. Hangisi önce önce yazılırsa yazılsın JAVA
            önce @BeforeEach  sonra @AfterEach compile eder.

            ========================================== @BeforeAll - @AfterAll ===============================================
         A-) @BeforeALl tüm test methodlarından önce BİR KERE çalışan bir method oluşturmak için kullanılır.
             Dolayısıyla veritabanı içeren bir test işleminde ilk olarak veritabanına bağlanmak gerekeceğinden @BeforeAll
             anatosyonu ile bir method tanımlanarak ilk olarak veritabanına bağlanma prosedürü işletilebilir.
              Araç --> kontagı acma   Namaz --> Namazın tekbiri...

         B-) @AfterAll ile tüm test metotlari bittikten sonra BİR KERE çalışan bir metot oluşturulabilir.
             Bu özelliği sayesinde testler bittikten sonra veritabani oturumu kapatılabilir.
             Araç --> kontagı kapatma   Namaz --> Namazın selamı...

            AHAN DA TRİCKKK: @BeforeAll ve @AfterAll anotasyonlarının kullanıldığı metotlar static olmalıdır.
            Not2: JUnit4 de @BeforeClass ve  @AfterClass metotları kulanılmaktadır.

            Kıng of TRICKK : @Before ve @After anotasyonları ayrı bir test gibi tek başına  çalışmaz test2lerin çalışma
                            hiyerraşisini organize eder. Anotasyonlarının yazım sırası run sırasını etkilemez anotasyonlar kendi hiyerarşisine göre run olur

         */
    @AfterEach
    void clean(TestInfo info) {
        str = "";
        System.out.println(info.getDisplayName() + "@AfterEach--> clean methodu run edilidi(HER REKAT için KALKILDI)");
        System.out.println("   ***   ");

    }

    @BeforeEach
    void setup(TestInfo info) {

        str = "JavaCAN'lara selam olsun";
        System.out.println(info.getDisplayName() + "@BeforeEach--> setup methodu run edilidi(HER REKATIN FATİHASI OKUNDU)");
        System.out.println("   ***   ");
    }



    String str = "";//Class level global veriable

    @AfterAll
    static void veriTabanıBaglantıKapatma() {
        System.out.println("@AfterAll--> veritabanı baglantısı kapat (KONTAK KAPATILDI)");
        System.out.println("   ***   ");

    }

    @BeforeAll
    static void veriTabanıBaglantıAcma() {
        System.out.println("@BeforeAll--> veritabanı baglantısı kuruldu (KONTAK AÇILDI)");
        System.out.println("   ***   ");

    }


    @Test
    @DisplayName("lenght method testi")
    void testStringLenght() {

        int olusan = str.length();
        int beklenen = 24;
        assertEquals(beklenen, olusan, "datalar farklı");
        System.out.println("TEST-1 -->lenght method test edildi");
    }

    @Test
    @DisplayName("arrays test")
    void testArray() {
        String str = "javacanlara selam olsun ayagınza das degmesin";
        String olusan[] = str.split(" ");
        String beklenen[] = {"javacanlara", "selam", "olsun", "ayagınza", "das", "degmesin"};
        assertArrayEquals(beklenen, olusan, "agam arraylerin farklı");//passed
        System.out.println("TEST-2 -->arrays test edildi");

    }
}
