package tests;


import driver.DriverManager;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;


public class BaseTest {

    WebDriver driver;


    @BeforeMethod(alwaysRun = true)
    //@Parameters("browser")
    public void setupMethods() throws InterruptedException {
        //WebDriverManager.chromedriver().setup();
        Thread.sleep(3000);
        //driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5)); //implicit
        driver = DriverManager.setDriver("chrome");
        //driver.get("https://preprod-the-internet.herokuapp.com/login");
//        driver.get("https://demowebshop.tricentis.com/");
        driver.get("https://the-internet.herokuapp.com/login");
    }

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }



}
