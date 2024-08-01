package tests.day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_BeforeAfterNotasyonlari {

    // Üç farklı test method'unda verilen sayfalara gidin
    // o sayfaya gidildiğini test edin ve sayfayı kapatın

    WebDriver driver;

    public void baslangicAyarlariYap() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @Test
    public void testOtomasyonuTest() {
        baslangicAyarlariYap();
        driver.get("https://www.testotomasyonu.com/");


        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

        driver.quit();
    }

    @Test
    public void wisequarterTest() {
        baslangicAyarlariYap();
        driver.get("https://wisequarter.com/");


        String expectedUrl = "https://wisequarter.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

        driver.quit();
    }

    @Test
    public void youtubeTest() {
        baslangicAyarlariYap();
        driver.get("https://www.youtube.com/");


        String expectedUrl = "https://www.youtube.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Youtube testi PASSED");
        } else System.out.println("Youtue testi FAILED");

        driver.quit();
    }
}
