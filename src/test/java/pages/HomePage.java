package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{


    public String url = "https://automationexercise.com/";

    public By logInButton = By.xpath("//a[normalize-space()='Signup / Login'] ");
    public By logOutButton = By.xpath("//a[normalize-space()='Logout']");


}
