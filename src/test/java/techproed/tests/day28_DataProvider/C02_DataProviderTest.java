package techproed.tests.day28_DataProvider;

import org.openqa.selenium.Keys;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.pages.GooglePage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ReusableMethods;

public class C02_DataProviderTest {
    @DataProvider
    public static Object[][] arabalar() {
        return new Object[][]{{"BMW"}, {"Audi"}, {"Mercedes"}, {"Volvo"}};
    }

    /*
    Google sayfasina gidip
    DataProvider ile belirtilen araç isimlerini aratalım.
     */

    @Test(dataProvider = "arabalar")
    public void test01(String araclar) {
        Driver.getDriver().get(ConfigReader.getProperty("googleUrl"));
        GooglePage googlePage = new GooglePage();
        googlePage.aramaKutusu.sendKeys(araclar, Keys.ENTER);
        ReusableMethods.bekle(3);
        //Her arama icin sayfa resmi alalim.
        ReusableMethods.tumSayfaResmi();
        //Sayfayi kapatalim.
        Driver.closeDriver();

    }
}
