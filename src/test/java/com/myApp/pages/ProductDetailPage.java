package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import com.myApp.pages.entities.ProductDetail;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends HomePageBase {

    @FindBy(css = "[id='centerCol'] [id='productTitle']")
    private WebElement productTitle;

    @FindBy(css = "[id='centerCol'] [id='acrCustomerReviewText']")
    private WebElement ratingCount;

    @FindBy(css = "[id='centerCol'] [class='a-icon-alt']")
    private WebElement evaluationRate;

    @FindBy(id = "add-to-wishlist-button-submit")
    private WebElement addToListButton;

    @FindBy(id = "bylineInfo")
    private WebElement brand;

    @FindBy(css = "[aria-label='Close']")
    private WebElement closeButton;

    public ProductDetailPage(MyWebDriver driver) {
        super(driver);
    }

    public String getProductTitle() {
        return productTitle.getText();
    }

    public String getRatingCount() {
        return ratingCount.getText();
    }

    public String getEvaluationRate() {
        return evaluationRate.getText();
    }

    public String getBrand(){
        return brand.getText();
    }

    public void addToList() throws InterruptedException {
        addToListButton.click();
        Thread.sleep(5000);
        closeButton.click();
    }

    public ProductDetail getProductDetail() {
        return new ProductDetail(getProductTitle(),
                getBrand(),
                getRatingCount(),
                getEvaluationRate());
    }
}