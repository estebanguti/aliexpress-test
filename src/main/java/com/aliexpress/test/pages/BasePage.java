package com.aliexpress.test.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.PostConstruct;

public abstract class BasePage {

    @Autowired
    protected WebDriver driver;
    @Autowired
    protected WebDriverWait wait;
    @FindBy(id = "search-key")
    protected WebElement searchInput;
    @FindBy(css = ".search-button")
    protected WebElement searchBtn;

    @PostConstruct
    public void initialize() {
        PageFactory.initElements(driver, this);
    }

    public void searchProduct(String searchKey) {
        this.searchInput.sendKeys(searchKey);
        this.searchBtn.submit();
    }

    public abstract boolean isLoaded();

}
