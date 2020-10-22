package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DetailProductPage {
    WebDriver webDriver;
    WebDriverWait wait;

    public DetailProductPage(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,5);
    }


    By tabOnDetailPage = By.xpath("//a[@class='tabs__link tabs__link--active']");
    By compareIcon = By.xpath("//button[@class='compare-button']");
    By imageDetailPage = By.xpath("//figure[@class='product-photo__large-inner']");
    By checkProductWasAddedOnCompare = By.xpath("//button//span[contains(text(), '1')]");
    By checkSecondProductWasAddedOnCompare = By.xpath("//button//span[contains(text(), '2')]");
    By clickCompareIconMenu = By.xpath("//button[@class='header-actions__button header-actions__button_type_compare header-actions__button_state_active']");
    By checkCountMonitors = By.xpath("//a[@class='comparison-modal__link']//span[contains(text(), '2')]");
    By clickLinkForRedirectOnDetailComparePage = By.xpath("//a[@class='comparison-modal__link']");


    public void waitTabOnDetailPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(tabOnDetailPage));

    }

    public void waitCompareIcon(){
        wait.until(ExpectedConditions.presenceOfElementLocated(compareIcon));

    }


    public void clickCompareIcon(){
        webDriver.findElement(compareIcon).click();

    }

    public void waitImageDetailPage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(imageDetailPage));

    }

    public void checkProductWasAddedOnCompare(){
        wait.until(ExpectedConditions.presenceOfElementLocated(checkProductWasAddedOnCompare));

    }

    public void checkSecondProductWasAddedOnCompare(){
        wait.until(ExpectedConditions.presenceOfElementLocated(checkSecondProductWasAddedOnCompare));

    }

    public void checkMenuCompareIconIsClickable(){
        webDriver.findElement(clickCompareIconMenu).click();

    }

    public void checkCountMonitorsInCompareMenu(){
        wait.until(ExpectedConditions.presenceOfElementLocated(checkCountMonitors));

    }

    public void clickLinkForRedirectOnDetailComparePage(){
        webDriver.findElement(clickLinkForRedirectOnDetailComparePage).click();

    }
}
