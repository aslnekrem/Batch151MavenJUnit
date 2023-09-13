package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;
import org.openqa.selenium.interactions.Actions;

public class C04_Faker {
    @Test
    public void faker() {
        /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
         */
        Faker faker = new Faker();


        //faker objesini kullanarak bir isim yazdiralim
        System.out.println("Isim : "+faker.name().firstName());

        //faker objesini kullanarak bir lastName yazdiralim
        System.out.println("Soyisim : "+faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdiralim
        System.out.println("Isim_Soyisim : " +faker.name().fullName());

        //faker objesini kullanarak bir adress yazdiralim
        System.out.println("Adres : "+faker.address());

        //faker objesini kullanarak bir tel_no yazdiralim
        System.out.println("Cep_No : " +faker.phoneNumber().cellPhone());
        System.out.println("Tel_No : " +faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdiralim
        System.out.println("Rastgele 15 haneli bir numara : "+faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println(faker.job().position());


    }
}
