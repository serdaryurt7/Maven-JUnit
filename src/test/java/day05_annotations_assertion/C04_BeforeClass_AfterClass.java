package day05_annotations_assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C04_BeforeClass_AfterClass {

    // Üç test method'u oluşturup aşağıdaki görevleri tamamlayın
    // 1- testotomasyonu sayfasına gidip, sayfaya gittiğimizi test edin
    // 2- phone için arama yapıp, ürün bulunabildiğini test edin
    // 3- ilk ürüne tıklayıp, ürün açıklamasında, case sensitive olmadan phone geçtiğini test edin

    /*
        Eğer başlangıç ayarlarının en başta sadece 1 kere yapılmasını,
        test method'ları bittikten sonra da, bitiş ayarlarının yapılmasını istiyorsanız

        @Before ve @After YERINE
        @BeforeClass ve @AfterClass kullanırız
     */

    WebDriver driver;
    List<WebElement> bulunanUrunlerListesi;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @AfterClass
    public void teardown() {
        driver.quit();
    }

    public void test01() {
        // 1- testotomasyonu sayfasına gidip, sayfaya gittiğimizi test edin
        driver.get("https://www.testotomasyonu.com/");

        String expectedUrl = "https://www.testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        if (actualUrl.equals(expectedUrl)) {
            System.out.println("Test otomasyonu sayfasina gitme testi PASSED");
        } else System.out.println("Test otomasyonu sayfasina gitme testi FAILED");
    }

    public void test02() {
        // 2- phone için arama yapıp, ürün bulunabildiğini test edin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);

        bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        int actualUrunSayisi = bulunanUrunlerListesi.size();

        if (actualUrunSayisi > 0) {
            System.out.println("Urun bulma testi PASSED");
        } else System.out.println("Urun bulma testi FAILED");

    }

    public void test03() {
        // 3- ilk ürüne tıklayıp, ürün açıklamasında, case sensitive olmadan phone geçtiğini test edin

        bulunanUrunlerListesi.get(0).click();

        WebElement urunAciklamaElementi = driver.findElement(By.xpath("//*[@*='product-short-desc  my-2']"));

        String expectedIcerik = "phone";
        String actualAciklamaKucukHarf = urunAciklamaElementi.getText().toLowerCase();

        if (actualAciklamaKucukHarf.contains(expectedIcerik)){
            System.out.println("ilk urun testi PASSED");
        }else System.out.println("ilk urun testi FAILED");
    }

}
