package tests;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.remote.MobileCapabilityType;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.remoting.support.UrlBasedRemoteAccessor;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
/**Author Prem@hotstar.com
 * On 2nd March 2020
 * Base class for setting desired capabilities
 * Appium driver instantiation
 * Appium session set up */


public class BaseClass {
    AppiumDriver driver;
    private final int TIMEOUT = 45;
    private Wait wait;

    @BeforeTest(alwaysRun = true)
    public void setup() throws InterruptedException {
        DesiredCapabilities caps = new DesiredCapabilities();
        String currentPAth=System.getProperty("user.dir");
        File appDir = new File(currentPAth+"/src/test/resources/apps/Amazon_shopping.apk");

        caps.setCapability(CapabilityType.PLATFORM_NAME,"ANDROID");
        caps.setCapability(MobileCapabilityType.PLATFORM_VERSION,"8.1.0");
        caps.setCapability(MobileCapabilityType.DEVICE_NAME,"Redmi 6 Pro");
        caps.setCapability(MobileCapabilityType.UDID,"28d7f0ff0205");
        caps.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT,60);
        caps.setCapability(MobileCapabilityType.NO_RESET,false);
        // caps.setCapability("chromedriverExecutable","/Users/prems/Downloads/chromedriver");
        caps.setCapability("appPackage","com.amazon.mShop.android.shopping");
        caps.setCapability("appActivity","com.amazon.mShop.splashscreen.StartupActivity");
        // caps.setCapability(MobileCapabilityType.APP,"");
        // caps.setCapability(MobileCapabilityType.BROWSER_NAME,"Chrome");
        URL url = null;
        try {
            url = new URL("http://0.0.0.0:4723/wd/hub");
        } catch (MalformedURLException e) {
            System.out.println("Cause "+e.getCause());
            System.out.println("Message "+e.getMessage());
            e.printStackTrace();
        }
        driver = new AppiumDriver<MobileElement>(url,caps);


    }
    @AfterTest(alwaysRun = true)
    public void teardown(){
        //driver.close();
        driver.quit();
    }

}
