package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentAlCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C03_DataProviderTest {
    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{{"sam.walker@bluerentalcars.com", "c!fas_art"},
                {"kate.brown@bluerentalcars.com", "tad1$Fas"},
                {"raj.khan@bluerentalcars.com", "v7Hg_va^"},
                {"pam.raymond@bluerentalcars.com", "Nga^g6!"}};
    }

    @Test(dataProvider = "blueRental")
    public void test01(String mail, String password) {
        //BlueRentalCar sitesine gidelim.
        //DataProvider'daki mail ve password bilgileri ile login olalım.
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsuRL"));
        BlueRentAlCarsPage blueRentAlCarsPage = new BlueRentAlCarsPage();
        blueRentAlCarsPage.loginButton.click();
        blueRentAlCarsPage.eMail.sendKeys(mail, Keys.TAB, password,Keys.ENTER);
        ReusableMethods.bekle(3);
        //Tüm sayfa resimlerini alalım.
        ReusableMethods.tumSayfaResmi();
        //Sayfayı kapatalım.
        Driver.closeDriver();
    }
}
