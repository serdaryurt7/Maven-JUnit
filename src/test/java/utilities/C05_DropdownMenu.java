package utilities;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class C05_DropdownMenu extends TestBase {

    @Test
    public void dropdowntesti() throws InterruptedException {

        // Select tagına sahipse dropdown menu'dur

        //    https://testotomasyonu.com/form  adresine gidin
        driver.get("https://testotomasyonu.com/form");

        // 1. Dogum tarihi gün seçeneğinden index kullanarak 5'i seçin

        WebElement gunDropdownMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        Select selectGun = new Select(gunDropdownMenu);
        selectGun.selectByIndex(5);

        // 2. Doğum tarihi ay seçeneğinden value olarak Nisan'ı seçin
        WebElement ayDropdownMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDropdownMenu);
        selectAy.selectByValue("nisan");


        // 3. Doğum tarihi yıl seçeneğinden visible text kullanarak 1990'i seçin
        WebElement yilDropdownMenu = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil = new Select(yilDropdownMenu);
        selectYil.selectByVisibleText("1990");

        // 4. Seçilen değerleri konsolda yazdırın
        System.out.println(selectGun.getFirstSelectedOption().getText());
        System.out.println(selectAy.getFirstSelectedOption().getText());
        System.out.println(selectYil.getFirstSelectedOption().getText());


        // 5. Ay dropdown menüdeki tüm değerleri(value) yazdırın

        List<WebElement> optionElementleriList = selectAy.getOptions();
        System.out.println(ReusableMethods.stringListeCevir(optionElementleriList));

        // listedeki opsiyonlarda Mart değeri olduğunu test edin

        Assert.assertTrue(ReusableMethods.stringListeCevir(optionElementleriList).contains("Mart"));

        // 6. Ay dropdown menusunun boyutunun 13 olduğunu test edin

        Assert.assertEquals(13, optionElementleriList.size());

        ReusableMethods.bekle(5);

    }

}
