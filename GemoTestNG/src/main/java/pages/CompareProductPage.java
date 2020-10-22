package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompareProductPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public CompareProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,5);
    }

    By waitImageComparePage = By.xpath("//div[@class='product__picture']");

    public void waitImageComparePage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(waitImageComparePage));
    }
}
