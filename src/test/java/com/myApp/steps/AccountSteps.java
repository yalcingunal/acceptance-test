package com.myApp.steps;

import com.myApp.pages.AccountPage;
import cucumber.api.java.en.And;

public class AccountSteps {
    private AccountPage accountPage;

    public AccountSteps(AccountPage accountPage) {
        this.accountPage = accountPage;
    }

    @And("^Visitor goes to wish list on the Account Page$")
    public void visitorGoesToWishListOnTheAccountPage() throws Throwable {
        accountPage.goToMyWishList();
    }
}