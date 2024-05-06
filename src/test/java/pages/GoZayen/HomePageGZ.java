package pages.GoZayen;

import org.openqa.selenium.By;
import pages.BasePage;

public class HomePageGZ extends BasePage {


    public String url = "https://gozayaan.com/";

    public By signInButton = By.xpath("//button[normalize-space()='Sign In']");
    public By userIcon = By.xpath("//*[name()='path' and contains(@d,'M3 14s-1 0')]");


}
