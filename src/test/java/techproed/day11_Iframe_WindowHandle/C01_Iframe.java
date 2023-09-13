package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_Iframe extends TestBase {

    /*
    Bir HTML dokumaninin icine yerlestirilmis baska bir HTML dokumanina inline frame yani IFRAME denir
    Bir sayfada iframe varsa iframe icindeki webelementi handle edebilmek icin switchTo() methodu ile iframe'e gecis yapmamiz
    gerekir.Eger gecis yapmazsak nosuchelementexception aliriz.
    Alert'ten farki alert ciktiginda hicbir webelementi locate edemeyiz. iframe olsada locate ederiz fakat handler edemeyiz
    */



    //➢ https://testcenter.techproeducation.com/index.php?page=iframe
    //➢ Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
    //➢ Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
    //➢ Son olarak footer daki 'Povered By' yazisini varligini test edilip


    @Test
    public void iframe() {
        //➢ https://testcenter.techproeducation.com/index.php?page=iframe
        driver.get("https://testcenter.techproeducation.com/index.php?page=iframe");

        //➢ Ana sayfadaki 'An iframe with a thin black border:' metninde 'black border' yazisinin   oldugunu test edelim
        String metin = driver.findElement(By.xpath("(//p)[1]")).getText();
        System.out.println(metin);
        Assert.assertTrue(metin.contains("black border"));

        //➢ Ayrica 'Applications lists' yazisinin sayfada oldugunu test edelim
        driver.switchTo().frame(0);
        String applicationsListyazisi = driver.findElement(By.xpath("//h1")).getText();
        System.out.println(applicationsListyazisi);
        Assert.assertEquals("Applications lists",applicationsListyazisi);


        //➢ Son olarak sayfa basligindaki iframe yazisinin görünür oldugunu test edin
        //Bir üstteki iframe'me gecis yaptik, istersek driver'i refresh yaparak da veya parentframe dersek de ana
        // sayfaya gecer
        //driver.get(driver.getCurrentUrl());
        //driver.switchTo().parentFrame();
        //driver.navigate().refresh();
        //Usttekilerin hepsi iframe'den ana sayfaya donmek icin kullanilir
        //defaultContent-> anasayfaya,  parentFrame -> bir üst frame'e gecer

        driver.switchTo().defaultContent();
        //driver.get(driver.getCurrentUrl()); bu da sayfayi refresh yapar. gecerli URL'ye git dedigi icin refresh gibi
        WebElement iframeYazisi = driver.findElement(By.xpath("//h3"));
        Assert.assertTrue(iframeYazisi.isDisplayed());

        /*
            Eğer iki tane iframe olsaydı ve 2. frame'e geçmek isteseydik index'i 1 almam gerekicekti
        <body>
	            <iframe id="outerIframe" src="https://www.w3schools.com"> --> driver.switchTo().frame("outerIframe")
		            <iframe id="innerIframe" src="https://www.google.com"></iframe> --> bu örnekte parentFrame ile bir üst frame geçiş yapabiliriz
	            </iframe>
            </body>

          İstersek WebElement frame = driver.findElement(By.xpath("//*[@id='outerIframe'")) bu şekilde locate ettiğimiz
        iframe'e driver.switchTo().frame(frame) geçiş yapabiliriz.
         */


        /*Nested iframe' lerde defaultContent ile refresh hangi iframe' de olursa olsun direk anasayfaya gecerken
        parentFrame sadece bir ust frame' e gecer
         */



        bekle(3);
    }
}
