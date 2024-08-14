package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_ActionsContextClick extends TestBase {

    @Test
    public void test01() {

        // https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");
        // Çizili alan üzerinde sağ click yapın
        Actions actions = new Actions(driver);
        WebElement ciziliAlanElementi = driver.findElement(By.id("hot-spot"));
        actions.contextClick(ciziliAlanElementi).perform();

        ReusableMethods.bekle(1);

        // Alert'te çıkan yazının "You selected a context menu" olduğunu test edin.
        String expectedAlertYazisi = "You selected a context menu";
        String actualAlertYazisi = driver.switchTo().alert().getText();

        Assert.assertEquals(expectedAlertYazisi, actualAlertYazisi);

        // Tamam diyerek alert'i kapatalım
        driver.switchTo().alert().accept();

        ReusableMethods.bekle(2);
        // Elemental Selenium linkine tıklayalım
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        //  link tıkladığında yeni bir tab açılıyor, o tab'a geçmek için C01'deki method'u kullanalım
        ReusableMethods.bekle(2);
        ReusableMethods.titleIleWindowDegistir("Home | Elemental Selenium", driver);


        // Açılan sayfada h1 tagında "Make sure your code lands" yazdığını test edelim

        WebElement h1TagElementi = driver.findElement(By.tagName("h1"));
        String expectedYazi = "Elemental Selenium";
        String actualYazi = h1TagElementi.getText();

        Assert.assertEquals(expectedYazi, actualYazi);

        ReusableMethods.bekle(2);

        // 1:37

    }

}
