package mk.finki.ukim.mk.lab1.selenium;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;


public class AddBalloonPage extends AbstractPage {
    private WebElement name;

    private WebElement description;

    private WebElement manufacturerId;
    private WebElement manufactures;

    private WebElement submit;

    public AddBalloonPage(WebDriver driver) {
        super(driver);
    }
    public static BalloonsPage addBalloon(WebDriver driver, String name, String description) {
        get(driver, "/balloons/add");
        System.out.println(driver.getCurrentUrl());
        AddBalloonPage addBalloon = PageFactory.initElements(driver, AddBalloonPage.class);
        addBalloon.name.sendKeys(name);
        addBalloon.description.sendKeys(description);


        addBalloon.submit.click();
        return PageFactory.initElements(driver, BalloonsPage.class);
    }
}
