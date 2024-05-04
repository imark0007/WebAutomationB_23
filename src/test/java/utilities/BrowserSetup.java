package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.time.Duration;

public class BrowserSetup {

    public static String browserName = System.getProperty("browser", "chrome");


    public WebDriver browser;
    public static final  ThreadLocal<WebDriver> LOCAL_BROWSER = new ThreadLocal<>();

    public static WebDriver getBrowser() {
        return LOCAL_BROWSER.get();
    }

    public static void setBrowser(WebDriver browser) {
        BrowserSetup.LOCAL_BROWSER.set(browser);
    }

    public WebDriver getBrowser(String browserName) {
        if (browserName.equalsIgnoreCase("chrome"))
            return new ChromeDriver();
        else if (browserName.equalsIgnoreCase("firefox"))
            return new FirefoxDriver();
        else if (browserName.equalsIgnoreCase("edge"))
            return new EdgeDriver();
        else {
            throw new RuntimeException("Invalid browser name: " + browserName);
        }

    }


    @BeforeSuite
    public void startBrowser(){

        WebDriver browser = getBrowser(browserName);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        browser.manage().window().maximize();
        setBrowser(browser);
    }


    @AfterSuite
    public void quitBrowser(){

        getBrowser().quit();
    }

    public WebElement getElement (By locator){
        browser.findElement(locator);
        return browser.findElement(locator);
    }

    public void writeElement(By locator, String text) {
        WebElement element = getElement(locator);
        element.clear();
        element.sendKeys(text);
    }

    public boolean displayStatus(By locator) {
        try {
            return getElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

    public void clickOnElement(By locator) {
        getElement(locator).click();
    }


}