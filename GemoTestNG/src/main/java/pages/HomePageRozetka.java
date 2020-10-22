package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePageRozetka {
    WebDriver webDriver;
    WebDriverWait wait;

    public HomePageRozetka(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,5);
    }


    By selectCategory = By.xpath("//aside//a[contains(@href,'computers-notebooks')]");
    By linkSelectProductInCategory = By.linkText("Мониторы");
    By searchQuery = By.name("search");
    By hoverCategory = By.xpath("//aside//a[contains(@href,'computers-notebooks')]");


    public void waitSelectCategoryInMenu(){
       wait.until(ExpectedConditions.presenceOfElementLocated(selectCategory));
    }



    public void waitProductInCategory(){
        wait.until(ExpectedConditions.presenceOfElementLocated(linkSelectProductInCategory));

    }

    public void selectSubCategory(){
        webDriver.findElement(linkSelectProductInCategory).click();

    }

    public void searchQuery(String text){
        webDriver.findElement(searchQuery).sendKeys(text + Keys.ENTER);
    }

    public void hoverElement(){
        WebElement menu = webDriver.findElement(hoverCategory);
        Actions actions = new Actions(webDriver);
        actions.moveToElement(menu).build().perform();
    }







}
