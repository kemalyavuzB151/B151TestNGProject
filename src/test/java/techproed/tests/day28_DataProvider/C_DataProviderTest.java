package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.BlueRentAlCarsPage;
import techproed.pages.BlueRentalPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C_DataProviderTest {
    @DataProvider
    public static Object[][] blueRental() {
        return new Object[][]{{"sam.walker@bluerentalcars.com","c!fas_art\n"},
                {"kate.brown@bluerentalcars.com\n","tad1$Fas\n"},
                {"raj.khan@bluerentalcars.com\n","v7Hg_va^\n"},
                {"pam.raymond@bluerentalcars.com\n","Nga^g6!\n"}};
    }

    @Test(dataProvider = "blueRental")
    public void test01(String mail,String password) {
        //BlueRentalCar sitesine gidelim
        Driver.getDriver().get(ConfigReader.getProperty("blueRentalUrl"));
        //DataProvider'daki mail ve password bilgileri ile login olalım
        BlueRentAlCarsPage rentalPage= new BlueRentAlCarsPage();
        rentalPage.login.click
        ReusableMethods.bekle(2);
        rentalPage.email.sendKeys(mail, Keys.TAB,password,Keys.ENTER);

        //Sayfayı kapatalım
        Driver.closeDriver();
    }
}
