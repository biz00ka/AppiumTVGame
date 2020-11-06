package TestCases;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.appium.java_client.MobileBy;

public class LoginTestCases extends BaseTest {


    @Test
    public void TEST_CASE_ONE() throws Exception {
    	Thread.sleep(5000);
        homePage.search_Btn();
    	//driver.findElement(MobileBy.AndroidUIAutomator("new UiSelector().resourceId(\"com.android.vending:id/search_box_idle_text\")")).click();
       // driver.findElement(MobileBy.xpath("//android.widget.TextView[contains(text(),'Search for apps & games')]")).click();
        Thread.sleep(2000);
// type in the name of the app into the search bar
        driver.findElement(MobileBy.className("android.widget.EditText")).sendKeys("tv game");
    }
}
