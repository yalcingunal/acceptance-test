package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import com.myApp.pages.elements.ProductWishListRowElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class WishListPage extends HomePageBase {


    @FindBy(id = "g-items")
    private List<ProductWishListRowElement> productRowElements;

    @FindBy(id = "no-items-section")
    private WebElement emptyProductMessage;

    public WishListPage(MyWebDriver driver) {
        super(driver);
    }

    public String getFirstWishListProductTitle(){
        return productRowElements.get(0).getProdcutTitle();
    }

    public String getFirstWishListProductEvaluationRate(){
        return productRowElements.get(0).getEvaluationRate();
    }

    public void removeProduct(){
        productRowElements.get(0).removeProduct();
    }

    public String getSizeMessage(){
        pageRefresh();
        return emptyProductMessage.getText();
    }
}
