package com.myApp.pages.elements;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductWishListRowElement extends RowElement<RowElement>{
    @FindBy(css = "[id^='itemName_']")
    private WebElement productTitle;

    @FindBy(css = "[id^='review_count_']")
    private WebElement evaluationRate;

    @FindBy(css = "[name='submit.deleteItem']")
    private WebElement removeProductButton;

    public String getProdcutTitle(){
        return productTitle.getText();
    }

    public String getEvaluationRate(){
        return evaluationRate.getText();
    }

    public void removeProduct(){
        removeProductButton.click();
    }
}
