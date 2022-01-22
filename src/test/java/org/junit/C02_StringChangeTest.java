package org.junit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class C02_StringChangeTest {
    C02_StringChange strChange  ;

    @BeforeEach
    void setup(){
        strChange=new C02_StringChange();
        System.out.println("test verisi girisi yapildi");
    }
    @AfterEach
    void tearDown(){
        strChange=null ;
        System.out.println("test verisi silindi");
    }
  @ParameterizedTest
    @CsvSource(value = {"BC,ABC","'',A","'',AA","B,B","BCDE,BCDE"})
    void ilkIkiAsil(String kirpilmis , String girdi){
assertEquals(kirpilmis,strChange.ilkIkıASil(girdi));
      System.out.println("ilk iki a verisi silindi");
    }


}
