package DriverManager;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;

import org.openqa.selenium.remote.DesiredCapabilities;
import util.utility;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class AndroidDriverManager {
    Properties properties;
    private static Map<String, AndroidDriver> mobileDriverPool = new HashMap();
    static DesiredCapabilities capabilities;
    AndroidDriver driver;

    public AndroidDriverManager(String propertyPath)
    {
    	properties = utility.loadProperties(propertyPath);
    }
    
    public AndroidDriver getAndroidDriver() {
        try {
        	
			/*
			 * String platformVersion = properties.getProperty("platformVersion"); String
			 * deviceName = properties.getProperty("deviceName"); String nodeURL =
			 * properties.getProperty("nodeURL"); String appPackage =
			 * properties.getProperty("appPackage"); String appActivity =
			 * properties.getProperty("appActivity"); String platformName =
			 * properties.getProperty("platformName"); String app =
			 * properties.getProperty("apkPath"); String avd =
			 * properties.getProperty("avd"); capabilities = new DesiredCapabilities();
			 * capabilities.setCapability("platformVersion", platformVersion);
			 * capabilities.setCapability("deviceName", deviceName);
			 * capabilities.setCapability("appPackage", appPackage);
			 * capabilities.setCapability("appActivity", appActivity);
			 * capabilities.setCapability("platformName", platformName);
			 * capabilities.setCapability("avd", avd);
			 * capabilities.setCapability("autoGrantPermissions", "true");
			 * capabilities.setCapability("app", System.getProperty("user.dir") +
			 * "//src//main//" + app);
			 */
        	String deviceName = properties.getProperty("deviceName"); 
        	String nodeURL =properties.getProperty("nodeURL"); 
        	String appPackage = properties.getProperty("appPackage"); 
        	String appActivity =  properties.getProperty("appActivity"); 
        	String platformName = properties.getProperty("platformName"); 
        	String platformVersion = properties.getProperty("platformVersion"); 
        	String avd = properties.getProperty("avd"); 
        	capabilities = new DesiredCapabilities();
        	capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
            capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
            capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, "com.android.vending");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, ".AssetBrowserActivity");
            capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ".AssetBrowserActivity");
           // capabilities.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, 40);
           // capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
         //   capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.4.16");
            capabilities.setCapability("deviceOrientation", "portrait");

            driver = new AndroidDriver(new URL(nodeURL), capabilities);

   
           // return driver = new AndroidDriver(new URL(nodeURL), capabilities);
//                capabilities.setCapability("unicodeKeyboard", true);
//                capabilities.setCapability("resetKeyboard", true);

        } catch (Exception e) {
            System.out.println("Not able to create Android Driver " + e.getMessage());
        }
        return driver;
    }
    
    
    public DesiredCapabilities installedAppCaps() throws Exception {

    	String appPackage = properties.getProperty("appPackage"); 
    	String appActivity =  properties.getProperty("appActivity"); 
    	String deviceName = properties.getProperty("deviceName"); 
    	String platformName = properties.getProperty("platformName"); 
    	String platformVersion = properties.getProperty("platformVersion");
        DesiredCapabilities capabilities = DesiredCapabilities.android();
        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, deviceName);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, platformVersion);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, platformName);
        capabilities.setCapability(MobileCapabilityType.BROWSER_NAME, "");
        capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, appPackage);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, appActivity);
        capabilities.setCapability(AndroidMobileCapabilityType.APP_WAIT_ACTIVITY, ".AssetBrowserActivity");
        capabilities.setCapability(AndroidMobileCapabilityType.DEVICE_READY_TIMEOUT, 40);
        capabilities.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 180);
        capabilities.setCapability(MobileCapabilityType.APPIUM_VERSION, "1.4.16");
        capabilities.setCapability("deviceOrientation", "portrait");
        capabilities.setCapability("autoLaunch", "false");

        return capabilities;
    }
}
