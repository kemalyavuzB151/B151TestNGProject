package techproed.tests.day25_POM;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

import javax.swing.*;

public class C03_ProperiesKullanimi {
    @Test
    public void amazonTest() {
        //amazon sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("amazonUrl"));

        //Başliğin amazon içerdiğini test edelim
        String actualTitle= Driver.getDriver().getTitle();
        String expectedTitle = ConfigReader.getProperty("expectedTitle");
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        //Arama kutusunda iphone aratalım
        Driver.getDriver().findElement(By.id("twotabsearchtextbox")).sendKeys(ConfigReader.getProperty("searchText"), Keys.ENTER);

        //Sayfayı kapatalım
        Driver.closeDriver();

        //google sayfasına gidelim
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));

        //sayfayı kapatalım
        Driver.closeDriver();

        //facebook sayfasına gidiniz
        Driver.getDriver().get("https://www.facebook.com");
    }
}
