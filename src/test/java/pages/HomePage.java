package pages;

import org.openqa.selenium.By;

public class HomePage extends BasePage{


    public String url = "https://gozayaan.com/";

    public By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    public By userIcon = By.xpath("//*[name()='path' and contains(@d,'M3 14s-1 0')]");


}
