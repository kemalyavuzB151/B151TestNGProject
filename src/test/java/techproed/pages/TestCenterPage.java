package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TestCenterPage {

    public TestCenterPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='exampleInputEmail1']")
    public WebElement testCenterUserName;

    @FindBy(xpath = "//*[@name='password']")
    public WebElement testCenterPassword;

    @FindBy(xpath = "//*[@type='submit']")
    public WebElement testCenterSubmitButton;

    @FindBy(xpath = "//*[@class='alert alert-success alert-dismissible fade show']")
    public WebElement testCenterVerify;

    @FindBy(xpath = "//*[@class='fa fa-sign-out-alt']")
    public WebElement testCenterlogOut;

    @FindBy(xpath = "//h2")
    public WebElement loginPageYazisi;



}
