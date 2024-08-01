package tests.day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_Assertion {

    WebDriver driver;

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void test01() {

        // gerekli ayarlamaları yapıp, test otomasyonu sayfasına gidin ve sayfaya gidebildiğinizi test edin

        /*
            JUnit'in console'da verdiği passed/failed raporu
            if else'in sonucuna bakmaz

            JUnit
                - kod sorunsuz çalışıp bitti ise PASSED
                - kod çalışırken exception oluşursa FAILED olarak değerlendirir
         */

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://testotomasyonu.com/");

        String expectedURL = "https://testotomasyonu.com";
        String actualURL = driver.getCurrentUrl();

        if (expectedURL.equals(actualURL)) {
            System.out.println("Test PASSED");
        } else {
            System.out.println("Test FAILED");
            throw new RuntimeException();
            // exception firlatarak, if ile kontrol ettiğimiz test failed olduğunda
            // JUnit'in de failed olmasını sağlayabiliriz
        }
    }
}
