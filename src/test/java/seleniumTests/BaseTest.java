package seleniumTests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    public void beforeT(){
        System.out.println("Действие перед началом теста");
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
        DesiredCapabilities dc = DesiredCapabilities.chrome();
        dc.setCapability(ChromeOptions.CAPABILITY,op);
        driver = new ChromeDriver();
    }

    public WebDriver getDriver() {
        return driver;
    }

    @AfterTest
    public void afterT(){
        System.out.println("Действие после теста");
        driver.quit();
        if (driver!=null){
            driver.quit();
        }
    }

    @BeforeMethod
    public void beforeM(){
        System.out.println("Действие перед началом метода");
    }

    @AfterMethod
    public void afterM(){
        System.out.println("Действие после вызова метода");
    }
}
