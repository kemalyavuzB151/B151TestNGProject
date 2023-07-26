package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentAlCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C04_DataProviderConfigReaderTest {


        /*
        DataProvider kullanarak .properties dosyasindaki veriler ile BlueRentalCar sitesine login olalim
        */

    @DataProvider
    public static Object[][] login() {
        return new Object[][]{{ConfigReader.getProperty("mail1"), ConfigReader.getProperty("sifre1")},
                {ConfigReader.getProperty("mail2"), ConfigReader.getProperty("sifre2")},
                {ConfigReader.getProperty("mail3"), ConfigReader.getProperty("sifre3")},
                {ConfigReader.getProperty("mail4"), ConfigReader.getProperty("sifre4")}
        };
    }

    @Test(dataProvider = "login")
    public void test01(String mail, String password) {
        //BlueRentalCar sitesine gidelim.
        //DataProvider'daki mail ve password bilgileri ile login olalım.
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsuRL"));
        BlueRentAlCarsPage blueRentAlCarsPage = new BlueRentAlCarsPage();
        blueRentAlCarsPage.loginButton.click();
        blueRentAlCarsPage.eMail.sendKeys(mail, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.bekle(2);
        Driver.closeDriver();
    }
}
