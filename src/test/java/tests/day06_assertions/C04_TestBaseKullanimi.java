package tests.day06_assertions;

import org.junit.Assert;
import org.junit.Test;
import utilities.TestBase;

public class C04_TestBaseKullanimi extends TestBase {

    @Test
    public void test01() {

        // testotomasyonu sayfasina gidin

        driver.get("https://testotomasyonu.com/");

        String expectedUrl = "https://testotomasyonu.com/";
        String actualUrl = driver.getCurrentUrl();

        // sayfaya gittiğinizi test edin

        Assert.assertEquals(expectedUrl, actualUrl);
    }

}
