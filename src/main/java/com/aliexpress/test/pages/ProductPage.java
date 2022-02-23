package com.aliexpress.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class ProductPage extends BasePage {

    @FindBy(css = ".product-quantity-tip span")
    protected WebElement quantityProducts;

    public Integer getQuantityProductsAvailable() {
        String numberTxt = this.quantityProducts.getText()
                .replaceAll("[^0-9]", "");
        return Integer.parseInt(numberTxt);
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> this.quantityProducts.isDisplayed());
    }

}
