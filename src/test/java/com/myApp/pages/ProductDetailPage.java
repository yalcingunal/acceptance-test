package com.myApp.pages;

import com.myApp.core.driver.MyWebDriver;
import com.myApp.pages.entities.ProductDetail;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindAll;
import org.openqa.selenium.support.FindBy;

public class ProductDetailPage extends HomePageBase {


    @FindAll({@FindBy(css = "[id='centerCol'] [id='productTitle']"), @FindBy(css = "[class='a-size-large a-text-bold']")})
    private WebElement productTitle;

    @FindBy(css = "[id='centerCol'] [id='acrCustomerReviewText']")
    private WebElement ratingCount;

    @FindBy(css = "[id='centerCol'] [class='a-icon-alt']")
    private WebElement evaluationRate;

    @FindAll({@FindBy(id = "add-to-wishlist-button-submit"),@FindBy(css = "[value='Add to List']")})
    private WebElement addToListButton;

    @FindAll({@FindBy(id = "bylineInfo"),@FindBy(id = "brand")})
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

    public String getBrand() {
        return brand.getText();
    }

    public void addToList() throws InterruptedException {
        addToListButton.click();
        clickWithJavaScript(addToListButton);
        Thread.sleep(5000);
        try {
            closeButton.click();
        }catch (NoSuchElementException e){
            System.out.println(e);
        }

    }

    public ProductDetail getProductDetail() {
        return new ProductDetail(getProductTitle(),
                getBrand(),
                getRatingCount(),
                getEvaluationRate());
    }
}