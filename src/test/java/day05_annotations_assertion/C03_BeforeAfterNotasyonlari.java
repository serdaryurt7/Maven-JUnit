package day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BeforeAfterNotasyonlari {

    // Üç farklı test method'unda verilen sayfalara gidin
    // o sayfaya gidildiğini test edin ve sayfayı kapatın

    /*
        Eğer bir class'da her test method'undan önce çalışmasını istediğimiz kodlar var ise
        bunu sağlamak için @Before notasyonuna sahip bir method oluşturabiliriz

        Eğer bir class'da her test method'u çalıştıktan sonra çalışmasını istediğimiz kodlar varsa
         bunu sağlamak için @After notasyonuna sahip bir method oluşturabiliriz

         @Before ->  @Test1 -> @After
         @Before ->  @Test2 -> @After
         @Before ->  @Test3 -> @After
     */

    WebDriver driver;

    @Before
    public void setup() {
        System.out.println("@Before calisti");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        System.out.println("@After calisti");
        driver.quit();
    }

    @Test
    public void testOtomasyonuTest() {

        driver.get("https://www.testotomasyonu.com/");


        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Test otomasyonu testi PASSED");
        } else System.out.println("Test otomasyonu testi FAILED");

    }

    @Test
    public void wisequarterTest() {

        driver.get("https://wisequarter.com/");


        String expectedUrl = "https://wisequarter.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Wisequarter testi PASSED");
        } else System.out.println("Wisequarter testi FAILED");

    }

    @Test
    public void youtubeTest() {

        driver.get("https://www.youtube.com/");


        String expectedUrl = "https://www.youtube.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Youtube testi PASSED");
        } else System.out.println("Youtue testi FAILED");
    }
}

