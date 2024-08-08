package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C02_SwitchingWindows extends TestBase {
    @Test
    public void yeniWindowTesti() {

        /*
            Bir sayfada test yaparken driver.switchTo().NewWindow(...) kullandığımızda
            yeni window'u driver'a oluşturtduğumuz için, driver otomatik olarak yeni sayfaya geçer

            driver yeni window'a geçtikten sonra, eski window'lardan birine dönmesi istenecekse
            dönülecek window'da iken o sayfanın, windowHandleDegerini alıp kaydetmeliyiz

            driver.switchTo().window(kaydedilenWindowHandleDegeri) ile, o sayfaya dönebiliriz
         */



        // testotomasyonu anasayfa adresine gidin
        driver.get("https://www.testotomasyonu.com/");
        // Sayfa'nın window handle değerini String bir değişkene atayın
        String toWindowHandleDegeri = driver.getWindowHandle();
        // Sayfanın title'nin "Otomasyon" içerdiğini test edin
        String expectedTitleIcerik = "Otomasyon";
        String actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(2);
        // Yeni bir tab oluşturup, açılan tab'da wisequarter.com adresine gidin
        driver.switchTo().newWindow(WindowType.TAB);
        driver.get("https://wisequarter.com");

        // Sayfa title'nin "Wise Quarter" içerdiğini test edin
        expectedTitleIcerik = "Wise Quarter";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        // Yeni bir window oluşturup, açılan sayfada walmart.com adresine gidin

        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.walmart.com");
        ReusableMethods.bekle(2);
        // Sayfa title'nın "Walmart" içerdiğini test edin
        expectedTitleIcerik = "Walmart";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));
        ReusableMethods.bekle(2);
        // İlk açılan sayfaya dönün ve testotomasyonu sayfasına döndüğünüzü test edin

        driver.switchTo().window(toWindowHandleDegeri);
        expectedTitleIcerik = "Otomasyon";
        actualTitle = driver.getTitle();

        Assert.assertTrue(actualTitle.contains(expectedTitleIcerik));

        ReusableMethods.bekle(2);


    }
}
