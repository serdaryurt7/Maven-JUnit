package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.SortedMap;

public class C05_DosyaIndirmeTesti extends TestBase {

    @Test
    public void dosyaIndirmeTesti() {

        // 1. https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");
        // 2. luminoslogo.png dosyasını indirelim

        driver.findElement(By.xpath("//*[text()='luminoslogo.png']"))
                .click();
        ReusableMethods.bekle(3);
        // 3. Dosyanın başarıyla indirilip indirilmediğini test edelim

        // Kodumuzun herkesin bilgisayarında çalışabilmesi için dosya yolunu dinamik yapmak isteriz
        // internette tıkladığımız dosya downloads klasörüne indirilir

        String dinamikDosyaYolu = System.getProperty("user.home") + "\\Downloads\\luminoslogo.png";

        Assert.assertTrue(Files.exists(Paths.get(dinamikDosyaYolu)));

        // C:\Users\DELL\Downloads

        System.out.println(System.getProperty("user.home")); // C:\Users\DELL

    }

}
