package com.aliexpress.test.pages.component;

import com.aliexpress.test.pages.BasePage;
import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.stereotype.Component;

@Component
@Getter
public class PaginationComponent extends BasePage {

    @FindBy(css = ".list-pagination")
    private WebElement body;

    public void nextToPage(Integer page) {
        WebElement element = this.body
                .findElements(By.cssSelector(".next-pagination-list button"))
                .get(page-1);
        element.click();
        this.wait.until((d) -> element.getAttribute("class").contains("next-current"));
    }

    @Override
    public boolean isLoaded() {
        return wait.until((d) -> this.body.isDisplayed());
    }

}
