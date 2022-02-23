package com.aliexpress.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ResultPage extends BasePage {

    @FindBy(css = ".top-container")
    private WebElement topContainer;
    @FindBy(css = ".JIIxO a")
    private List<WebElement> productList;

    public WebElement getProduct(Integer position) {
        return this.productList.get(position-1);
    }

    public void openProduct(Integer position) {
        this.getProduct(position).click();
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> this.topContainer.isDisplayed());
    }

}
