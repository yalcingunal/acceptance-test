package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import com.myApp.pages.elements.ProductSearchRowElement;
import com.myApp.pages.entities.ProductSearchDetail;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class SearchPage extends HomePageBase {
    @FindBy(css = "[id='s-result-count'] [class='a-color-state a-text-bold']")
    private WebElement searchKeywordText;

    @FindBy(css = "[id^='result_']")
    private List<ProductSearchRowElement> productRowElements;

    @FindBy(css = "[class='pagnLink']")
    private WebElement pageIndexLink;

    @FindBy(css = "[class='pagnCur']")
    private WebElement currentPageIndex;

    @FindBy(id = "s-result-count")
    private WebElement numberOfListedProducts;

    public SearchPage(MyWebDriver driver) {
        super(driver);
    }

    public String getSearchKeyword() {
        return searchKeywordText.getText();
    }

    public String getCurrentPageIndex() throws InterruptedException {
        scrollToElement(currentPageIndex);
        Thread.sleep(3000);
        return currentPageIndex.getText();
    }

    public ProductSearchDetail goToProductWithIndex(int index) {
        return productRowElements.get(index - 1).goToProductDetail();
    }

    public String getNumberOfListedProducts() {
        return numberOfListedProducts.getText();
    }

    public void goToPageSecond() {
        pageIndexLink.click();
    }

}
