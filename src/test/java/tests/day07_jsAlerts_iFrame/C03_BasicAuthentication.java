package tests.day07_jsAlerts_iFrame;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.swing.*;

public class C03_BasicAuthentication extends TestBase {


    @Test
    public void test01() {

        // 1 - Bir class oluşturun : BasicAuthentication
        // 2 - https://testotomasyonu.com/basicauth sayfasına gidin
        // 3 - aşağıdaki yöntem ve test datalarını kullanarak authentication'ı yapın
        //
        // Html komutu : https://username:password@URL
        // username    : membername
        // password    : sunflower
        //
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");

        // 4 - Başarılı bir şekilde sayfaya girildiğini doğrulayın

        WebElement basicAuthElement = driver.findElement(By.tagName("h1"));

        String expectedYazi = "Basic Auth";
        String actualYazi = basicAuthElement.getText();

        Assert.assertEquals(expectedYazi, actualYazi);

        ReusableMethods.bekle(2);

    }
}
