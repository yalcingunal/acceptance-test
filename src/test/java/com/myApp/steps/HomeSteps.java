package com.myApp.steps;

import com.myApp.core.configuration.AppSettings;
import com.myApp.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class HomeSteps {

    private LoginPage loginPage;

    public HomeSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @Given("^Visitor is on the HomePage$")
    public void iVisitSsHomepage() throws Throwable {
        loginPage.navigate();
    }

    @Then("^Visitor should see Base Url and Base Logo$")
    public void visitorShouldSeeBaseUrlAndBaseLogo() throws Throwable {
        Assert.assertEquals("HomePage url is wrong", AppSettings.Instance.BaseUrl + "/", loginPage.getCurrentUrl());
        Assert.assertEquals("Base", "amazon", loginPage.getBaseLogoName());
    }

    @Then("^Visitor should see \"([^\"]*)\" welcome message on Account Tab$")
    public void customerShouldSeeWelcomeMessageOnAccountTab(String welcomeMessage) throws Throwable {
        Assert.assertEquals("login fail", welcomeMessage, loginPage.getWelcomeMessageOnAccountTab());
    }

    @When("^Visitor searches with \"([^\"]*)\" keyword$")
    public void visitorSearchesWithKeyword(String keyword) throws Throwable {
        loginPage.searchWithValue(keyword);
    }

    @Then("^Visitor goes to account$")
    public void visitorGoesToAccount() throws Throwable {
        loginPage.goToAccount();
    }

}