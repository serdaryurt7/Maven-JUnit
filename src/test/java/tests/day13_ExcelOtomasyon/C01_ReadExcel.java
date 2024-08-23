package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.*;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C01_ReadExcel {

    @Test
    public void readExcelTest() throws IOException {

        // 7. Dosya yolunu bir String değişkene atayalım
        String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";

        // 8. FileInputStream objesi oluşturup, parametre olarak dosya yolunu girelim
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);

        // 9. Workbook objesi oluşturalım, parameter olarak fileInputStream objesini girelim
        //10. WorkbookFactory.create(fileInputStream)
        Workbook workbook = WorkbookFactory.create(fileInputStream);

        // dosya yolu sayesinde dosyaya ulaşıp,
        // fileInputStream ile dosyadaki bilgileri aldık
        // ve o bilgileri bu class'da kullanabilmek için
        // kendi oluşturduğumuz workbook objesine yükledik.


        //11. Worksheet objesi oluşturun workbook.getSheetAt(index)
        Sheet sayfa1 = workbook.getSheet("Sayfa1");

        // Row ve Cell index kullanır, yani 0'dan başlar

        //12. Row objesi oluşturun sheet.getRow(index)
        Row row = sayfa1.getRow(7);

        //13. Cell objesi oluşturun row.getCell(index)
        Cell cell = row.getCell(1);

        System.out.println(cell);

    }

}
