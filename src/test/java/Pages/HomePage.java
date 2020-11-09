package Pages;


import java.util.List;

import org.openqa.selenium.WebDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;


public class HomePage extends BasePageClass {

	public static final String CONTINUE_BTN = "com.nobroker.app:id/bottomPermission";
	public static final String BUY_BTN ="com.nobroker.app:id/buyLayout";
	public static final String SEARCH_BTN="com.nobroker.app:id/searchEditBar";


	@AndroidFindBy(id = CONTINUE_BTN)
	MobileElement allowContinue_Btn;

	@AndroidFindBy(id = BUY_BTN)
	MobileElement but_Btn;

	@AndroidFindBy(id = "com.android.vending:id/text_container")
	MobileElement search_Btn;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Search for apps & games']")
	MobileElement searchBar;

	@AndroidFindBy(className = "android.widget.EditText")
	MobileElement searchBarText;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='game.tv']")
	List<MobileElement> search_ResultText;

	@AndroidFindBy(xpath = "//android.support.v7.widget.RecyclerView/android.widget.LinearLayout")
	List<MobileElement> search_ResultList;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Install']")
	MobileElement installButton;
	
	@AndroidFindBy(xpath = "//android.widget.Button[@text='Open']")
	MobileElement openButton;
	
	
	
	public HomePage(AndroidDriver driver) {
		super(driver);System.out.println("222..");
	}



	public void allowContinue_Btn() {
		androidHelperMethods.click(allowContinue_Btn);
	}

	public void buyBtn() {
		androidHelperMethods.click(but_Btn);
	}

	public void searchAppInPlayStore(String appName ) {
		try {
			Thread.sleep(5000);
			androidHelperMethods.click(searchBar);
			//androidHelperMethods.inputValuesSlowly(searchBarText, appName);
			Thread.sleep(2000);
			searchBarText.sendKeys(appName);
			Thread.sleep(2000);
			System.out.println("search result set.."+search_ResultText.size());
			if(search_ResultText.size()>0)
				androidHelperMethods.click(search_ResultText.get(0));
			Thread.sleep(3000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to search the app in play-store");
			e.printStackTrace();
		}
	}

	public void selectAppFromPlaystore() {
		try {
			System.out.println("search result set.."+search_ResultList.size());
			if(search_ResultList.size()>0)
				androidHelperMethods.click(search_ResultList.get(0));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Unable to select the app in play-store");
			e.printStackTrace();
		}
	}

public void waitForInstall()
{
	try {
		Thread.sleep(3000);
		androidHelperMethods.click(installButton);
		androidHelperMethods.waitForElementClickable(openButton);
		if(openButton.isEnabled())
			System.out.println("App is installed.");
		Thread.sleep(10000);
		
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("Unable to Install the app from play-store");
	}
}

}
