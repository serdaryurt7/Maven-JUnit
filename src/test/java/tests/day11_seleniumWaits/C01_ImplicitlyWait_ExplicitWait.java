package tests.day11_seleniumWaits;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.ReusableMethods;

import java.time.Duration;

public class C01_ImplicitlyWait_ExplicitWait {

    // Iki tane metod oluşturun : implicitWaitTest , explicitWaitTest
    // Iki method için de aşağıdaki adımları test edin
    // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
    // 2. Remove butonuna basın
    // 3. "It's gone!" mesajının görüntülendiğini doğrulayın
    // 4. Add butonuna basın
    // 5. It's back mesajının göründüğünü test edin

    WebDriver driver;

    @Test
    public void implicitWaitTest() {
        // Implicit wait'in görevini ve işleyişini daha iyi anlayabilmek için
        // TestBase class'da yaptığımız ayarları burada yapalım
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 2. Remove butonuna basın
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // 3. "It's gone!" mesajının görüntülendiğini doğrulayın
        WebElement itsGoneElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsGoneElementi.isDisplayed());

        // 4. Add butonuna basın
        driver.findElement(By.xpath("//*[text()='Add']")).click();
        // 5. It's back mesajının göründüğünü test edin
        WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBackElementi.isDisplayed());


        driver.quit();

    }

    @Test
    public void explicitWaitTesti() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(1));
        // implicitlyWait süresini 1 saniyeye indirmemizin sebebi
        // implicitlyWait'in tolere edemeyeceği durumların oluşması
        // ve bu durumları explicitwait ile nasıl aşacağımızı göstermek

        // 1. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 2. Remove butonuna basın
        driver.findElement(By.xpath("//*[text()='Remove']")).click();
        // 3. "It's gone!" mesajının görüntülendiğini doğrulayın

        // implicitlyWait'in tolere edemediği durumlarda
        // explicitlyWait için WebDriverwait objesi oluştururuz

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        /*
             wait objesine bir elemanı bekletmek istediğimizde iki durum karşımıza çıkar
             1- üzerinde çalıştığımız webelement locate edilebiliyorsa
                önce locate edip, sonra wait objesine istediğimiz durum gerçekleşene kadar
                locate edilmiş olan webelementi beklemesini söyleyebiliriz

             2- belirli bir zaman sonra hango locator ile locate edebileceğimizi bildiğimiz
                ama henüz görünmediği için locate edemediğimiz webelementlerde
                bekleme ve locate'i birlikte yapabilir

                   WebElement itsGoneElementi = driver.findElement(By.xpath("//*[text()=\"It's gone!\"]"));

                   wait.until(ExpectedConditions.visibilityOf(itsGoneElementi));
         */

        WebElement itsGoneElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's gone!\"]")));


        Assert.assertTrue(itsGoneElementi.isDisplayed());


        // 4. Add butonuna basın
        driver.findElement(By.xpath("//*[text()='Add']")).click();

        // 5. It's back mesajının göründüğünü test edin
        // WebElement itsBackElementi = driver.findElement(By.xpath("//*[text()=\"It's back!\"]"));

        WebElement itsBackElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()=\"It's back!\"]")));

        Assert.assertTrue(itsBackElementi.isDisplayed());

        driver.quit();

    }

}
