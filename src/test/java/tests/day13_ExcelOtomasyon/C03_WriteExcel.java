package tests.day13_ExcelOtomasyon;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class C03_WriteExcel {

    @Test
    public void writeExcelTesti() throws IOException {
        // 3) Adımları takip ederek Sayfa1'deki 1.satira kadar gidelim
        String dosyaYolu = "src/test/java/tests/day13_ExcelOtomasyon/ulkeler.xlsx";
        FileInputStream fileInputStream = new FileInputStream(dosyaYolu);
        Workbook workbook = WorkbookFactory.create(fileInputStream);
        Sheet sayfa1 = workbook.getSheet("Sayfa1");
        // 4) 5.hücreye yeni bir cell oluşturalım
        sayfa1.getRow(0).createCell(4);
        // 5) Oluşturduğumuz hücreye "Nufus" yazdıralım
        sayfa1.getRow(0).getCell(4).setCellValue("Nufus");
        // 6) 2.satır nüfus kolonuna 1500000 yazdıralım
        sayfa1.getRow(1).createCell(4).setCellValue("1500000");
        // 7) 10.satır nüfus kolonuna 250000 yazdıralım
        sayfa1.getRow(9).createCell(4).setCellValue("250000");
        // 8) 15.satır nüfus kolonuna 54000 yazdıralım
        sayfa1.getRow(14).createCell(4).setCellValue("54000");
        // 9) Dosyayı kaydedelim
        FileOutputStream fileOutputStream = new FileOutputStream(dosyaYolu);
        workbook.write(fileOutputStream);
        //10) Dosyayı kapatalım

        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();


    }

}
