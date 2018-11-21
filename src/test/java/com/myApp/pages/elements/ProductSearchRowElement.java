package com.myApp.pages.elements;

import com.myApp.pages.entities.ProductSearchDetail;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductSearchRowElement extends RowElement<RowElement> {

    @FindBy(css = "[class='a-link-normal s-access-detail-page  s-color-twister-title-link a-text-normal']")
    private WebElement productTitle;

    @FindBy(css = "[class='a-size-small a-color-secondary']")
    private WebElement brandName;

    @FindBy(css = "[class='a-size-small a-link-normal a-text-normal']")
    private WebElement ratingCount;

    @FindBy(css = "[class='a-icon-alt']")
    private WebElement evaluationRate;

    public String getProductTitle() {
        return productTitle.getAttribute("title");
    }

    public String getBrandName() {
        return brandName.getText();
    }

    public String getRatingCount() {
        return ratingCount.getText();
    }

    public String getEvaluationRate() {
        return evaluationRate.getText();
    }

    public ProductSearchDetail goToProductDetail() {
        ProductSearchDetail productSearchDetail =
                new ProductSearchDetail(
                        getProductTitle()
                        , getBrandName()
                        , getRatingCount()
                        , getEvaluationRate());
        productTitle.click();
        return productSearchDetail;
    }
}