package techproed.tests.day24_Priority_DependsOnMethods_SoftAssert;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.*;

import java.time.Duration;

public class C01_Priority {
    /*
    JUnitte test methodlarini istediğimiz şekilde sıralamak için method isimlerini alfabetik ve numerik
    sıralı olarak yazmamız gerekiyordu. TestNG framework'ünde bu sıralama için @Test notasyonundan sonra
    parametre olarak (priority = 1 ) gibi öncelik sırası belirterek test methodlarimizi sıralayabiliriz.
    Priority kullanmadığımız methotta priority değeri 0 (sıfır) olarak kabul eder.
     */
    WebDriver driver;

    @BeforeMethod
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @Test(priority = 1)
    public void amazonTest() {

        driver.get("https://amazon.com");   // --> 2. olarak amazon calissin.
    }

    @Test
    public void youtTubeTest() {

        driver.get("https://youtube.com");  // --> ilk önce youtube calissin.
    }

    @Test(priority = 2)
    public void facebookTest() {
        driver.get("https://facebook.com"); // --> Son olarak facebook calissin.
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

    //@AfterTest                      // --> Testlerden sonra 1 kez AfterTest calisir. Yani son acilan
    //public void afterTest() {       //     facebook'u kapatır sadece.
    //    driver.close();
    //}

    // @AfterClass                   Her class'tan sonra 1 kez AfterClass calisir.
    // public void afterClass(){
    //     driver.close();
    // }
}
