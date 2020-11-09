package TestCases;


import DriverManager.DriverManagerType;
import DriverManager.DriverManager;
import Pages.BuyPage;
import Pages.HomePage;
import io.appium.java_client.android.AndroidDriver;
import util.utility;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {


    static AndroidDriver driver;
    protected HomePage homePage;
    protected BuyPage buyPage;
    Properties properties;
    DesiredCapabilities caps;
    protected String appName;
    @BeforeSuite
    public void setUp() throws Exception {
        try {
        	String propertyPath = System.getProperty("user.dir") + "//src//main//resources//android.properties";    
            properties = utility.loadProperties(propertyPath);
            appName = properties.getProperty("appName");
            System.out.println("app name is :: "+appName);
            driver = DriverManager.getDriver(DriverManagerType.ANDROID);
            homePage = new HomePage(driver);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void releaseDriver()
    {
    	driver.quit();
    }
    
    public void getNewDriver() throws Exception
    {
    	caps=DriverManager.getCapability();
    	driver = DriverManager.getDriver(DriverManagerType.ANDROID,caps);
    
    }

    @AfterSuite
    public void destroyDriver() {
        //  driver.quit();
    }
}