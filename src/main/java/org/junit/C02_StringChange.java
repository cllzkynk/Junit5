package org.junit;
public class C02_StringChange {
    /*
    Verilen bir String'deki ilk iki harf içinde A var ise bunları silen method create ediniz.
    AACD->CD
    ABC ->BC
    AA  ->""
    A   ->""
    B   ->B
     */
    public String ilkIkıASil(String str) {
        if (str.length() <= 2) {
            return str.replaceAll("A", "");
        }
        String ilkIkiKarakter=str.substring(0,2);
        String ilkIkiKaraktersonrasi=str.substring(2);
        return ilkIkiKarakter.replaceAll("A","")+ilkIkiKaraktersonrasi;
    }
}
