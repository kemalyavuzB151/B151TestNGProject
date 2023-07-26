package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentAlCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C01_NegatifTest {
    @Test(groups = "smoke")
    public void test01() {
        //Description:
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        //Acceptance Criteria
        //Customer email: fake@bluerentalcars.com
        //Customer password: fakepass
        //Error:
        //User with email fake@bluerentalcars.com not found
        //-----------------------------------------------//
        //BlueRental Sayfasına gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsuRL"));
        //Login butonuna tiklayiniz.
        BlueRentAlCarsPage blueRentAlCarsPage = new BlueRentAlCarsPage();
        blueRentAlCarsPage.loginButton.click();
        ReusableMethods.bekle(2);
        //Kullanimda olmayan kullanıcı adi ve şifre ile giriş yapilamamali
        blueRentAlCarsPage.eMail.sendKeys(ConfigReader.getProperty("fakeEmail"),
                Keys.TAB, ConfigReader.getProperty("fakePassword"), Keys.ENTER);
        ReusableMethods.visibleWait(blueRentAlCarsPage.mesajVerify, 5);
        Assert.assertTrue(blueRentAlCarsPage.mesajVerify.isDisplayed());
        //Sayfayi kapatiniz.
        Driver.closeDriver();

    }
}
