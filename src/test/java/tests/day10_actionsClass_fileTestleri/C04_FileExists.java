package tests.day10_actionsClass_fileTestleri;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C04_FileExists {

    @Test
    public void test01() {

        // projemiz altında deneme.txt dosyasının varolduğunu test edin

        String dosyaYolu = "src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt";

        // "src/test/java/tests/day10_actionsClass_fileTestleri/deneme.txt"

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        //C:\Users\DELL\IdeaProjects\Team130_JUnit
        // \src\test\java\tests\day10_actionsClass_fileTestleri\deneme.txt

        System.out.println(System.getProperty("user.dir"));

        // Users\DELL\IdeaProjects\Team130_JUnit

        // Absolute dosya yolunuzu dinamik yapmak isterseniz

        String absoluteDosyaYolu = System.getProperty("user.dir") + "\\src\\test\\java\\tests\\day10_actionsClass_fileTestleri\\deneme.txt";

       Assert.assertTrue(Files.exists(Paths.get(absoluteDosyaYolu)));

    }

}
