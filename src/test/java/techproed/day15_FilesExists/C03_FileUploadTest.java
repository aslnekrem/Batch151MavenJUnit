package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUploadTest extends TestBase {
    @Test
    public void test01() {

        /*
        Eger dosyaSec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde exception
        aliyorsak, direkt Upload istedigimiz dosyayolunu alip sendKeys methodu ile dosyayi sayfaya Upload yapabiliriz
         Eger upload ya da dosya sec butonuna tikladiginizda windows penceresi aciliyorsa, o webelemente sendKeys()
         methodu ile dosya gönderemeyebilirsiniz. Eger böyle bir durumla karsilasirsaniz Robot class'indan obje ile
         methodlar kullanarak bunu asabilirsiniz.

         Selenium ile windows'a müdahale edemiyoruz(dosya sec deyince windows penceresi aciliyor) bu yüzden
         Robot class veya sendKeys() kullaniyoruz.
         */

        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //Dosya Sec butonuna basalim        <<< -- >>>  //Yuklemek istediginiz dosyayi secelim.
        String dosyaYolu = "C:\\Users\\aslne\\Downloads\\b10 all test cases, code (1).docx";
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@id='file-upload']"));
        dosyaSec.sendKeys(dosyaYolu);
        //dosyaSec.click();

        //Upload butonuna basalim.
        driver.findElement(By.id("file-submit")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim
        WebElement fileUpload = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(fileUpload.isDisplayed());
    }
}
