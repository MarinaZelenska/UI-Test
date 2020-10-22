package Factorypages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareProductPageFactory {
    WebDriver webDriver;
    WebDriverWait wait;

    public CompareProductPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,5);
        PageFactory.initElements(webDriver,this);
    }
    @FindBy(xpath = "//div[@class='product__picture']")
    WebElement waitImageComparePage;

    public void waitImageComparePage(){
        wait.until(ExpectedConditions.visibilityOf(waitImageComparePage));
    }
}
