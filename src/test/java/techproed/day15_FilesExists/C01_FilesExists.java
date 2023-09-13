package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C01_FilesExists {


    @Test
    public void test01() {
        /*
    Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
    kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
    için;
        Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
    dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
    Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
    assing ederiz.
 */

        String dosyaYolu = "C:/Users/aslne/OneDrive/Masaüstü/seleniumday15.txt/";
        //Yukarida \'lari -> /'na cevirdik
        System.out.println(Files.exists(Paths.get(dosyaYolu)));//Dosya varsa True yoksa False döner
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));



    }

    @Test
    public void test02() {
        String dosyaYolu2 = "C:\\Users\\aslne\\OneDrive\\Masaüstü\\seleniumday15.txt";
        //Bu sekilde de bastaki ve sonraki \'lari silerek de kabul ediyor. Masaüstünde eski sürümlerde ve benimkinde
        // Shift'e basili tutup sag click and after Copy Path yaptiyoruz. Orjinali -> "C:\Users\aslne\OneDrive\Masaüstü\seleniumday15.txt"
        //Yukarida \'lari -> /'na cevirdik
        //--> "C" den once ve en sondaki çift tırnaktan önce /" olmayacak
        System.out.println(Files.exists(Paths.get(dosyaYolu2)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu2)));
    }

    @Test
    public void test03() throws InterruptedException {
        /*
        Bir server'da farkli isletim sistemleri ile ayni anda dosya varligini test etmek istedigimiz zaman, daha dinamik
        olmasi acisindan System.getProoerty("os.name") bu sekilde isletim sistemini alir
        her isletim sisteminin kullanici yolu farkli olacagindan System.getProoerty("user.home") bilgisayarimizdaki
        kullanici yolunu bu sekilde alip String bir degiskene farkliYol ismi ile System.getProoerty("user.home") atayarak
        her seferinde farkli yollari almayla ugrasmamiz oluruz. Dosya diyelim ki masa ustunde ve her isletim sisteminde
        bize ayni yolu verecegi icin bunu da ortak yol olarak bir String'e assing ederiz

         */



        String dosyaYoluIcindeBulundugum = System.getProperty("user.dir"); //Icinde bulundugumuz dosyanin yolunu veriyor
        System.out.println("Icinde bulundugum dosyanin yolu" + dosyaYoluIcindeBulundugum);

        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println("isletimSistemiAdi = " + isletimSistemiAdi);

        String kullaniciYolu = System.getProperty("user.home");//-->Bilgisayarımızdaki kullanıcı yolunu verir
        System.out.println("kullaniciYolu = " + kullaniciYolu);
        if (isletimSistemiAdi.contains("Win")){
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        }else if (isletimSistemiAdi.contains("mac")){
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/OneDrive/Masaüstü/seleniumday15.txt";
        String dosyaYolu = farkliYol+ortakYol;// dosya yolu olarak farklı kısım ve ortak kısımı aldık

        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Thread.sleep(5);

        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        //"C:\\Users\\aslne\\OneDrive\\Masaüstü\\seleniumday15.txt"



        try {
            Files.delete(Paths.get(dosyaYolu));//Bu sekilde belirtmis oldugumuz dosyayi sileriz
        } catch (IOException e) {
            System.out.println("Dosya bulunamadi");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));
        /*
        Her seferinde test ettigimiz sayfada download islemi yapiliyorsa gereksiz dosya kalabaligini onlemek icin
        yukardaki delete islemini kullanabiliriz
        */

        /*
        Asagidakinin yerine dosya olusturmayi ben yukarida yaptim cünkü masaüstünde yer kaplamasin diye
        Önce olusturup sonra siliyor

        //Sildigimiz dosya isminde yeni bir dosya olusturalim
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

         */

    }

    @Test
    public void test04() {
        /*
        Yukaridaki methodlarda bilgisayarimizdaki dosyaYolu'nun varligini Files.exist() methodu ile test etmistik
        Ayni islemi asagidaki örnekteki gibi File class'indan obje olusturarak da yapabiliriz
         */
        String dosyaYolu = "C:\\Users\\aslne\\OneDrive\\Masaüstü\\seleniumday15.txt";
        File file = new File(dosyaYolu);
        System.out.println(new File(dosyaYolu).exists());
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
        file.delete();
    }
}
