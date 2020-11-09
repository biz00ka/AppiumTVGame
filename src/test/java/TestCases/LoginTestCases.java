package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class LoginTestCases extends BaseTest {


    @Test
    public void TEST_CASE_ONE() throws Exception {
    	System.out.println("app name is :: "+appName);
        homePage.searchAppInPlayStore(appName);
        homePage.selectAppFromPlaystore();
        homePage.waitForInstall();
        releaseDriver();
        getNewDriver();

    }
    
    @Test
    public void TEST_CASE_TWO() throws Exception {
    	System.out.println("");
        
    }
}
