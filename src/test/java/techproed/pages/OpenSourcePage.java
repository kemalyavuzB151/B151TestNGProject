package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {
    /*
        TestNG'de locate'lerimizi pages package'i altinda olusturdugumuz class'lar icinde aliriz.
        Bu class icinde driver'imizi tanimlamak ve webelementleri olusturabilmek icin constructor
        olusturup bu constructor icinde PageFactory class'indan initelements methodunu kullanarak
        driver'imizi bu class'a tanimlariz.
     */

    public OpenSourcePage() {
        PageFactory.initElements(Driver.getDriver(), this);
        /*
        Webelementleri locate edebilmek icin findElement() methodu kullanıyorduk.
        @FindBy notasyonu ile artık findElement() methodunu kullanmayıp @FindBy notasyonu icinde
        driver'in yerini tarif etmemiz gerekiyor.

            Yukaridaki (Driver.getDriver(), this) komutu burada ihtiyac duydugum driver,
            Driver class'indaki getDriver methodundaki driver demek oluyor
         */
    }

    @FindBy(xpath = "//*[@name='username']")
    public WebElement username;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//h6")
    public WebElement verify;


}
