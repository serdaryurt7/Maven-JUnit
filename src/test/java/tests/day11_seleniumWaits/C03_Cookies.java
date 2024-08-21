package tests.day11_seleniumWaits;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void test01() {

        // 1. amazon anasayfaya gidin
        driver.get("htttps://www.walmart.com");

        ReusableMethods.bekle(1);
        // 2. tüm cookie'leri listeleyin
        Set<Cookie> cookieSeti = driver.manage().getCookies();

        int siraNo = 1;
        for (Cookie eachCookie : cookieSeti
        ) {

            System.out.println(siraNo + "--------" + eachCookie);
            siraNo++;
        }

        // 3. Sayfadaki cookies sayısının 5'den büyük olduğunu test edin
        Assert.assertTrue(cookieSeti.size() > 5);
        // 4. ismi mobileweb olan cookie değerinin 0 olduğunu test edin
        Assert.assertEquals(driver.manage().getCookieNamed("mobilweb").getValue(), "0");
        // 5. ismi "en sevdigim cookie" ve değeri "cikolatali" olan bir cookie oluşturun ve sayfaya ekleyin
        Cookie yeniCookie = new Cookie("en sevdigim cookie", "cikolatali");
        driver.manage().addCookie(yeniCookie);
        // 6. eklediğniiz cookie'nin sayfaya eklendiğini test edin

        cookieSeti = driver.manage().getCookies();

        siraNo = 1;
        for (Cookie eachCookie : cookieSeti
        ) {

            System.out.println(siraNo + "--------" + eachCookie);
            siraNo++;
        }

        Assert.assertEquals(driver.manage().getCookieNamed("en sevdigim cookie").getValue(), "cikolatali");


        // 7. ismi mobileweb olan cookie'yi silin ve silindiğini test edin

        driver.manage().deleteCookieNamed("mobileweb");
        System.out.println("===============================================");

        cookieSeti = driver.manage().getCookies();

        siraNo = 1;
        boolean mobilewebVarMi = false;
        for (Cookie eachCookie : cookieSeti
        ) {

            System.out.println(siraNo + "--------" + eachCookie);
            siraNo++;

            if (eachCookie.getName().equals("mobileweb")) {
                mobilewebVarMi = true;
            }
        }

        // eğer mobileweb silindi ise mobilewebVarMi bu satırda false olmalı
        Assert.assertFalse(mobilewebVarMi);

        // 8. tüm cookie'leri silin ve silindiğini test edin

        driver.manage().deleteAllCookies();
        cookieSeti = driver.manage().getCookies();

        Assert.assertTrue(cookieSeti.isEmpty());

    }

}
