package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C02_Dropdown {
    /*
    Dropdown --> Altbasliklarin oldugu acilir menu listesidir.
    Dropdown'u handle(automate) etmek icin
        1-Dropdown menüyü ilk olarak locate ederiz
        2-Select objesi olustururuz
        3-Select objesinin dropdownmenü webelementinin icerigine ve seceneklerine erisim saglamasi icin
            SELECT class'ina argüman olarak locate ettigimiz webelementi koyariz.
            SYNTAX:
                Select select = new Select(ddm webelementi);
        4-Select class'i sadece <select> tag'i ile olusturulmus dropdown menülere uygulanabilir
        5-select objesi ddm'yü handle edebilmek icin 3 method kullanir
            1- selectByVisibleText() -> ddm(Dropdownmenü)'deki elemente görünür metin ile ulasmak icin kullanilir
            2- selectByIndex() -> index ile ulasmak icin kullanilir(index 0(sifir)'dan baslar)
            3- selectByValue() -> Elementin degeri ile ulasmak icin kullanilir(option tag'larindaki value ile)
        6-getOptions() -> Locate ettigimiz ddm'deki tüm secenekleri bize verir.(List'e atip loop ile yazdirabiliriz)
        7- getFirstSelectedOption() ->ddm'deki secili kalan secenegi bize verir. Birden fazla secenek secildiyse, bu
            secilenlerin ilkini verir.
        8-Dddm'ye sendKeys() methodu ile de ddm'deki seneklerden birini kullanarak gönderebiliriz
            //istersek sendKeys() ile de secebiliriz example-> gun.sendKeys("18");
     */

    /*
    Given kullanici https://testcenter.techproeducation.com/index.php?page=dropdown sayfasindayken
    -3 farklı test methodu oluşturalım
        1.Method:
            a. Yil,ay,gün dropdown menu'leri locate ediniz
            b. Select objesi olustur
            c. Select object i kullanarak 3 farkli sekilde secim yapiniz
        2.Method:
            a. Tüm eyalet isimlerini yazdıralım
        3.Method:
            a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify edelim

     */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
        //1.Method:
        //            a. Yil,ay,gün dropdown menu'leri locate ediniz
        WebElement yil = driver.findElement(By.xpath("(//select)[2]"));
        WebElement ay = driver.findElement(By.xpath("(//select)[3]"));
        WebElement gun = driver.findElement(By.xpath("(//select)[4]"));

        //            b. Select objesi olustur
        Select select = new Select(yil);

        //            c. Select object i kullaarak 3 farkli sekilde secim yapiniz
        select.selectByIndex(5);//index 0'dan başlar 2018'i seçer

        Select select1 = new Select(ay);
        select1.selectByValue("6");//July -> option tag'ındaki value attribute değerini aldık

        Select select2 = new Select(gun);
        select2.selectByVisibleText("15");


    }

    @Test
    public void test02() {
        //a. Tüm eyalet isimlerini yazdıralım (Select ile)
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        //select.getOptions().forEach(w-> System.out.println(w.getText())); -->Lambda ile
        List<WebElement> eyaletlerList = select.getOptions();
        for (WebElement w:eyaletlerList) {
            System.out.println(w.getText());
        }
        //getOptions() methodu ile tüm seçenekleri yazdırdık

        //2. yol
        /*
        System.out.println("****************************************************************");
        List<WebElement> eyaletlerr = driver.findElements(By.xpath("(//select)[5]"));
        eyaletlerr.forEach(w-> System.out.println(w.getText()));
         */
    }

    @Test
    public void test03() {
        // a. State dropdownindaki varsayilan secili secenegin 'Select a State' oldugunu verify(Assert) edelim
        WebElement eyaletler = driver.findElement(By.xpath("(//select)[5]"));
        Select select = new Select(eyaletler);
        String seciliOlanSecenek = select.getFirstSelectedOption().getText();
        System.out.println(seciliOlanSecenek);
        Assert.assertEquals("Select a State",seciliOlanSecenek);
        Assert.assertTrue(seciliOlanSecenek.contains("Select"));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}
