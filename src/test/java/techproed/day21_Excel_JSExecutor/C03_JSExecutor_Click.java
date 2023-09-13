package techproed.day21_Excel_JSExecutor;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_JSExecutor_Click extends TestBase {
    /*
    Bir web sayfasinda bazi webelementler olusturulurken JAVASCRIPT kodlariyla olusturulmus olabilir.
    Bu webelementleri handle edebilmek icin JavaScriptExecutor arayüzünü kullanmamiz gerekir.
    Bir webelement JavaScript kodlari ile yazilmamis olsada JavaScriptExecutor ile o webelementi handle edebiliriz.
     Normal bildigimiz methodlardan daha yavas calisacagi icin bildigimiz methodlar isimizi görüyorsa onlari kullaniriz.
    <script> tagi ile olusturdugumuz webelementleri de js executor ile handle edebiliriz
     */

    @Test
    public void test01() {
    //Amazon sayfasina gidiniz
        driver.get("https://amazon.com");
        bekle(2);

    //Sell linkinin resmini alalim
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);


    //Sell linkine js executor kullanarak tiklayiniz
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].click();",sellLinki);
        /*
        arguments[0] --> bu kodun yanindakiler argüment oluyor koseli parantez icindeki 0'da index'i belirtiyor
        yani yukaridaki kodda arguments[0] = sellLinki olmus oluyor. Yanina click dedigimizde.de ona tikla dedik.
        argument[..] yaninda birden fazla webElement olabilir mesela selllinki diger linkler gibi vs, o zaman hangisinde
        islem yapmak istersek parantez icine onun index'ini yazariz. Ornegin;
        js.executeScript("arguments[2].click();",sellLinki,cardLinki,angebotLinki); --> angebotLinki'ni click yapariz mesela
         */

    //Basligin sell icerdigini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

    //Sayfanin resmini alalim
        tumSayfaResmi();


    }

    @Test
    public void test02() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");

        bekle(2);
        //sell linkinin resmini alalım
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        webElementResmi(sellLinki);

        //Sell linkine tıklayınız
        sellLinki.click(); //Önünde reklam oldugu icin tilayamiyor bu yüzden hata aliyoruz
        /*
        JS executer ile Webelementin önünde uyari cikmasina ragmen webelemente click yapti cünkü kodlara direkt ulasiyor.
        Normal kullandigimiz click methodu burda önünde farkli bir element oldugu icin ElementClickInterceptedException
        hatasi verdi. Dolayasiyla bu exception ile karsilastigimizda executor ile bunu cözebiliriz.
         */

        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));

        //Sayfanın resmini alalım
        tumSayfaResmi();
    }

    @Test
    public void test03() {
        //Amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        bekle(2);
        //sell linkinin resmini alalım
        //driver.findElement(By.xpath("(//*[@class='a-button-inner'])[1]")).click();//-->uyarı kapatıldı
        WebElement sellLinki = driver.findElement(By.xpath("//*[.='Sell']"));
        bekle(2);
        webElementResmi(sellLinki);
        //Sell linkine js executor kullanarak tıklayınız
        click(sellLinki);//-->Click methodu ile normal click yapmayı denedi fakat olmadı js excutor ile click yaptı
        //Başlığın Sell içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("Sell"));
        //Sayfanın resmini alalım
        tumSayfaResmi();
    }
}
/*
ODEV --)
    sayfaya gidin cerezi kapatin
    https://www.mercedes-benz.com.tr/?group=all&subgroup=see-all&view=BODYTYPE
     */