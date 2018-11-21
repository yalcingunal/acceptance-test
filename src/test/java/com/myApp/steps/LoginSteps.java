package com.myApp.steps;

import com.myApp.pages.LoginPage;
import cucumber.api.java.en.And;
import cucumber.api.java.en.When;


public class LoginSteps {

    private LoginPage loginPage;

    public LoginSteps(LoginPage loginPage) {
        this.loginPage = loginPage;
    }

    @When("^Visitor login with \"([^\"]*)\" email and \"([^\"]*)\" password$")
    public void customerLoginWithEmailAndPassword(String email, String password) throws Throwable {
        loginPage.loginWithEmailAndPassword(email, password);
    }

    @And("^Visitor go to the login page$")
    public void visitorGoToTheLoginPage() throws Throwable {
        loginPage.goToLoginPage();
    }
}
