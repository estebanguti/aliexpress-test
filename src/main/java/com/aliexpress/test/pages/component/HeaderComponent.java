package com.aliexpress.test.pages.component;

import com.aliexpress.test.pages.BasePage;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class HeaderComponent extends BasePage {

    @FindBy(id = "search-key")
    protected WebElement searchInput;
    @FindBy(css = ".search-button")
    protected WebElement searchBtn;

    public void searchProduct(String searchKey) {
        this.searchInput.sendKeys(searchKey);
        this.searchBtn.submit();
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> this.searchInput.isDisplayed());
    }

}
