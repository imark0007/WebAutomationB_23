package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

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

    @BeforeTest
    public void startBrowser(){

        WebDriver browser = getBrowser(browserName);
        browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        browser.manage().window().maximize();
        setBrowser(browser);
    }

    @AfterTest
    public void quitBrowser(){

        getBrowser().quit();
    }

}