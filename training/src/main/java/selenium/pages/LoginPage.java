
package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.TestBaseSetup;



public class LoginPage extends TestBaseSetup{

    final WebDriver driver;
    final WebDriverWait wait;

    //*[@id='pri_signin']

    @FindBy(how = How.XPATH, using = "//*[@id='pri_signin']")
    public WebElement loginWindow;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Sign in')]")
    public WebElement loginChoose;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'Register')]")
    public WebElement registerChoose;

    @FindBy(how = How.XPATH, using = "//span/input[@placeholder='Email or username']")
    public WebElement txtbx_UserName;

    @FindBy(how = How.XPATH, using = "//span/input[@type='password']")
    public WebElement txtbx_Password;

    @FindBy(how = How.XPATH, using = "//*[@id='sgnBt']")
    public WebElement btn_Login ;


    public LoginPage (WebDriver driver)

    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

// This method will take two arguments ( Username nd Password)
    public void logInAction(String UserName, String Password) throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(btn_Login));
        loginChoose.click();
        wait.until(ExpectedConditions.elementToBeClickable(txtbx_UserName));
        txtbx_UserName.click();
        txtbx_UserName.clear();
        txtbx_UserName.sendKeys(UserName);
        wait.until(ExpectedConditions.elementToBeClickable(txtbx_Password));
        txtbx_Password.click();
        txtbx_Password.clear();
        txtbx_Password.sendKeys(Password);
        wait.until(ExpectedConditions.elementToBeClickable(btn_Login));
        btn_Login.click();
    }

    public boolean isLoginPage() {
        btn_Login.isDisplayed() ;
        return true;
    }


}
