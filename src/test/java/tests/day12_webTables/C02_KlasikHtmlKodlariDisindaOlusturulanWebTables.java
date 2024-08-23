package tests.day12_webTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C02_KlasikHtmlKodlariDisindaOlusturulanWebTables extends TestBase {

    @Test
    public void test01() {
        //    (//*[@role='trow'])/*[@role='tdata']

        // 1. "https://testotomasyonu.com/webtables2" sayfasına gidin
        driver.get("https://testotomasyonu.com/webtables2");
        // 2. Headers da bulunan başlıkları yazdırın
        WebElement baslikSatirElementi = driver.findElement(By.xpath("//*[@role='hrow']"));
        System.out.println(baslikSatirElementi.getText());

        // 3. 3.sutunun başlığını yazdırın
        WebElement ucuncuSutunBasligi = driver.findElement(By.xpath("//*[@role='hrow']/*[@role='hdata'][3]"));
        System.out.println(ucuncuSutunBasligi.getText());

        // 4. Tablodaki tüm dataları yazdırın
        List<WebElement> tabloDataElementleriList = driver.findElements(By.xpath("//*[@role='tdata']"));
        System.out.println(ReusableMethods.stringListeCevir(tabloDataElementleriList));

        // 5. Tabloda kaç tane cell (data) olduğunu yazdırın
        System.out.println("tablodaki cell sayisi : " + tabloDataElementleriList.size());

        // 6. Tablodaki satır sayısını yazdırın
        List<WebElement> satirElementleriList = driver.findElements(By.xpath("//*[@role='trow']"));
        System.out.println("tablodaki satir sayisi : " + satirElementleriList.size());

        // 7. Tablodaki sütun sayısını yazdırın
        List<WebElement> ikinciSatirDataElementleriList = driver.findElements(By.xpath("(//*[@role='trow'])[2]/*[@role='tdata']"));
        System.out.println("Tablodaki sutun sayisi : " + ikinciSatirDataElementleriList.size());

        // 8. Tablodaki 3. kolonu yazdırın
        List<WebElement> ucuncuSutunElementlerList = driver.findElements(By.xpath("(//*[@role='trow'])/*[@role='tdata'][3]"));
        System.out.println(ReusableMethods.stringListeCevir(ucuncuSutunElementlerList));

        // 9. Tabloda "Category" si Furniture olan ürünün fiyatını yazdırın
        //10. Bir method oluşturun, Test sayfasından satır ve sütun verildiğinde datayı yazdırsın

        ReusableMethods.bekle(3);

    }


}
