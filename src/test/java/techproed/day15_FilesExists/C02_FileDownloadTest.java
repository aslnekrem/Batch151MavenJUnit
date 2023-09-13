package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownloadTest extends TestBase {
    //https://testcenter.techproeducation.com/index.php?page=file-download adresine gidelim.
    //b10 all test cases dosyasını indirelim
    //Dosyanın başarıyla indirilip indirilmediğini test edelim

    @Test
    public void test01() {


        driver.get("https://testcenter.techproeducation.com/index.php?page=file-download");

        //b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='b10 all test cases, code.docx']")).click();
        //İndirmemizi istediği dosyayı locate edip tıkladık ve dosyamız indirilenler klasörüne indi

        String dosyaYolu = "C:/Users/aslne/Downloads/b10 all test cases, code.docx";

        //Dosyanın başarıyla indirilip indirilmediğini test edelim
        //1. Way
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        bekle(2);
        //2. Way
        File file = new File(dosyaYolu);
        Assert.assertTrue(file.exists());
        file.delete();

    }
}
