package tests.day04_MavenIlkGun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_MainMethodsuzIlkTest {

    @Test
    public void mainsizTest() {

        // gerekli ayarları yapın
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        // test otomasyonu sayfasına gidin
        driver.get("https://testotomasyonu.com/");
        
    }

    @Test
    public void test02(){}

    @Test
    public void test03(){}
}
