package techproed.day08_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her Class'dan sonra @AfterClass method'u bir kez calisir");
    }

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her Class'dan önce BeforeClass Method'u bir kez calisir");
    }

    @Before
    public void setUp() throws Exception{
        System.out.println("Her method'dan önce Before method'u bir kez calisir");
    }

    @Test
    public void test01() {
        System.out.println("Test01 method'u calisti");
    }

    @Test
    public void test02() {
        System.out.println("Test02 method'u calisti");
    }

    @Test
    public void test03() {
        System.out.println("Test03 method'u calisti");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method'dan sonra @After(tearDown) method'u bir kez calisir");
    }
}
