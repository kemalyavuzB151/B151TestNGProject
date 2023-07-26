package techproed.tests.day23_Annotation;

import org.testng.annotations.*;

public class C01_Annotation {

    @BeforeSuite
    public void suite() {
        System.out.println("Her şeyden önce 1 kez BeforeSuite calisir.");
    }

    @BeforeTest
    public void beforeTest() {
        System.out.println("Testlerden önce 1 kez BeforeTest calisir.");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Her class'tan önce  1 kez BeforeClass calisir.");
    }

    @BeforeMethod
    public void setUp() {
        System.out.println("JUnitteki @Before notasyonu gibi her methottan önce 1 kez BeforeMethod calisir.");
    }

    @Test
    public void test01() {

        System.out.println("Test1 calisti.");
    }

    @Test
    public void test02() {

        System.out.println("Test2 calisti.");
    }

    @Test
    public void test03() {

        System.out.println("Test3 calisti.");
    }

    @AfterSuite
    public void afterSuite() {

        System.out.println("Her şeyden sonra 1 kez AfterSuite calisir.");
    }

    @AfterTest
    public void afterTest() {

        System.out.println("Testlerden sonra 1 kez AfterTest calisir.");
    }

    @AfterClass
    public void afterClass() {

        System.out.println("Her class'tan sonra 1 kez AfterClass calisir.");
    }

    @AfterMethod
    public void tearDown() {
        System.out.println("JUnitteki @After notasyonu gibi her methottan sonra AfterMethod calisir.");
    }
}
