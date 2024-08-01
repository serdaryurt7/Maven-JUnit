package tests.day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.sql.Driver;
import java.time.Duration;

public class C03_RadioButtons {

    // a. Verilen web sayfasına gidin.  https://testotomasyonu.com/form
    // b. Cinsiyet Radio button elementlerini locate edin
    // c. İki farklı test method'u oluşturup yazıdan veya direk buton'dan size uygun olanı seçin
    // d. Seçtiğiniz radio button'un seçili, ötekilerin seçili olmadığını test edin
    static WebDriver driver;

    @BeforeClass
    public static void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public static void teardown() {

        driver.quit();
    }

    @Test
    public void yazidanSecmeTesti() {
        driver.get("https://testotomasyonu.com/form");
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // yazıdan erkek radio butonu seçelim

        //label[@for='inlineRadio2']

        WebElement erkekRadioYaziElementi = driver.findElement(By.xpath("//*[@for='inlineRadio2']"));

        erkekRadioYaziElementi.click();

        // d. Seçtiğiniz radio button'un seçili, ötekilerin seçili olmadığını test edin

        // erkek radiobutton'un seçili olduğunu test edelim
        Assert.assertTrue(erkekRadioButton.isSelected());

        // kadin ve diğer radioButton'larının seçili olmadığını test edelim

        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());
    }

    @Test
    public void butondanSecmeTesti(){

        driver.get("https://testotomasyonu.com/form");
        WebElement kadinRadioButton = driver.findElement(By.id("inlineRadio1"));
        WebElement erkekRadioButton = driver.findElement(By.id("inlineRadio2"));
        WebElement digerRadioButton = driver.findElement(By.id("inlineRadio3"));

        // radioButtonu kullanarak erkek radio butonu seçelim

        erkekRadioButton.click();

        // erkek radiobutton'un seçili olduğunu test edelim
        Assert.assertTrue(erkekRadioButton.isSelected());

        // kadin ve diğer radioButton'larının seçili olmadığını test edelim

        Assert.assertFalse(kadinRadioButton.isSelected());
        Assert.assertFalse(digerRadioButton.isSelected());

    }

}
