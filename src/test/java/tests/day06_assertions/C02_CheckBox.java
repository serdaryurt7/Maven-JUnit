package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_CheckBox {

    // Gerekli yapıyı oluşturun ve aşağıdaki görevi tamamlayın

    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void checkboxTesti() {

        // a. Verilen web sayfasına gidin  https://testotomasyonu.com/form
        driver.get("https://testotomasyonu.com/form");
        // b. Sırt Ağrısı ve Çarpıntı checkbox'larını seçin
        WebElement sirtAgrisiCheckbox = driver.findElement(By.id("gridCheck5"));
        WebElement sirtAgrisiYaziElementi = driver.findElement(By.xpath("//label[@for='gridCheck5']"));

        WebElement carpintiCheckbox = driver.findElement(By.id("gridCheck4"));
        WebElement carpintiYaziElementi = driver.findElement(By.xpath("//label[@for='gridCheck4']"));

        // sirt ağrısını yazıdan seçelim, çarpıntıyı ise checkbox'dan seçelim

        sirtAgrisiYaziElementi.click();
        carpintiCheckbox.click();


        // c. Sırt Ağrısı ve Çarpıntı checkbox'larının seçili olduğunu test edin

        Assert.assertTrue(sirtAgrisiCheckbox.isSelected());
        Assert.assertTrue(carpintiCheckbox.isSelected());

        // d. Şeker ve Epilepsi checkbox'larının seçili olmadığını test edin

        WebElement sekerCheckbox = driver.findElement(By.id("hastalikCheck2"));
        WebElement epilepsiCheckbox = driver.findElement(By.id("hastalikCheck7"));

        Assert.assertFalse(sekerCheckbox.isSelected());
        Assert.assertFalse(epilepsiCheckbox.isSelected());

    }
}
