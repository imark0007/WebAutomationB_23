package pages;

import org.openqa.selenium.By;

public class LogInPage extends BasePage{


        public String email = "jiwom54235@rehezb.com";
        public String wrongEmail = "jiwom54235@re.com";
//      public String invalidEmail = "invalid_email";
        public String password = "112233445566";
        public String wrongPassword = "112233445566778899";
//      public String phoneNumber = "+19174195208";
        public By emailInputBox = By.xpath("//input[@data-qa='login-email']");
        public By passwordInputBox = By.xpath("//input[@placeholder='Password']");
        public By logInButton = By.xpath("//button[normalize-space()='Login']");
        public By errorMessage = By.xpath("//p[normalize-space()='Your email or password is incorrect!']");


}
