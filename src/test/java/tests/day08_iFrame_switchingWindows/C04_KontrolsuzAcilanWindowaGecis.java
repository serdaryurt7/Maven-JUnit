package tests.day08_iFrame_switchingWindows;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;
import java.util.Set;

public class C04_KontrolsuzAcilanWindowaGecis extends TestBase {

    @Test
    public void test01() {
        // https://testotomasyonu.com/addremove/ adresine gidin.
        driver.get("https://testotomasyonu.com/addremove/");
        // Sayfadaki textin "Add/Remove Elements" olduğunu doğrulayın.
        WebElement addRemoveElementi = driver.findElement(By.xpath("//*[text()='Add/Remove Elements']"));
        String expectedaddRemoveElement = "Add/Remove Elements";
        String actualaddRemoveElement = addRemoveElementi.getText();
        Assert.assertEquals(expectedaddRemoveElement, actualaddRemoveElement);

        // Sayfa başlığının(title) "Test Otomasyonu" olduğunu doğrulayın.

        String expectedTitle = "Test Otomasyonu";
        String actualTitle = driver.getTitle();

        Assert.assertEquals(expectedTitle, actualTitle);
        String ilkWindowWHD = driver.getWindowHandle();

        // 'Please click for Electronics Products' linkine tıklayın.

        WebElement electronicsProductsLink = driver.findElement(By.xpath("//*[text()='Electronics Products']"));
        electronicsProductsLink.click();

        // kontrolsüz tab açıldığı için, ikinci window'un WHD'ini bulup, o window'a geçmeliyiz

        Set<String> whdSeti = driver.getWindowHandles();

        String ikinciWindowWHD = "";

        for (String eachWhd : whdSeti
        ) {

            if (!eachWhd.equals(ilkWindowWHD)) {

                ikinciWindowWHD = eachWhd;
            }

        }
        // artık ikinci window'a geçiş yapabiliriz
        driver.switchTo().window(ikinciWindowWHD);

        // Electronics sayfasının açıldığını test edin
        String expectedElectronicsPageTitle = "Electronics";
        String actualElectronicsPageTitle = driver.getTitle();

        Assert.assertTrue(actualElectronicsPageTitle.contains(expectedElectronicsPageTitle));

        // Bulunan ürün sayısının 16 olduğunu test edin

        List<WebElement> urunSayiListesi = driver.findElements(By.xpath("//*[@*='product-box mb-2 pb-1']"));

        int expectedUrunSayisi = 16;
        int actualUrunSayisi = urunSayiListesi.size();

        Assert.assertEquals(expectedUrunSayisi, actualUrunSayisi);

        // Ilk açtığınız addremove sayfasına dönün
        driver.switchTo().window(ilkWindowWHD);

        // Url'in addremove içerdiğini tes edin

        String expectedUrlIcerik = "addremove";
        String actualUrlIcerik = driver.getCurrentUrl();

        Assert.assertTrue(actualUrlIcerik.contains(expectedUrlIcerik));

    }

}
