package testCases.GoZayaan;

import org.testng.Assert;
import org.testng.annotations.Test;
import pages.GoZayen.HomePageGZ;
import pages.GoZayen.ProfilePageGZ;
import pages.GoZayen.SignInPageGZ;
import pages.ProfilePage;
import utilities.BrowserSetup;

public class TestGoZayaanLogin extends BrowserSetup {

        HomePageGZ homepage = new HomePageGZ();
        SignInPageGZ signInPage = new SignInPageGZ();
        ProfilePageGZ profilePage = new ProfilePageGZ();

        @Test
        public void testLogin() {

            getBrowser().get(homepage.url);
            homepage.clickOnElement(homepage.signInButton);
            signInPage.writeElement(signInPage.emailInputBox, signInPage.email);
            signInPage.writeElement(signInPage.passwordInputBox, signInPage.password);
            signInPage.clickOnElement(signInPage.signInButton);
            Assert.assertTrue(homepage.displayStatus(homepage.userIcon));

        }

    }


