package com.myApp.steps;

import com.myApp.pages.SearchPage;
import com.myApp.pages.entities.ProductSearchDetail;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class SearchSteps {

    private SearchPage searchPage;
    public ProductSearchDetail currentProductSearchDetail;
    public String currentPageIndex;

    public SearchSteps(SearchPage searchPage) {
        this.searchPage = searchPage;
    }

    @Then("^Visitor should see results related with \"([^\"]*)\"$")
    public void visitorShouldSeeResultsRelatedWith(String keyword) throws Throwable {
        Assert.assertEquals("Search keyword is wrong", "\"" + keyword + "\"", searchPage.getSearchKeyword());
    }

    @When("^Visitor goes to \"([^\"]*)\" th product on the search$")
    public void visitorGoesToThProductOnTheSearch(String index) throws Throwable {
        currentProductSearchDetail = searchPage.goToProductWithIndex(Integer.parseInt(index));
    }

    @When("^Visitor goes to \"([^\"]*)\" th page on the search$")
    public void visitorGoesToThPageOnTheSearch(String index) throws Throwable {
        //Casestudy static senaryolar olduğu için statik olarak düzenledim
        currentPageIndex = searchPage.getCurrentPageIndex();
        searchPage.goToPageSecond();
    }

    @Then("^Visitor should be on \"([^\"]*)\" th page on the search$")
    public void visitorShouldBeOnThPageOnTheSearch(String index) throws Throwable {
        //Casestudy static senaryolar olduğu için statik olarak düzenledim
        Assert.assertEquals("Page Index is Wrong", index, searchPage.getCurrentPageIndex());
        Assert.assertTrue("Number of listed Products is wrong", searchPage.getNumberOfListedProducts().contains("17-32"));
    }
}