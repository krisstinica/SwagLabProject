package com.swagLab.step_defs;

import com.swagLab.pages.LoginPage;
import com.swagLab.pages.ProductPage;
import com.swagLab.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Login_stepDefs {

LoginPage loginPage=new LoginPage();
ProductPage productPage=new ProductPage();
    String actualTitle;

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {

        Driver.getDriver().get("https://www.saucedemo.com/");
    }
    @When("User enters valid username {string}")
    public void user_enters_valid_username(String username) {
        loginPage.username.sendKeys(username);
    }
    @When("User enters valid password {string}")
    public void user_enters_valid_password(String password) {
loginPage.password.sendKeys(password);
    }
    @When("User clicks on login button")
    public void user_clicks_on_login_button() {
loginPage.loginButton.click();
    }
    @Then("User should see {string} displayed on Products page")
    public void user_should_see_displayed_on_products_page(String expectedTitle) {

      actualTitle = productPage.productTitle.getText();
        Assert.assertEquals(expectedTitle,actualTitle);

    }

    @When("User enters locked out username {string}")
    public void userEntersLockedOutUsername(String username) {

        loginPage.username.sendKeys(username);

    }


    @Then("{string} should be displayed")
    public void shouldBeDisplayed(String expectedMsg) {
loginPage.errorMessage(expectedMsg);
    }

    @When("User enters problem username {string}")
    public void userEntersProblemUsername(String username) {
        loginPage.username.sendKeys(username);

    }
    @Then("User should not be able to add Sauce Labs Fleece Jacket")
    public void userShouldNotBeAbleToAddSauceLabsFleeceJacket() {
        productPage.addFleeceToCart.click();
    }

    @When("User enters username {string}")
    public void userEntersUsername(String username) {
        loginPage.username.sendKeys(username);
    }

    @Then("User should wait for five seconds to launch to Product page")
    public void userShouldWaitForFiveSecondsToLaunchToProductPage() {

        //System.currentTimeMillis();
        WebDriverWait wait= new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        wait.until(ExpectedConditions.visibilityOf(productPage.productTitle));
      //  Assert.assertEquals("Products", productPage.productTitle.getText());
        Assert.assertTrue(productPage.productTitle.isDisplayed());


    }
    @When("User enters invalid username {string}")
    public void userEntersInvalidUsername(String InvalidUsername) {
        loginPage.username.sendKeys(InvalidUsername);
    }

    @And("User enters invalid password {string}")
    public void userEntersInvalidPassword(String invalidPsw) {
        loginPage.password.sendKeys(invalidPsw);
    }

    @Then("Error message should be displayed")
    public void errorMessageShouldBeDisplayed() {
        //String actualMsg=loginPage.errorMsg.getText();
        //String expectedMsg="Epic sadface: Username and password do not match any user in this service";
        //Assert.assertEquals(expectedMsg,actualMsg);
        loginPage.errorMessage("Epic sadface: Username and password do not match any user in this service");
    }

    @When("User enters a blank username")
    public void userEntersABlankUsername() {
        loginPage.username.sendKeys("");
    }

    @And("User enters a blank password")
    public void userEntersABlankPassword() {
        loginPage.password.sendKeys("");
    }

    @Then("{string} message should be displayed")
    public void messageShouldBeDisplayed(String expectedMsg) {
       loginPage.errorMessage(expectedMsg);
    }

    @Then("{string} message should be displaye")
    public void messageShouldBeDisplaye(String expectedMsg) {
        loginPage.errorMessage(expectedMsg);
    }


    @When("User enters valid username <username>")
    public void userEntersValidUsernameUsername(String username) {
        loginPage.username.sendKeys(username);
    }

    @And("User enters valid password <password>")
    public void userEntersValidPasswordPassword(String password) {
        loginPage.password.sendKeys(password);
    }

    @Then("User should see {string} displayed on Products page and log out")
    public void userShouldSeeDisplayedOnProductsPageAndLogOut(String expectedTitle) {
        Assert.assertEquals(expectedTitle,productPage.productTitle.getText());
        productPage.logOut();

    }

    @When("User enters valid username uppercase {string}")
    public void userEntersValidUsernameUppercase(String USERNAMES) {
        loginPage.username.sendKeys(USERNAMES);
    }

    @Then("{string} message should be displayeed")
    public void messageShouldBeDisplayeed(String expectedMsg) {
        loginPage.errorMessage(expectedMsg);
    }
}
