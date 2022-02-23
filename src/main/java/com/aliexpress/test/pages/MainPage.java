package com.aliexpress.test.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
public class MainPage extends BasePage {

    @FindBy(css = ".categories")
    protected WebElement categories;

    public void goTo(String url) {
        driver.get(url);
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> this.categories.isDisplayed());
    }

}
