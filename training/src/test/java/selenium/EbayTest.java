package selenium;

import java.awt.*;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import selenium.pages.LoginPage;
import selenium.pages.HomePage;
import selenium.pages.BasketPage;
import selenium.pages.TestBaseSetup;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import java.awt.Robot;

public class EbayTest extends TestBaseSetup implements IRetryAnalyzer {

    static WebDriver driver;
    LoginPage LoginPage;
    HomePage HomePage;
    BasketPage BasketPage;
    Robot robot;
    private static int retryCount = 0;
    private int maxRetryCount = 3;

    @BeforeMethod
    public void beforeMethod() throws AWTException {
        Robot robot;
        driver=getDriver();
        LoginPage = PageFactory.initElements(driver, LoginPage.class);
        HomePage = PageFactory.initElements(driver, HomePage.class);
        BasketPage = PageFactory.initElements(driver, BasketPage.class);

    }

    @Test(retryAnalyzer = EbayTest.class)
    public void EbayTest() throws InterruptedException {
        HomePage.getLink();
        HomePage.isHomePage();
        HomePage.logInClick();
        LoginPage.logInAction("denisa.sufliarska@embedit.cz", "hcichina33");
        HomePage.isUserLoggedIn();
        System.out.println(" Login Successfully...");
        HomePage.search("Iphone Cover");
        HomePage.chooseCompatibleModels();
        System.out.println("Choose compatible");
        HomePage.chooseResult();
        BasketPage.finalizeOrder();
    }

    @Override
    public boolean retry(ITestResult result) {
        if (!result.isSuccess()) {
            if (retryCount < maxRetryCount) {
                retryCount++;
                result.setStatus(ITestResult.SUCCESS);
                String message = Thread.currentThread().getName() + ": Error in " + result.getName() + " Retrying "
                        + (maxRetryCount + 1 - retryCount) + " more times";
                System.out.println(message);
                return true;
            } else {
                result.setStatus(ITestResult.FAILURE);
            }
        }
        return false;
    }
}