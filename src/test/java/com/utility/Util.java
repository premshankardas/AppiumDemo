package com.utility;

import com.google.inject.internal.cglib.core.$CollectionUtils;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.BaseClass;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import java.time.Duration;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
/**Author Prem@hotstar.com
 * On 2nd March 2020
 * To create custom methods for some most used mobile screen operations*/


public class Util extends BaseClass {
    Util util;
    AppiumDriver driver;
    private final int TIMEOUT = 45;
    private Wait wait;
    /**Uses WebDriver wait method to wait for visibility of web element passed and returns boolean response based on the visibility in TIMEOUT duration */
    public boolean WaitForElement(WebElement wb){
        try {
            wait = new WebDriverWait(driver, TIMEOUT);

            wait.until(ExpectedConditions.visibilityOf(wb));
            return wb.isDisplayed();
        }
        catch(Exception e){
            System.out.println(e.getMessage());
            return false;
        }
    }
    /**Custom click method to click on passed web element*/
    public void clickonElement(WebElement wb)
    {
        wb.click();
    }
    /**Custom value passing method(send keys) to pass string argument on passed web element*/
    public void enterValues(String arg,WebElement wb)
    {
        wb.clear();
        WaitForElement(wb);
        wb.sendKeys(arg);
    }




    /**
     *Custom scroll menthod to a particular web element using x, y offsets
     */
    public void scrollToElement(WebElement wb) {
        TouchActions action = new TouchActions(driver);
        action.scroll(wb, 10, 100);
        action.perform();

    }
    /**Custom vertical swipe method from one web element to another */
   /* public void VerticalSwipe(WebElement start1,WebElement end1)
    {
        int start1x, start1y, end1x, end1y;
        start1x = start1.getLocation().getX();
        end1x = end1.getLocation().getX();
        start1y = start1.getLocation().getY();
        end1y = end1.getLocation().getY();
        TouchAction action1 = new TouchAction(driver);
        action1.press(350, end1y).waitAction(500).moveTo(350, start1y).release().perform();
    }*/
    /**Custom horizontal swipe method from one web element to another */

   /* public void horizontalSwipe(WebElement start1,WebElement end1)
    {

        int start1x, start1y, end1x, end1y;
        start1x = start1.getLocation().getX();
        end1x = end1.getLocation().getX();
        start1y = start1.getLocation().getY();
        end1y = end1.getLocation().getY();
        System.out.println(start1x);
        System.out.println(start1y);
        System.out.println(end1x);
        System.out.println(end1y);

        TouchAction action1 = new TouchAction(driver);
        action1.press(end1x,start1y+150).waitAction(600).moveTo(start1x,start1y+150).release().perform();
    }
*/

    /**Custom swipe operation from one web elemnt to another*/
    public void swipeFromElementToElement(WebElement source, WebElement destination) {
        TouchAction action = new TouchAction(driver);
        action.press((PointOption) source).moveTo((PointOption) destination).release().perform();


    }

}
