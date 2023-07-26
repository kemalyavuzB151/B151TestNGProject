package techproed.tests.day26_PageKullanimi;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentAlCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_PozitifTest {
    @Test(groups = "smoke")
    public void test01() {
        //Acceptance Criteria:
        //Admin olarak, uygulamaya giriş yapabilmeliyim
        //https://www.bluerentalcars.com/
        //Admin email: jack@gmail.com
        //Admin password: 12345
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsuRL"));


        BlueRentAlCarsPage blueRentAlCarsPage = new BlueRentAlCarsPage();
        blueRentAlCarsPage.loginButton.click();
        ReusableMethods.bekle(2);
        blueRentAlCarsPage.eMail.sendKeys(ConfigReader.getProperty("adminEmail"),
                Keys.TAB, ConfigReader.getProperty("adminPassword"), Keys.ENTER);
        ReusableMethods.bekle(2);
        //Giriş yapıldığını test edelim.
        Assert.assertTrue(blueRentAlCarsPage.girisYapildiVerify.getText().contains("Jack"));

        //Sayfayı kapatalım.
        Driver.closeDriver();

    }
}
