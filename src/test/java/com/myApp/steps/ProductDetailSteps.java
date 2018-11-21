package com.myApp.steps;

import com.myApp.pages.ProductDetailPage;
import com.myApp.pages.entities.ProductDetail;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class ProductDetailSteps {
    private ProductDetailPage productDetailPage;
    private SearchSteps searchSteps;
    public ProductDetail productDetail;

    public ProductDetailSteps(ProductDetailPage productDetailPage, SearchSteps searchSteps) {
        this.productDetailPage = productDetailPage;
        this.searchSteps = searchSteps;
    }


    @Then("^Visitor should see the clicked product on Product Detail Page$")
    public void visitorShouldSeeTheClickedProductOnProductDetailPage() throws Throwable {
        Assert.assertEquals("Product Title is wrong", searchSteps.currentProductSearchDetail.title, productDetailPage.getProductTitle());
        Assert.assertEquals("Product EvaluationRate is wrong", searchSteps.currentProductSearchDetail.evaluationRate, productDetailPage.getEvaluationRate());
    }

    @When("^Visitor adds to list product on the Product Detail Page$")
    public void visitorAddsToListProductOnTheProductDetailPage() throws Throwable {
        productDetail = productDetailPage.getProductDetail();
        productDetailPage.addToList();
    }
}
