package techproed.tests.day26_PageKullanimi;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.OpenSourcePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class C01_PageKullanimi {
    @Test
    public void test01() {
        //https://opensource-demo.orangehrmlive.com/web/index.php/auth/login adrese gidelim
        Driver.getDriver().get(ConfigReader.getProperty("opensourceUrl"));
        //Username : Admin
        //Password : admin123


        //kullaniciAdi, kullaniciSifre, submitButton elementlerini locate edelim
        OpenSourcePage openSourcePage = new OpenSourcePage();
        openSourcePage.username.sendKeys(ConfigReader.getProperty("opensourceUsername"));
        openSourcePage.password.sendKeys(ConfigReader.getProperty("opensourcePassword"));
        openSourcePage.submitButton.click();
        //Login Testinin basarili oldugunu test et
        Assert.assertTrue(openSourcePage.verify.isDisplayed());
        //Sayfayı kapatınız
        Driver.closeDriver();
    }
}
