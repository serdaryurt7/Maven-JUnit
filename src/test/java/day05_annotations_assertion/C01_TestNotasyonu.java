package day05_annotations_assertion;

import org.junit.Ignore;
import org.junit.Test;

public class C01_TestNotasyonu {
    /*
        @Test notasyonu sıradan bir method'u
        bağımsız olarak çalıştırılabilen bir test method'una dönüştürür

        bir class'da birden fazla test method'u varsa,
        istersek her bir method'u tek başına
        istersek de class level'dan çalıştırıp toplu olarak çalıştırabiliriz

        JUnit'de test method'ları toplu çalıştırıldığında
        hangi sıralama ile çalışacağını BILEMEYIZ ve KONTROL EDEMEYIZ

        Eğer çalışmasını istemediğiniz bir test method'u varsa
        @Ingnore notasyonu kullanabiliriz
     */

    @Test
    public void testOtomasyonuTest() {
        System.out.println("testOtomasyonu testi calisti");

    }

    @Test @Ignore
    public void wisequarterTest() {
        System.out.println("wisequarter testi calisti");
    }

    @Test
    public void youtubeTest() {
        System.out.println("youtube testi calisti");
    }
}
