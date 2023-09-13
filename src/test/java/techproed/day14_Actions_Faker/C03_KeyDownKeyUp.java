package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.v85.indexeddb.model.Key;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test01() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("//button[@id='W0wltc']")).click();

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//--> Arama Kutusunda shift tuşuna bastık
                sendKeys("selenium").//-->selenium metnini shift tuşuna basılı kaldığı için büyük yazdı
                keyUp(Keys.SHIFT).//--> shift tusunu serbest bıraktık
                sendKeys("-java",Keys.ENTER).//--> bu kismi shift'i serbest bıraktığımız için küçük yazdı
                perform();
        bekle(3);

    }

    @Test
    public void test02(){
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("//button[@id='W0wltc']")).click();

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT," / java",Keys.ENTER);
        /*sendKeys'de + ile , arasinda fark yok ikisi de ayni ciktiyi verdi
        aramaKutusu.sendKeys(Keys.SHIFT+"java");
        aramaKutusu.sendKeys(Keys.SHIFT,"java");
         */
        
        /*
        Mouse islemleri icin actions class'ini kullanmamiz gerekir. Fakat bir metin kutusundaki klavye islemleri icin 
        actions class'ini kullanmadan sendKeys() methodu ile de istedigimiz bir metni büyük yazdirabilir, hatta
        birden fazla klavye tuslarina bastirabiliriz. Yukaridaki örnekte sendKEys() methodu ile Keys.SHIFT diyerek 
        sonrasinda yazdirmak istedigimiz metni kücük harfle yazmamiza ragmen büyük harflerle yazdirdi, tekrar KEYS.SHIFT
        kullanarak shift tusunu serbest birakmis olduk.
         */
        bekle(5);
        
        /*
         NOTE : Genelde mause harketlerinde "action" kullanirsin. Klavye hareketlerinde cok gerek yok !!!!!
         */

    }

    @Test
    public void test03() {
        //google sayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("//button[@id='W0wltc']")).click();
        //Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("Selenium");
        aramaKutusu.submit();//ENTER bazen sorun cikariyor mesela burada cikardi bu yüzden submit kullandik
        //aramaKutusu.sendKeys(Keys.RETURN); Bu da Keys.ENTER yerine gecer

        //Sayfayı bekleyin
        bekle(4);

        //Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        bekle(2);
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//-->Seçilen metni ctrl+x ile kestik
        bekle(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"v",Keys.ENTER);//-->Kestiğimiz metni ctrl+v tusu ile tekrar arama kutusuna yapıştırdık ve arattık
    }
}
