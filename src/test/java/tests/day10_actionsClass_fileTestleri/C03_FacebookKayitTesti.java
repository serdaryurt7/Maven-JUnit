package tests.day10_actionsClass_fileTestleri;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C03_FacebookKayitTesti extends TestBase {

    @Test
    public void kayitTesti() {

        // 1- https://www.facebook.com adresine gidelim
        driver.get("https://www.facebook.com");
        // 2- Cookies kabul edelim
        // driver.findElement(By.xpath("//*[@title='Allow all cookies']")).click();
        ReusableMethods.bekle(1);

        // 3- Yeni hesap oluştur butonuna basalım

        driver.findElement(By.xpath("//*[text()='Yeni hesap oluştur']"))
                .click();

        // 4- Ad, soyad, mail ve şifre kutularına değer yazalım ve kaydol tuşuna basalım

        WebElement firstnameKutusu = driver.findElement(By.xpath("//input[@*='Adın']"));

        Actions actions = new Actions(driver);

        Faker faker = new Faker();

        String fakeEmail = faker.internet().emailAddress();

        actions.click(firstnameKutusu)
                .sendKeys(faker.name().firstName())
                .sendKeys(Keys.TAB)
                .sendKeys(faker.name().lastName())
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(fakeEmail)
                .sendKeys(Keys.TAB)
                .sendKeys(faker.internet().password())
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys("15")
                .sendKeys(Keys.TAB)
                .sendKeys("Mar")
                .sendKeys(Keys.TAB)
                .sendKeys("1990")
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.TAB)
                .sendKeys(Keys.ARROW_RIGHT)
                .perform();

        // 5- Kaydol tuşuna basalım

        ReusableMethods.bekle(2);
        driver.findElement(By.name("websubmit")).click();

        ReusableMethods.bekle(3);


    }


}
