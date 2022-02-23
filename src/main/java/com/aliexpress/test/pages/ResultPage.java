package com.aliexpress.test.pages;

import com.aliexpress.test.pages.component.HeaderComponent;
import lombok.Getter;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
public class ResultPage extends BasePage {

    @FindBy(css = ".top-container")
    private WebElement topContainer;
    @FindBy(css = ".JIIxO a._3t7zg")
    private List<WebElement> productList;
    @Autowired
    private HeaderComponent headerComponent;

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
