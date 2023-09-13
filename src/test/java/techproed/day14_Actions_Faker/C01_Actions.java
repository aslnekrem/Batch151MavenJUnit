package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C01_Actions extends TestBase {


    @Test
    public void test01() {
        //techpro sayfasina gidelim
        //sayfanin altina dogru gidelim
        //sayfanin üstüne dogru gidelim

        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_UP,Keys.ARROW_DOWN,Keys.ARROW_UP).perform();
        //Keys.ARROW_DOWN ile Keys.PAGE_DOWN ayni islemi yapiyor
        //actions.sendKeys(Keys.PAGE_DOWN,Keys.PAGE_UP).sendKeys(Keys.ARROW_DOWN,Keys.ARROW_UP).perform();
        //yukaridaki gibi ayri ayri da send Keys kullanabilirsin
        bekle(3);


    }

    @Test
    public void test02() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın en altına scroll yapalım
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.END);

        //sayfanın en üstüne scroll yapalım
        actions.sendKeys(Keys.HOME).build().perform();
        //build() --> methodu action'ları birleştirmek için kullanılan methoddur.Birden fazla oluşturduğumuz action
        //objesini birbirine bağlar
        //release() -> methodu mouse'u serbest birakir
        //Eger yapilan islemin cok hizli olmasini istemiyorsak build() kullanmak yerine her action'dan sonra perform() kullanmamiz gerekir.
        /*
        her actions dan sonra perform kullanmazsak olay cok seri gerceklesir.
        build kullandigimizda olay milisaniye icinde gerceklesir.
        araya bekle methodu koysak bile java build methodunun oldugu kisimda sayfayi asagi yaparak hizli sekilde gerceklestirir

        release() methodu kutuyu bir yerrden sürükleme veya eslestirme gibi konulari yaparken
        mouseyi cekip birakmali sorularda release() methodu kullanilir
        actionsta mouseta sürükleme islemi yapiyorsak serbest birakma islemi icin release() methodu kullanilir.
         */
    }

    @Test
    public void test03() {
        //techpro sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']")).click();
        bekle(2);
        //sayfanın altına doğru gidelim
        Actions actions = new Actions(driver);
        actions.scrollByAmount(0,1500).perform();

        //sayfanın üstüne doğru gidelim
        actions.scrollByAmount(0,-1500).perform();


    }
}
