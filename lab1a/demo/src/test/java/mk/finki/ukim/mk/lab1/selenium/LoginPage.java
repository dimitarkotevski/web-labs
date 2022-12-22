package mk.finki.ukim.mk.lab1.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends AbstractPage{
    private WebElement username;
    private WebElement password;
    private WebElement submit;
    public LoginPage(WebDriver driver) {
        super(driver);
    }
    public static LoginPage openLoginPage(WebDriver driver) {
        get(driver, "/");
        return PageFactory.initElements(driver, LoginPage.class);
    }
    public static BalloonsPage login(WebDriver driver,LoginPage loginPage, String username, String password){
        loginPage.username.sendKeys(username);
        loginPage.password.sendKeys(password);
        loginPage.submit.click();

        System.out.println(driver.getCurrentUrl());

        return PageFactory.initElements(driver, BalloonsPage.class);
    }
    public static LoginPage logout(WebDriver driver) {
        get(driver, "/logout");
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
