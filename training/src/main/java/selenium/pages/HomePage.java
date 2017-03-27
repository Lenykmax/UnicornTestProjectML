
package selenium.pages;

import org.apache.http.StatusLine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class HomePage extends TestBaseSetup {

    final WebDriver driver;
    final WebDriverWait wait;
    Date date;
    Actions actions;
    String linkForTesting = "http://www.ebay.com/";
    static SimpleDateFormat dateformat = new SimpleDateFormat("dd.M.yyyy");
    static SimpleDateFormat dateformatSecond = new SimpleDateFormat("S ss dd.M.yyyy");

    /*
    Selectors for Page object using How
     */

    @FindBy(how = How.XPATH, using = "//*[@id='gh-top']")
    public WebElement topMenu;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign in')]")
    public WebElement btn_LogIn;

    @FindBy(how = How.XPATH, using = "//*[@id='gh-ug'][contains(text(),'Hi')]")
    public WebElement userPage;

    @FindBy(how = How.XPATH, using = "//a[contains(text(),'Sign out')]")
    public WebElement btn_LogOut;

    //search
    @FindBy(how = How.XPATH, using = "//input[@placeholder='Search...']")
    public WebElement searchField;

    @FindBy(how = How.XPATH, using = "//input[@type='submit'][@value='Search']")
    public WebElement searchBtn;

    @FindBy(how = How.XPATH, using = "//span[contains(text(),'results for ')]")
    public WebElement searchResults;

    @FindBy(how = How.XPATH, using = "//*[@id='Results']")
    public WebElement searchResultsTable;

    //not sure how put variable to xpath
    @FindBy(how = How.XPATH, using = "(//span[.='For iPhone 6']/parent::*)/preceding-sibling::input")
    public WebElement compatibleModelChoose;

    @FindBy(how = How.XPATH, using = "//*[@id='Results']//li[contains(@id,'item')][3]/h3/a")
    public WebElement searchResultToChoose3;

    public HomePage(WebDriver driver)

    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
        this.date = new Date();
        this.actions = new Actions(driver);
    }

    // This method will check is alert presents
    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } // try
        catch (Exception e) {
            return false;
        } // catch
    }
    public void logOut() {
        actions.moveToElement(userPage);
        wait.until(ExpectedConditions.elementToBeClickable(btn_LogOut));
        btn_LogOut.click();
    }

    public void logInClick() {
        btn_LogIn.click();
    }

    public void getLink() {
        driver.get(linkForTesting);
    }

    public void getLink(String params) {
        driver.get(linkForTesting + params);
    }

    public void search(String goods){
        wait.until(ExpectedConditions.elementToBeClickable(searchField));
        searchField.click();
        searchField.clear();
        searchField.sendKeys(goods);
        searchBtn.click();
        wait.until(ExpectedConditions.visibilityOf(searchResults));
        wait.until(ExpectedConditions.visibilityOf(searchResultsTable));
    }

    //need refactor for using String for choose compatible
    public void chooseCompatibleModels() {
        wait.until(ExpectedConditions.visibilityOf(compatibleModelChoose));
        compatibleModelChoose.click();
    }

    public void chooseResult(){
        wait.until(ExpectedConditions.visibilityOf(searchResultsTable));
        searchResultToChoose3.click();
    }





    public void wait7() {
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    public void scrollDown() {
    ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,300)");
    }

    public void scrollUp() {
        ((JavascriptExecutor) driver).executeScript("window.scrollBy(0,-300)");
    }

    public boolean isHomePage() {
        topMenu.isDisplayed() ;
        return true;
    }

    public void isUserLoggedIn(){
        wait.until(ExpectedConditions.visibilityOf(userPage));
    }

    private StatusLine get(String value) {
        return null;
    }
}
