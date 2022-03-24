package seleniumTests;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import utils.PropertyLoader;

import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest {

    WebDriver driver;

    public String setStendKey = System.setProperty("StendKey","stend1");
    public String stendKey = System.getProperty("StendKey");
    public String stendUrl = PropertyLoader.loadProperty(stendKey);

    @BeforeTest
    public void beforeT(){
        System.out.println("Действие перед началом теста");
        System.setProperty("webdriver.chrome.driver","./src/main/resources/chromedriver.exe");
        ChromeOptions op = new ChromeOptions();
//        DesiredCapabilities dc = DesiredCapabilities.chrome();
//        dc.setCapability(ChromeOptions.CAPABILITY,op);
//        driver = new ChromeDriver();

       op.setCapability("version","99.0");

        URL hub = null;
        try {
            hub = new URL("http://localhost:4444/wd/hub");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        driver = new RemoteWebDriver(hub,op);
    }



    @AfterTest
    public void afterT(){
        System.out.println("Действие после теста");
        driver.quit();
        if (driver!=null){
            driver.quit();
        }
    }

    public WebDriver getDriver() {
        return driver;
    }



    public byte[] getScreenshot(){
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
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
