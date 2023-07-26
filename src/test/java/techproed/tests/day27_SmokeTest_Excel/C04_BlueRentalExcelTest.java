package techproed.tests.day27_SmokeTest_Excel;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.BlueRentAlCarsPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelReader;
import techproed.utilities.ReusableMethods;

public class C04_BlueRentalExcelTest {
    @Test
    public void test01() {
        //Dosya yolu ve sayfa ismi ile objemizi oluşturalim.
        String dosyaYolu = ConfigReader.getProperty("dosyaYolu");
        String sayfaIsmi = ConfigReader.getProperty("sayfaIsmi");
        ExcelReader reader = new ExcelReader(dosyaYolu, sayfaIsmi);

        /*mysmoketestdata excel dosyasindaki tüm email ve passwordler ile
        Bluerentalcar sitesinde login olalim ve her kullanici icin login oldugunu dogrulayalim.
        */

        //Bluerentalcar sayfasina gidelim.
        Driver.getDriver().get(ConfigReader.getProperty("bluerentalcarsuRL"));
        BlueRentAlCarsPage rentAlCarsPage = new BlueRentAlCarsPage();   // --> locate'lere ulaşabilmek icin

        //Bir loop oluşturup excel dosyasindaki tüm veriler ile login olalim.
        for (int i = 1; i <= reader.rowCount(); i++) {   // --> i neden 1 den başladı? başlıkları almayalım diye
            String email = reader.getCellData(i, 0);
            String password = reader.getCellData(i, 1);
            System.out.println(email + " ---- " + password);
            rentAlCarsPage.loginButton.click();
            ReusableMethods.bekle(2);
            rentAlCarsPage.eMail.sendKeys(email, Keys.TAB, password, Keys.ENTER);
            ReusableMethods.bekle(2);
            rentAlCarsPage.girisYapildiVerify.click();
            ReusableMethods.bekle(1);
            Assert.assertTrue(rentAlCarsPage.logOut.isDisplayed());
            rentAlCarsPage.logOut.click();
            ReusableMethods.bekle(1);
            rentAlCarsPage.ok.click();
            ReusableMethods.bekle(1);
        }
        //Sayfayi kapatiniz.
        Driver.closeDriver();
    }
}
