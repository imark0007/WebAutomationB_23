package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pages.HomePage;
import pages.ProfilePage;
import pages.SignInPage;
import utilities.BrowserSetup;

public class TestLogin extends BrowserSetup {

        HomePage homepage = new HomePage();
        SignInPage signInPage = new SignInPage();
        ProfilePage profilePage = new ProfilePage();

        @Test
        public void testLogin() throws InterruptedException {

            getBrowser().get(homepage.url);
            homepage.clickOnElement(homepage.signInButton);
            signInPage.writeElement(signInPage.emailInputBox, signInPage.email);
            signInPage.writeElement(signInPage.passwordInputBox, signInPage.password);
            signInPage.clickOnElement(signInPage.signInButton);
            Assert.assertTrue(homepage.displayStatus(homepage.userIcon));




        }

    }


