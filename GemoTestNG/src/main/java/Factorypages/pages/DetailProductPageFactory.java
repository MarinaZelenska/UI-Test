package Factorypages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class DetailProductPageFactory {
    WebDriver webDriver;
    WebDriverWait wait;

    public DetailProductPageFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,5);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//a[@class='tabs__link tabs__link--active']")
    WebElement tabOnDetailPage;
    @FindBy(xpath = "//button[@class='compare-button']")
    WebElement compareIcon;
    @FindBy(xpath = "//figure[@class='product-photo__large-inner']")
    WebElement imageDetailPage;
    @FindBy(xpath = "//button//span[contains(text(), '1')]")
    WebElement checkProductWasAddedOnCompare;
    @FindBy(xpath = "//button//span[contains(text(), '2')]")
    WebElement checkSecondProductWasAddedOnCompare;
    @FindBy(xpath = "//button[@class='header-actions__button header-actions__button_type_compare header-actions__button_state_active']")
    WebElement clickCompareIconMenu;
    @FindBy(xpath = "//a[@class='comparison-modal__link']//span[contains(text(), '2')]")
    WebElement checkCountMonitors;
    @FindBy(xpath = "//a[@class='comparison-modal__link']//span[contains(text(), '2')]")
    WebElement clickLinkForRedirectOnDetailComparePage;


    public void waitTabOnDetailPage(){
        wait.until(visibilityOf(tabOnDetailPage));

    }

    public void waitCompareIcon(){
        wait.until(visibilityOf(compareIcon));

    }


    public void clickCompareIcon(){
        compareIcon.click();

    }

    public void waitImageDetailPage(){
        wait.until(visibilityOf(imageDetailPage));

    }

    public void checkProductWasAddedOnCompare(){
        wait.until(visibilityOf(checkProductWasAddedOnCompare));

    }

    public void checkSecondProductWasAddedOnCompare(){
        wait.until(visibilityOf(checkSecondProductWasAddedOnCompare));

    }

    public void checkMenuCompareIconIsClickable(){
        clickCompareIconMenu.click();

    }

    public void checkCountMonitorsInCompareMenu(){
        wait.until(visibilityOf(checkCountMonitors));

    }

    public void clickLinkForRedirectOnDetailComparePage(){
       clickLinkForRedirectOnDetailComparePage.click();

    }
}
