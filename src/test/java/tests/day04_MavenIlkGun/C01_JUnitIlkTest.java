package tests.day04_MavenIlkGun;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C01_JUnitIlkTest {
    public static void main(String[] args) throws InterruptedException {

        // ilk ayarları yapın
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


        // test otomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com/");

        // chair için arama yapın
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("chair" + Keys.ENTER);

        // arama sonucunda ürün bulunabildiğini test edin
        List<WebElement> bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));

        int actualUrunsayisi = bulunanUrunlerListesi.size();

        if (actualUrunsayisi > 0) {
            System.out.println("Chair testi PASSED");
        } else System.out.println("Chair testi FAILED");

        // Java için arama yapın
        Thread.sleep(2000);
        aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("Java" + Keys.ENTER);
        Thread.sleep(1000);

        // arama sonucunda ürün bulunamadığını test edin
        bulunanUrunlerListesi = driver.findElements(By.xpath("//*[@*='product-box my-2  py-1']"));
        actualUrunsayisi = bulunanUrunlerListesi.size();

        if (actualUrunsayisi == 0) {
            System.out.println("Chair testi PASSED");
        } else System.out.println("Chair testi FAILED");

        // sayfayı kapatın

        Thread.sleep(3000);
        driver.quit();
    }
}
