package tests.day09_actionsClass;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.AcceptedW3CCapabilityKeys;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C05_MoveToElement extends TestBase {
    @Test
    public void test01() {

        // https://www.testotomasyonu.com/ adresine gidin
        driver.get("https://www.testotomasyonu.com/");

        // "Kids Wear" menüsünün açılması için mouse'u bu menünün üstüne getirin
        // 2:15

        WebElement kidsWearLinki = driver.findElement(By.xpath("(//a[text()='Kids Wear'])[3]"));

        Actions actions = new Actions(driver);

        actions.moveToElement(kidsWearLinki).perform();

        // "Boys" linkine basın
        ReusableMethods.bekle(1);

        driver.findElement(By.xpath("//a[text()='Boys']")).click();

        // Açılan sayfadaki ilk ürünü tıklayın
        driver.findElement(By.xpath("(//*[@*='product-box mb-2 pb-1'])[1]")).click();

        // Açılan sayfada ürün isminin "Boys Shirt White Color" olduğunu test edin

        String expectedUrunIsmi = "Boys Shirt White Color";

        WebElement urunIsimElementi = driver.findElement(By.xpath(" //div[@class=' heading-sm mb-4']"));
        String actualUrunIsmi = urunIsimElementi.getText();

        Assert.assertEquals(expectedUrunIsmi, actualUrunIsmi);

        ReusableMethods.bekle(3);


    }

}
