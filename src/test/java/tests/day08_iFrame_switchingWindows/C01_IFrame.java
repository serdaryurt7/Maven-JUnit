package tests.day08_iFrame_switchingWindows;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_IFrame extends TestBase {

    @Test
    public void iFrameTesti() {
        // 1) https://the-internet.herokuapp.com/iframe adresine gidin.
        driver.get("https://the-internet.herokuapp.com/iframe");
        // 2) Bir metod oluşturun: iframeTest
        //  - "An IFrame containing..." textinin erişilebilir olduğunu test edin ve konsolda yazdırın.

        ReusableMethods.bekle(5);

        WebElement anIframeYaziElementi = driver.findElement(By.xpath("//*[text()='An iFrame containing the TinyMCE WYSIWYG Editor']"));
        Assert.assertTrue(anIframeYaziElementi.isEnabled());


        // textBox iframe içinde olduğundan önce iframe'e geçiş yapmalıyız

        WebElement iFrameElementi = driver.findElement(By.xpath("//*[@id='mce_0_ifr']"));
        driver.switchTo().frame(iFrameElementi);

        //  - Text Box'a "Merhaba Dunya!" yazın.

        WebElement textBoxElementi = driver.findElement(By.xpath("//*[@id='tinymce']"));
        ReusableMethods.bekle(3);
        textBoxElementi.clear();

        textBoxElementi.sendKeys("Merhaba Dunya!");

        //  - TextBox'ın altında bulunan "Elemental Selenium" linkini textinin görünür olduğunu doğrulayın ve konsolda yazdırın.

        // element anasayfada olduğundan önce geçiş yaptığımız iframe'den geri dönelim

        driver.switchTo().defaultContent();

        WebElement elementalSeleniumElementi = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));

        Assert.assertTrue(elementalSeleniumElementi.isDisplayed());

        System.out.println(elementalSeleniumElementi.getText());

        ReusableMethods.bekle(3);


    }
}
