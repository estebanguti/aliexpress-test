package com.aliexpress.test.stepdefinitions;

import com.aliexpress.test.pages.MainPage;
import com.aliexpress.test.pages.ProductPage;
import com.aliexpress.test.pages.ResultPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

public class SearchProductStepDefinition {

    @Autowired
    private MainPage mainPage;
    @Autowired
    private ResultPage resultPage;
    @Autowired
    private ProductPage productPage;
    @Value("${base.url}")
    private String url;

    @Given("Customer goes to Aliexpress website")
    public void customerGoesToAliExpressWebsite() {
        mainPage.goTo(url);
        Assert.assertTrue(mainPage.isLoaded());
    }

    @When("The customer search the next product {string}")
    public void theCustomerSearchTheNextProduct(String searchKey) {
        mainPage.searchProduct(searchKey);
        Assert.assertTrue(resultPage.isLoaded());
    }

    @When("The customer clicks on product {int}")
    public void theCustomerClickOnProduct(Integer product) {
        resultPage.openProduct(product);
        Assert.assertTrue(productPage.isLoaded());
    }

    @Then("The product should contain available items to buy")
    public void theProductShouldContainAvailableItemsToBuy() {
        Assert.assertTrue(productPage.getQuantityProductsAvailable() > 0);
    }

}
