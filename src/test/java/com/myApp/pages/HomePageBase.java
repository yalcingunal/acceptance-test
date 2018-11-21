package com.myApp.pages;

import com.myApp.core.configuration.AppSettings;
import com.myApp.core.driver.MyWebDriver;
import com.myApp.helpers.PageBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

abstract public class HomePageBase extends PageBase {

    @FindBy(css = "[class='nav-sprite nav-logo-base']")
    private WebElement baseLogo;

    @FindBy(id = "twotabsearchtextbox")
    private WebElement searchInputBox;

    @FindBy(css = "[class='nav-search-submit nav-sprite'] [type='submit']")
    private WebElement searchButton;

    @FindBy(id = "nav-link-accountList")
    private WebElement logInButton;

    @FindBy(css = "[id='nav-link-accountList'] [class='nav-line-1']")
    private WebElement accountNameText;

    @FindBy(id = "a-popover-lgtbox")
    private WebElement rootElement;

    public HomePageBase(MyWebDriver driver) {
        super(driver);
    }

    public void navigate() throws InterruptedException {
        driver.get(String.join("/", AppSettings.Instance.BaseUrl));
    }

    public void navigate(String path) {
        driver.get(String.join("/", AppSettings.Instance.BaseUrl) + path);
    }

    public void goToLoginPage() {
        logInButton.click();
    }

    public String getBaseLogoName() {
        return baseLogo.getText().toLowerCase();
    }

    public void searchWithValue(String value) {
        searchInputBox.clear();
        searchInputBox.sendKeys(value);
        searchButton.click();
    }

    public String getWelcomeMessageOnAccountTab() {
        return accountNameText.getText();
    }

    public void goToAccount() throws InterruptedException {
        scrollToElement(logInButton);
        Thread.sleep(3000);
        logInButton.click();
    }

    /*public void goToMyWishList() {
        mauseOver(nameAndSurname);
        waitUntilVisibleWebElement(myFavoriteButton).click();
    }*/
}
