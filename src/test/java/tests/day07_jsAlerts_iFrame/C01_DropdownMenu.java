package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C01_DropdownMenu extends TestBase {

    @Test
    public void zeroAppTesti() {

        // 1. http://zero.webappsecurity.com/ Adresine gidin
        driver.get("http://zero.webappsecurity.com/");

        // 2. Sign in butonuna basın
        // driver.findElement(By.xpath("//*[@*='signin_button']")).click();
        driver.findElement(By.id("signin_button")).click();

        // 3. Login kutusuna "username" yazın
        // WebElement userName = driver.findElement(By.xpath("//input[@*='user_login']"));
        driver.findElement(By.id("user_login")).sendKeys("username");

        // 4. Password kutusuna "password" yazın

        driver.findElement(By.id("user_password")).sendKeys("password");

        // 5. Sign in tuşuna basın, back tuşuna basarak sayfaya dönün
        driver.findElement(By.xpath("//*[@*='Sign in']")).click();
        driver.navigate().back();

        // 6. Online banking menüsünden Pay Bills sayfasına gidin
        driver.findElement(By.xpath("//strong[text()='Online Banking']")).click();
        driver.findElement(By.id("pay_bills_link")).click();

        // 7. "Purchase Foreign Currency" tuşuna basın
        driver.findElement(By.xpath("//*[text()='Purchase Foreign Currency']")).click();

        // 8. "Currency" drop down menüsünden Eurozone'u seçin // value : EUR
        WebElement currencyDropdownMenu = driver.findElement(By.id("pc_currency"));
        Select select = new Select(currencyDropdownMenu);
        select.selectByValue("EUR");

        // 9. "amount" kutusuna bir sayı girin
        driver.findElement(By.id("pc_amount")).sendKeys("200");


        //10. "US Dollars" radio button'un seçilmediğini test edin
        WebElement usDollarsRadioButton = driver.findElement(By.id("pc_inDollars_true"));
        Assert.assertFalse(usDollarsRadioButton.isSelected());

        //11. "Selected currency" butonunu seçin
        driver.findElement(By.id("pc_inDollars_false")).click();

        //12. "Calculate Costs" butonuna basın sonra "purchase" butonuna basın
        driver.findElement(By.id("pc_calculate_costs")).click();
        driver.findElement(By.id("purchase_cash")).click();

        //13. "Foreign currency cash was successfully purchased." yazısının çıktığını kontrol edin.
        WebElement yaziElementi1 = driver.findElement(By.xpath("//*[text()='Foreign currency cash was successfully purchased.']"));
        WebElement yaziElementi = driver.findElement(By.id("alert_content"));

        String expectedYazi = "Foreign currency cash was successfully purchased.";
        String actualYazi = yaziElementi1.getText();

        Assert.assertEquals(expectedYazi, actualYazi);

        ReusableMethods.bekle(2);

    }

}
