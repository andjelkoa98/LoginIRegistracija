package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;

import java.util.List;

public class LoginPage extends BasePage {

    By usernameField = By.cssSelector("input[name='username']");
    By passwordField = By.id("password");
    By loginButton = By.cssSelector(".fa");
    By loggedInText = By.id("flash");



    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void runLoginTest(){
        driver.get("https://the-internet.herokuapp.com/login");
        wait.until(ExpectedConditions.presenceOfElementLocated(usernameField));
        typeIn(usernameField, "tomsmith");
        typeIn(passwordField, "SuperSecretPassword!");
        clickOnElement(loginButton);
    }
    public boolean checkColor(){
        String actualColor = getElement(loggedInText).getCssValue("background-color").trim();
        String expectedColor = null;

        if (driver instanceof ChromeDriver){
            expectedColor = "rgba(93, 164, 35, 1)";
        } else if (driver instanceof FirefoxDriver) {
            expectedColor = "rgb(93, 164, 35)";
        }
        return actualColor.equals(expectedColor);
    }
    public boolean checkText (){
        String expectedText = "You logged into a secure area!";
        String[] actualText = driver.findElement(loggedInText).getText().split("(?<=!)");
        return actualText[0].equals(expectedText);
    }
}
