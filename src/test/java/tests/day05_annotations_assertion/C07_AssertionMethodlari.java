package tests.day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertionMethodlari {

    // gerekli ayarlamaları yap
    // testotomasyonu sayfasına gidin
    // sayfaya gidebildiğinizi test edin

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
    public void test01() {

        driver.get("https://testotomasyonu.com/");

        String expectedURL = "https://testotomasyonu.com/";

        String actualURL = driver.getCurrentUrl();

        Assert.assertEquals(expectedURL, actualURL);

        // Önce expected yazılır sonra actual yazılır.
    }

}
