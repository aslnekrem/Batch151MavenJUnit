package techproed.day18_ScreenShot;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class C01_TumSayfaResmi extends TestBase {
    /*
    SCREENSHOT
         Selenium da tüm ekran görüntüsünü alabilmek için TakesScreenShot arayüzünden  bir obje oluşturup
        drivera eşitleriz.Arayüzler farklı olduğu için casting yaparız.ve bu oluşturduğumuz obje ile
        getScreenShotAs methodu ile sayfanın resmini alırız.Almış olduğumuz resmi  projemizde nereye kaydedeceksek
        oranın yolunu belirtiriz.
     */
    @Test
    public void test01() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://www.techproeducation.com");
        bekle(2);

        //çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //ekran görüntüsünü alalım
        /*
       - İlk olarak SS alacağımız da nereye kaydetmek istiyorsak oranın yolunu belirtelim.
        -İkinci olarak TakesScreenShot arayüzünden obje oluşturuz
        -Üçüncü olarak FileUtils classından copyFile() methodu ile ts opjemizi kullanarak getScreenShotAs methodu ile
        dosya yolunu belirteceğiz.
         */
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot.png";//ssleri aldığımızda kaydedecek bir pacgage açtık onun yolunu aldık
        //ayiraca son kisi screenShot.png kismini biz ekledik, dosya adi olarak
        TakesScreenshot ts = (TakesScreenshot) driver;//altı kızardı soldakine tıkladık parantez içini verdi.cast to dedik
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        //Okuma yazma islemlerinde kullandigimiz FileUtils class'ini kullandik

    }

    @Test
    public void test02() throws IOException {
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File("techproed/ScreenShot/screenShot.png"));
        //ScreenShot/screenShot.png --> bunu biz kendimiz yazdik. Yani dosyayolunu kendimiz olusturduk ve onun icine atadi
        //techproed/ScreenShot/screenShot.png --> böyle yazsaydik da techproed dosyasinin altinda olusturacakti
    }

    @Test
    public void test03() throws IOException {
    /*
    Kaydettiğimiz ekran resmini her seferinde aynı dosya üzerine yazmaması için dosya isminden sonra
    String bir değişkene tarih formatı atayabiliriz.
     */
        //Techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");

        bekle(2);
        //Çıkan reklamı kapatalım
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        //Ve ekran görüntüsünü alalım
    /*
    SimpleDateFormat'ı kullanarak yeni bir tarih formatı oluşturup bir String'e assing ederiz.
    Ve bunu dosya isminden önce belirtiriz.
     */
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
    @Test
    public void test04() throws IOException {
        //amazon sayfasına gidelim
        driver.get("https://amazon.com");

        bekle(2);

        //Ve ekran görüntüsünü alalım

        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
    }
}
