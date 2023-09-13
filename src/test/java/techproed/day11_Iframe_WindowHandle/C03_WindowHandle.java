package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

import java.util.Set;

public class C03_WindowHandle extends TestBase {

    //Window 1'de https://www.techproeducation.com adresine gidiniz
    //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
    //Window 2'de(yeni pencere) https://www.youtube.com sayfasını açınız:
    //Window 3'te(yeni bir pencere) https://www.linkedin.com sayfasını açınız:
    //techproeducation sayfasına geçiniz:
    //youtube sayfasına geçiniz:
    //linkedIn sayfasına geçiniz:






    @Test
    public void windowHandle() {
        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproeducationHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actual = driver.getTitle();
        String expected = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expected,actual);

        //Window 2'de(yeni Pencere) https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.WINDOW); //-> Yeni bir pencereye driver'i tasir
        //WindowType.TAB -> WINDOW yerine TAB dersek yeni sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te(yeni bir pencere) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.WINDOW);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproeducationHandle);
        bekle(5);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(5);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

        bekle(5);



    }

    @Test
    public void test02() {

        //Asagidaki örnek yukaridakinin TAB ile olani. Kopyala yapistir yaptik. Notlar aklini karistirmasin..

        //Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproeducationHandle = driver.getWindowHandle();

        //Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actual = driver.getTitle();
        String expected = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expected,actual);

        //Window 2'de(yeni Pencere) https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.TAB); //-> Yeni bir pencereye driver'i tasir
        //WindowType.TAB -> WINDOW yerine TAB dersek yeni sekme acar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandle = driver.getWindowHandle();

        //Window 3'te(yeni bir pencere) https://www.linkedin.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.TAB);
        driver.get("https://www.linkedin.com");
        String linkedinWindowHandle = driver.getWindowHandle();

        //techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproeducationHandle);
        bekle(5);

        //youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandle);
        bekle(5);

        //linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandle);

        bekle(5);
    }
}
