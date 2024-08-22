package tests.day12_webTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C01_KlasikHtmlKodlariylaWebTables extends TestBase {

    @Test
    public void test01() {

        // 1. "https://testotomasyonu.com/webtables" adresine gidin
        driver.get("https://testotomasyonu.com/webtables");

        // 2. Web table tüm body'sini yazdırın
        WebElement tumBodyElementi = driver.findElement(By.tagName("tbody"));
        System.out.println(tumBodyElementi.getText());

        // 3. Web tablosunda "Comfortable Gaming Chair" bulunduğunu test edin
        String expectedTabloIcerik = "Comfortable Gaming Chair";
        String actualTumBody = tumBodyElementi.getText();
        Assert.assertTrue(actualTumBody.contains(expectedTabloIcerik));

        // 4. Web table body'sindeki satır sayısının 5 olduğunu test edin
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody/tr"));

        int expectedSatirSayisi = 5;
        int actualSatirSayisi = satirlarListesi.size();
        Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        // 5. Tüm satırları yazdırın
        System.out.println("======== Satirlar Listesi yazdiralim =========");
        List<String> satirYazilariList = ReusableMethods.stringListeCevir(satirlarListesi);
        System.out.println(satirYazilariList);

        // 6. Web table'daki sütun sayısının 4 olduğunu test edin
        List<WebElement> ucuncuSatirDatalarList = driver.findElements(By.xpath("//tbody/tr[3]/td"));

        int expectedSutunSayisi = 4;
        int actualSutunSayisi = ucuncuSatirDatalarList.size();
        Assert.assertEquals(expectedSatirSayisi, actualSatirSayisi);

        // 7. 3. sütunu yazdırın
        List<WebElement> ucuncuSutunElementleriList = driver.findElements(By.xpath("//tbody/tr/td[3]"));
        System.out.println(ReusableMethods.stringListeCevir(ucuncuSutunElementleriList));

        ReusableMethods.bekle(2);

        // 8. Tablodaki başlıkları yazdırın
        WebElement baslikElementi = driver.findElement(By.tagName("thead"));
        System.out.println("Basliklar : " + baslikElementi.getText());

        // 9. Satır ve sütunu parametre olarak alıp, hücredeki bilgiyi döndüren bir method oluşturun


        // 10. 4.satırdaki category değerinin "Furniture" olduğunu test edin
        ReusableMethods.bekle(2);

    }

    public String dataDondur(int satirNo, int sutunNo) {

        //     //tbody/tr[4]/td[1]
        String dinamikXpath = "//tbody/tr" + satirNo + "]/td[" + sutunNo + "]";

        WebElement istenenHucreElementi = driver.findElement(By.xpath(dinamikXpath));

        return istenenHucreElementi.getText();
    }
}
