package testCases;

import org.testng.annotations.Test;
import utilities.BrowserSetup;

public class TestLogin extends BrowserSetup {

    @Test
    public void testLogin() {
       getBrowser().get("https://rahulshettyacademy.com/AutomationPractice/");
    }
}