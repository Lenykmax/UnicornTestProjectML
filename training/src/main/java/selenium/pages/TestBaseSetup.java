package selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

public class TestBaseSetup {

    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    private void setDriver(String browserType) {
        switch (browserType) {
            case "chrome":
                driver = initChromeDriver();
                break;
            case "firefox":
                driver = initFirefoxDriver();
                break;
            case "opera":
                driver = initOperaDriver();
                break;
            default:
                System.out.println("browser : " + browserType
                        + " is invalid, Launching Firefox as browser of choice..");
                driver = initFirefoxDriver();
        }
    }

    private static WebDriver initChromeDriver() {
        String exePath = "C:\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", exePath);
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initFirefoxDriver() {
        System.out.println("Launching Firefox browser..");
        WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver initOperaDriver() {
        System.out.println("Launching Opera browser..");
        WebDriver driver = new OperaDriver();
        driver.manage().window().maximize();
        return driver;
    }

    @Parameters({ "browserType" })
    @BeforeClass
    public void initializeTestBaseSetup(String browserType) {
        try {
            setDriver(browserType);

        } catch (Exception e) {
            System.out.println("Error....." + e.getStackTrace());
        }
    }

    public boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } // try
        catch (Exception e) {
            return false;
        } // catch
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
        if (isAlertPresent()) {
            driver.switchTo().alert();
            driver.switchTo().alert().accept();
            driver.switchTo().defaultContent();
        }
    }

}
