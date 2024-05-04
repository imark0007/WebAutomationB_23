package pages;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    public String password = "M@66vTgq5EDpd3z";
    public String email = "jiwom54235@rehezb.com";
    public String phoneNumber = "12024742561";
    public By emailInputBox = By.xpath("//input[@id='email']");
    public By passwordInputBox = By.xpath("//input[@id='password']");
    public By signInButton = By.xpath("//button[@id='submitBtn']");
    public By errorMessage = By.xpath("//div[@class='text-danger']");



}