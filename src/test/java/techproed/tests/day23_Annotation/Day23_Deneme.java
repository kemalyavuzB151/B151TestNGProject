package techproed.tests.day23_Annotation;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeGroups;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.time.Duration;

public class Day23_Deneme {
    WebDriver driver;
    @BeforeSuite
    public void beforeSuit(){
        System.out.println("En başta @beforeSuite çalışır");
    }
    @BeforeGroups({"kemal","yavuz"})
    public void beforeGroups(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


    }

    @Test(groups = "kemal")
    public void test01() {
        String amazonUrl ="https://amazon.com";
        driver.get(amazonUrl);
    }

    @Test(groups = "kemal")
    public void test02() {
        String yotubeUrl ="https://youtube.com";
        driver.get(yotubeUrl);
    }

    @Test(groups = "yavuz")
    public void test03() {
        String facebook ="https://facebook.com";
        driver.get(facebook);
    }
}
