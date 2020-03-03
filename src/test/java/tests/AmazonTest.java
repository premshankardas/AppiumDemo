package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import pages.Pageclass;

import java.util.concurrent.TimeUnit;
/**Author Prem@hotstar.com
* On 2nd March 2020
* To validate Amazon order flow*/

public class AmazonTest extends BaseClass {

    @Test
    public void testOne() throws InterruptedException {
        Pageclass pc=new Pageclass(driver);
        pc.clickonSignin();
        driver.manage().timeouts().implicitlyWait(40, TimeUnit.SECONDS);
        pc.enterEmail("prem.psdas@gmail.com");
        pc.clickoncontinue();
        pc.clickCancel();
        pc.clickoncontinue();
        pc.enterPWd("test@123");
        pc.clkLoginCTA();
//      Assert.assertTrue(pc.verifyLogin(),"login not successfull");
        pc.closePopUp();
        pc.searchItem(pc.searchItemName);
        pc.pickElement();
        pc.buyNow();
        pc.continueToPaymentPage();
        pc.choosePayment();
        Assert.assertTrue(pc.ValidateThankYouScr(),"Order is not successful");/**To check if final Thank you screen has been displayed*/
    }
}
