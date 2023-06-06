package techproed.day08_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_CheckBoxClassWork {
    /*
     a.Verilen web sayfasına gidin.
     https://the-internet.herokuapp.com/checkboxes
     b.Checkbox1 ve checkbox2 elementlerini locate edin.
     c.Checkbox1 seçili değilse onay kutusunu tıklayın
     d.Checkbox2 seçili değilse onay kutusunu tıklayın
      */

    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://the-internet.herokuapp.com/checkboxes");
    }

    @Test
    public void checkBox() throws InterruptedException {
        //b.Checkbox1 ve checkbox2 elementlerini locate edin.
        WebElement checkBox1 = driver.findElement(By.xpath("(//input)[1]"));
        WebElement checkBox2 = driver.findElement(By.xpath("(//input)[2]"));


        if (!checkBox1.isSelected()){ //secili degilse
            checkBox1.click(); //checkBox'i click yap
        }
        Thread.sleep(2000);
        if (!checkBox2.isSelected()){
            checkBox2.click();//checkbox'i click yap

        }
    }//@Test checkBox

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}