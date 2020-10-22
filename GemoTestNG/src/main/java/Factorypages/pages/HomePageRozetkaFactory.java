package Factorypages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class HomePageRozetkaFactory {
    WebDriver webDriver;
    WebDriverWait wait;

    public HomePageRozetkaFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,5);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//aside//a[contains(@href,'computers-notebooks')]")
    WebElement selectCategory;
    @FindBy(linkText = "Мониторы")
    WebElement linkSelectProductInCategory;
    @FindBy(name = "search")
    WebElement searchQuery;
    @FindBy(xpath = "//aside//a[contains(@href,'computers-notebooks')]")
    WebElement hoverCategory;


    public void waitSelectCategoryInMenu(){
        wait.until(visibilityOf(selectCategory));
    }



    public void waitProductInCategory(){
        wait.until(visibilityOf(linkSelectProductInCategory));

    }

    public void selectSubCategory(){
        linkSelectProductInCategory.click();

    }

    public void searchQuery(String text){
        searchQuery.sendKeys(text + Keys.ENTER);
    }


    public void hoverElement(){
        WebElement menu = hoverCategory;
        Actions actions = new Actions(webDriver);
        actions.moveToElement(menu).build().perform();
    }






}
