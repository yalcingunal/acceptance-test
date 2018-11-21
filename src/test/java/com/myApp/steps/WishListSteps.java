package com.myApp.steps;

import com.myApp.pages.WishListPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class WishListSteps {
    private WishListPage wishListPage;
    private ProductDetailSteps productDetailSteps;

    public WishListSteps(WishListPage wishListPage, ProductDetailSteps productDetailSteps) {
        this.wishListPage = wishListPage;
        this.productDetailSteps = productDetailSteps;
    }

    @And("^Visitor should see added product on the List Page$")
    public void visitorShouldSeeAddedProductOnTheListPage() throws Throwable {
        Assert.assertEquals("WishList Product Title is Wrong", productDetailSteps.productDetail.title, wishListPage.getFirstWishListProductTitle());
    }

    @When("^Visitor removes product on the List Page$")
    public void visitorRemovesProductOnTheListPage() throws Throwable {
        wishListPage.removeProduct();
    }

    @Then("^Visitor should see empty list on the List Page$")
    public void visitorShouldSeeEmptyListOnTheListPage() throws Throwable {
        Assert.assertEquals("wish list is not empth","0 items in this view",wishListPage.getSizeMessage());
    }
}
