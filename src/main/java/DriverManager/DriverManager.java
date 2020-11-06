package DriverManager;

import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.WebDriver;

import org.openqa.selenium.remote.DesiredCapabilities;
import util.utility;

import java.util.Properties;
import java.net.URL;

public class DriverManager {
	static Properties properties;
	public static AndroidDriver driver;
	static DesiredCapabilities capabilities;
	public static String propertyPath = System.getProperty("user.dir") + "//src//main//resources//android.properties";

	public static WebDriver getDriver(DriverManagerType browserName) throws Exception {
		switch (browserName.getDriver()) {
		case "AndroidDriver":

			return driver = new AndroidDriverManager(propertyPath).getAndroidDriver();

		}
		return null;
	}

	public static DesiredCapabilities getCapability(DriverManagerType browserName) throws Exception {

		return capabilities = new AndroidDriverManager(propertyPath).installedAppCaps();

	}

}
