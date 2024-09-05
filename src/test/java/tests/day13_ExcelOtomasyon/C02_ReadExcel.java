package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import java.util.TreeMap;

public class C02_ReadExcel {

    @Test
    public void readExcelTesti() throws IOException {

        String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // 1. satirdaki 2.hucreye gidelim ve yazdiralim
        System.out.println(sayfa1.getRow(0).getCell(1));

        // 1. satırdaki 2.hücreyi bir string değişkene atayalım ve yazdıralım
        String istenenHucre = sayfa1.getRow(0).getCell(1).toString();
        System.out.println(istenenHucre);

        // 2. satır 4.cell'in afganistan'ın başkenti olduğunu test edelim
        String expectedHucreDegeri = "Kabil";
        String actualHucreDegeri = sayfa1.getRow(1).getCell(3).toString();

        Assert.assertEquals(expectedHucreDegeri, actualHucreDegeri);

        // Satır sayısını bulalım
        System.out.println(sayfa1.getLastRowNum()); // 190 son satırın index'ini verdi

        // Fiziki olarak kullanılan satır sayısını bulun
        System.out.println(sayfa1.getPhysicalNumberOfRows()); // 191 reel olarak kullanılan satır sayısını verir


        Sheet sayfa2 = workbook.getSheet("Sayfa2");

        System.out.println(sayfa2.getLastRowNum()); // 12 son kullanılan satırın index'i

        System.out.println(sayfa2.getPhysicalNumberOfRows()); // 10  boş satırları saymaz

        // System.out.println(sayfa2.getRow(23).getCell(1)); // NullPointerException
        // workbook excel dosyasında kullanılan son satırdan sonrasını almaz
        // o satırlara ulaşmak isterseniz NullPointerException verir

        // System.out.println(sayfa2.getRow(5).getCell(10)); // NullPointerException
        System.out.println(sayfa2.getRow(6).getCell(10)); // null
        // System.out.println(sayfa2.getRow(5).getCell(5)); // NullPointerException
        System.out.println(sayfa2.getRow(6).getCell(20)); // null

        // Ingilizce Ulke isimleri ve başkentleri bir map olarak kaydedelim

        boolean polandVarMi = false;
        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            String satirdakiIngilizceUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();

            if (satirdakiIngilizceUlkeIsmi.equalsIgnoreCase("Poland")) {
                polandVarMi = true;
            }

        }

        Assert.assertTrue(polandVarMi);


        // Excel'de ingilizce ülke ismi olarak Poland'ın olduğunu test edin

        // Excel'de ingilizce ismi Samoa olan ülkenin başkent isminin Apia olduğunu test edin

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            if (satirdakiUlkeIsmi.equalsIgnoreCase("Samoa")) {

                Assert.assertEquals("Apia", satirdakiBaskentIsmi);

            }

        }

        // Bu iki testi Map kullanarak da yapalım
        // bunun için önce ingilizce ülke isimleri ve başkentleri bir map yapalım

        Map<String, String> ulkelerveBaskentler = new TreeMap<>();

        for (int i = 0; i <= sayfa1.getLastRowNum(); i++) {

            String satirdakiUlkeIsmi = sayfa1.getRow(i).getCell(0).toString();
            String satirdakiBaskentIsmi = sayfa1.getRow(i).getCell(1).toString();

            ulkelerveBaskentler.put(satirdakiUlkeIsmi, satirdakiBaskentIsmi);
        }

        // Excel'de ingilizce ülke ismi olarak Poland'ın olduğunu test edin

        Assert.assertTrue(ulkelerveBaskentler.containsKey("Poland"));

        // Excel'de ingilizce ismi Samoa olan ülkenin başkent isminin Apia olduğunu test edin

        Assert.assertEquals("Apia", ulkelerveBaskentler.get("Samoa"));

    }

}
