package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class AccountPage extends HomePageBase {

    @FindBy(css = "[data-card-identifier='OrderingAndShoppingPreferences'] [class='a-list-item']")
    private List<WebElement> orderingAndShoppingPreferences;

    public AccountPage(MyWebDriver driver) {
        super(driver);
    }

    public void goToMyWishList(){
        orderingAndShoppingPreferences.get(5).click();
    }
}
