package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentAlCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C03_BlueRentalExcelTest {
    //Bluerentalcar adresine gidelim.
    //mysmoketestdata excel dosyasındaki herhangi bir email ve password ile login olalım
    //login oldugumuzu dogrulayalim.
    //sayfayi kapatalim.

    @Test
    public void test01() {
        //Bluerentalcar adresine gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsuRL"));
        //mysmoketestdata excel dosyasındaki herhangi bir email ve password ile login olalım
        String dosyaYolu = "src/test/java/techproed/resources/mysmoketestdata.xlsx";
        String sayfaIsmi = "customer_info";
        ExcelReader reader = new ExcelReader(dosyaYolu, sayfaIsmi);
        String email = reader.getCellData(2, 0);
        String password = reader.getCellData(2, 1);
        BlueRentAlCarsPage blueRentAlCarsPage = new BlueRentAlCarsPage();
        blueRentAlCarsPage.loginButton.click();
        ReusableMethods.bekle(2);
        blueRentAlCarsPage.eMail.sendKeys(email, Keys.TAB, password, Keys.ENTER);
        ReusableMethods.bekle(2);
        //login oldugumuzu dogrulayalim.
        Assert.assertTrue(blueRentAlCarsPage.girisYapildiVerify.getText().contains("Kate"));
        //sayfayi kapatalim.
        Driver.closeDriver();
    }
}
