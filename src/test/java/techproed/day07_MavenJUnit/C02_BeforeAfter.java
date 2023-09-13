package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
         /*
        Notasyonlara sahip methodlar olusturabilmek icin mouse+sag tik +generate(kisayol alt + insert) yaparak
        after methodu icin teardown'u seceriz.
        before methodu icin setup'i seceriz.
        test methodu icin de test'i seceriz
            Junit framework'ünde testlerimizi siralama yapabilmek icin ekstra bir nostasyon yoktur
            Eger belirli bir siralamada calistirmak istersek method isimlerini alfabetik ve sayisal olarak belirtmemiz
            gerekir(Natural Order).
        */
    @After
    public void tearDown(){ //After method'u, sadece ismi tearDown
        System.out.println("Her test methodundan sonra bir kez calisir");
    }

    //Iki defa Before beya After method yapmak tavsiye edilmez ve cok ender rastlanir zaten varsayilan Alt+Insert'de de
    //ikinci kez cikmiyor. Fakat istersek elle de yazabiliriz daha fazla


    @Before
    public void setUp() { //Before methodu bu sadece ismi setUp
        System.out.println("Her Test methodundan önce bir kez calisir");
    }


    @Test
    public void test1() {
        System.out.println("Test 1 methodu calisti");
    }

    @Test
    public void test2() {
        System.out.println("Test 2 methodu calisti");
    }

    @Test
    public void test3() {
        System.out.println("Test 3 methodu calisti");
    }
}
