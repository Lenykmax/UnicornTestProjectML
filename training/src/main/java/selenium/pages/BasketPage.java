
package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import selenium.pages.TestBaseSetup;



public class BasketPage extends TestBaseSetup{

    final WebDriver driver;
    final WebDriverWait wait;


    @FindBy(how = How.XPATH, using = "//*[@id='msku-sel-2']/option[4]")
    public WebElement setColor;

    @FindBy(how = How.XPATH, using = "//*[@id='msku-sel-1']/option[4]")
    public WebElement setModel;

    @FindBy(how = How.XPATH, using = "//*[@id='isCartBtn_btn']")
    public WebElement addToCart;




    public BasketPage (WebDriver driver)

    {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, 15);
    }

    // This method will take two arguments ( Username nd Password)
    public void finalizeOrder() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(setColor));
        setColor.click();
        wait.until(ExpectedConditions.elementToBeClickable(setModel));
        setModel.click();
        addToCart.click();
    }


}
