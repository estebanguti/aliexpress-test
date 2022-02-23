package com.aliexpress.test.stepdefinitions;

import com.aliexpress.test.pages.MainPage;
import com.aliexpress.test.pages.ProductPage;
import com.aliexpress.test.pages.ResultPage;
import com.aliexpress.test.utils.WebDriverHelper;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.testng.Assert;

import java.util.ArrayList;

public class SearchProductStepDefinition {

    @Autowired
    private MainPage mainPage;
    @Autowired
    private ResultPage resultPage;
    @Autowired
    private ProductPage productPage;
    @Autowired
    private WebDriver driver;
    @Autowired
    private WebDriverHelper webDriverHelper;
    @Value("${base.url}")
    private String url;

    @Given("Customer goes to Aliexpress website")
    public void customerGoesToAliExpressWebsite() {
        mainPage.goTo(url);
        Assert.assertTrue(mainPage.isLoaded());
    }

    @When("The customer search the next product {string}")
    public void theCustomerSearchTheNextProduct(String searchKey) {
        mainPage.getHeaderComponent().searchProduct(searchKey);
        Assert.assertTrue(resultPage.isLoaded());
    }

    @When("The customer goes to Result Page {int}")
    public void theCustomerSearchTheNextProduct(Integer page) {
        webDriverHelper.scrollUntilVisibleElement(resultPage.getPagination().getBody());
        resultPage.getPagination().nextToPage(page);
    }

    @When("The customer clicks on product {int}")
    public void theCustomerClickOnProduct(Integer product) {
        resultPage.openProduct(product);
        ArrayList<String> tabs = new ArrayList<> (driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        Assert.assertTrue(productPage.isLoaded());
    }

    @Then("The product should contain available items to buy")
    public void theProductShouldContainAvailableItemsToBuy() {
        Assert.assertTrue(productPage.getQuantityProductsAvailable() > 0);
    }

    @After
    public void after() {
        driver.quit();
    }

}
