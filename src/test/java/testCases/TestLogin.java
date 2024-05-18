package testCases;

import io.qameta.allure.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LogInPage;
import utilities.BrowserSetup;
import utilities.DataSet;

public class TestLogin extends BrowserSetup {

    HomePage homePage = new HomePage();
    LogInPage logInPage = new LogInPage();


    @BeforeTest
    public void loadLogInPage() {

        getBrowser().get(homePage.url);
        homePage.clickOnElement(homePage.logInButton);

    }

    @Test(priority = 0, description = "User Login with Valid Credentials")
    @Description("Test Add using Allure :User Login with Valid Credentials")
    public void testLoginWithValidCredentials() {

        logInPage.addScreenshot("Before add data");
        logInPage.writeElement(logInPage.emailInputBox, logInPage.email);
        logInPage.writeElement(logInPage.passwordInputBox, logInPage.password);
        logInPage.addScreenshot("After add data");
        logInPage.clickOnElement(logInPage.logInButton);
        logInPage.addScreenshot("After login");
        Assert.assertTrue(homePage.displayStatus(homePage.logOutButton));
        logInPage.clickOnElement(homePage.logOutButton);
    }

    @Test(priority = 1, description = "User Login with Invalid Credentials")
    @Description("Test Add using Allure :User Login with Invalid Credentials")
    public void testLoginWithInValidCredentials() {

        logInPage.writeElement(logInPage.emailInputBox, logInPage.wrongEmail);
        logInPage.writeElement(logInPage.passwordInputBox, logInPage.wrongPassword);
        logInPage.clickOnElement(logInPage.logInButton);
        logInPage.addScreenshot("After clicked on login button");
        Assert.assertTrue(homePage.displayStatus(logInPage.errorMessage));

    }
    @Test
    public void testLoginWithValidEmail() {

        logInPage.writeElement(logInPage.emailInputBox, logInPage.email);
        logInPage.writeElement(logInPage.passwordInputBox, logInPage.wrongPassword);
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertFalse(homePage.displayStatus(homePage.logOutButton));

    }
    @Test
    public void testLoginWithValidPassword() {

        logInPage.writeElement(logInPage.emailInputBox, logInPage.wrongEmail);
        logInPage.writeElement(logInPage.passwordInputBox, logInPage.password);
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertFalse(homePage.displayStatus(homePage.logOutButton));

    }

    @Test
    public void testLoginWithOutEmailAndPassword() {

//      logInPage.writeElement(logInPage.emailInputBox, logInPage.wrongEmail);
//      logInPage.writeElement(logInPage.passwordInputBox, logInPage.wrongPassword);
        logInPage.clickOnElement(logInPage.logInButton);
        Assert.assertFalse(homePage.displayStatus(homePage.logOutButton));

    }

    @Test(dataProvider = "invalidCredentials", dataProviderClass = DataSet.class)
    public void testLoginWithFakeCredentials(String username, String password, String errorMessage) {

        logInPage.writeElement(logInPage.emailInputBox,  username);
        logInPage.writeElement(logInPage.passwordInputBox, password);
        logInPage.clickOnElement(logInPage.logInButton);
//      Assert.assertEquals(logInPage.getElement(logInPage.errorMessage).getText(), errorMessage);
        Assert.assertFalse(homePage.displayStatus(homePage.logOutButton));

    }

}