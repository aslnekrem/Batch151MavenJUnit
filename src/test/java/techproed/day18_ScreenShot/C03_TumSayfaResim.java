package techproed.day18_ScreenShot;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C03_TumSayfaResim extends TestBase {
    @Test
    public void test01() {
        //Techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        bekle(2);

        //Cikan resmi kapatalim
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        tumSayfaResmi();
    }
}
