package pages;

import com.utility.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import java.util.List;
/**Author Prem@hotstar.com
 * On 2nd March 2020
 * Page class g\has been defined to store the elements locators and operations as methods over pages */


public class Pageclass {
    Util util=new Util();
    WebDriver driver;
    /**All Locators enlisted*/
    @FindBy(id="com.amazon.mShop.android.shopping:id/sign_in_button")

    WebElement signinCTA;

    @FindBy(className="android.widget.EditText")
    WebElement enterEmail;
    @FindBy(className="android.widget.Button")

    WebElement continueCTA;
    @FindBy(className="android.widget.EditText")
    WebElement enterPwd;
    @FindBy(className="android.widget.Button")
    WebElement loginCTA;
    @FindBy(id="com.amazon.mShop.android.shopping:id/action_bar_burger_icon")
    WebElement humbergerMenu;
    @FindBy(id="gwm-FeatureShortcutCard-grid-top-1")
    WebElement loginTiles;
    @FindBy(xpath="//android.view.View[contains(text(),'close']")
    WebElement closebutton;
    @FindBy(id = "com.amazon.mShop.android.shopping:id/rs_search_src_text")
    WebElement searchBox;
    @FindBy(id = "android:id/button2")
    WebElement cancelButton;
    @FindBy(xpath = "//android.app.Dialog[contains(text(),'English - EN')]")
    WebElement closeButton;
    @FindBy(id = "com.amazon.mShop.android.shopping:id/item_title")
    WebElement itemTitle;
    @FindBy(id = "a-autoid-9")
    WebElement buyNowBtn;
    @FindBy(id = "a-autoid-0-announce")
    WebElement addressPicker;
    @FindBy(id = "//android.app.Dialog[contains(text(),'3 - 7 PM')]")
    WebElement timeSlotPicker;
    @FindBy(xpath = "//android.webkit.WebView[contains(text(),'Amazon Pay balance')]/preceding::@class='android.widget.RadioButton'")
    WebElement amazonPay;
    @FindBy(xpath = "//android.webkit.WebView[contains(text(),'Place your order')]")
    WebElement placeOrder;
    @FindBy(xpath = "//android.webkit.WebView[contains(text(),'Thank you for shopping with us')]")
    WebElement thankYouMessage;
    public String searchItemName = "65-inch TV";
    /**Driver instantiation*/
    public Pageclass(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
    /**Clicking on Sign in button after fresh launch*/
    public void clickonSignin()
    {

        signinCTA.click();
    }
    /**Email text box screen for entering field value*/
    public void enterEmail(String email)
    {
        enterEmail.clear();
        enterEmail.click();
        enterEmail.sendKeys(email);
    }
    /**Password entering screen for entering Passwords*/
    public void enterPWd(String pwd)
    {
        enterPwd.sendKeys(pwd);
    }
    /**Click Continue button that appears after the previous operation*/
    public void clickoncontinue()
    {
        continueCTA.click();
    }
    /**Tap on Login CTA */
    public void clkLoginCTA()
    {

        loginCTA.click();

    }
    /*public boolean verifyLogin()
    {
        humbergerMenu.click();
        String profText=loginTiles.getText().trim();
        if(profText.contains("hello"))
            return true;
    }*/
    /**Used to close the language preference pop up*/
    public void closePopUp(){
        util.WaitForElement(closeButton);

        closeButton.click();
    }

    /*public void clickForItem(String searchItem){
        util.WaitForElement(searchBox);
        searchBox.sendKeys(searchItem);
    }*/
    /**Search item as defined in the string variable passed and hit keyboard ENTER*/
    public void searchItem(String searchItemName){
        util.enterValues(searchItemName,searchBox);
        searchBox.sendKeys(Keys.ENTER);
    }
    /**Used to close the autofill pop up that appears after login*/
    public void clickCancel(){

        util.WaitForElement(cancelButton);
        cancelButton.click();
    }
    /**Fetches the list of item from result and picks the one with appropriate text and clicks on it to go to details screen*/
    public void pickElement(){
        List<WebElement> itemList = driver.findElements(By.id("com.amazon.mShop.android.shopping:id/item_title"));
        for(WebElement wb:itemList){
            if(wb.getText().contains("65 inches")){
                util.scrollToElement(wb);
                wb.click();
            }
        }
    }
    /**Clicks on Buy Now button on the details screen of the item*/
    public void buyNow(){
        util.scrollToElement(buyNowBtn);
        buyNowBtn.click();
    }
    /**It selects the first address, default date shown and time shown, if in case the continue button is disabled, it will pick the 2nd time slot*/
    public void continueToPaymentPage(){
        if(util.WaitForElement(addressPicker))
            addressPicker.click();
        if(util.WaitForElement(continueCTA))
            continueCTA.click();
        if(util.WaitForElement(continueCTA)) {
            if(continueCTA.isEnabled()){
                continueCTA.click();
            }

        }else {
            timeSlotPicker.click();
            continueCTA.click();
        }

    }
    /**It choosed the payment mode as Amamzon payand submits, clicks continue in the next screen and taps on Place order button*/
    public void choosePayment(){
        util.scrollToElement(amazonPay);
        util.clickonElement(amazonPay);
        util.clickonElement(continueCTA);
        util.scrollToElement(placeOrder);
        util.clickonElement(placeOrder);
    }
    /**It checks for the final Thank you screen to assert if test passed*/
    public boolean ValidateThankYouScr() throws InterruptedException {
        util.wait(5000);
        if(thankYouMessage.isDisplayed()){
            return true;
        } else {return false;}
    }

}
