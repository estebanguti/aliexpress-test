package com.aliexpress.test.pages;

import com.aliexpress.test.pages.component.HeaderComponent;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
public class MainPage extends BasePage {

    @FindBy(css = ".categories")
    protected WebElement categories;
    @Autowired
    private HeaderComponent headerComponent;

    public void goTo(String url) {
        driver.get(url);
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> this.categories.isDisplayed()
                & this.headerComponent.isLoaded());
    }

}
