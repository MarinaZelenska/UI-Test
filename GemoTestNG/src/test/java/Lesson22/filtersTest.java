package Lesson22;

import DemoUI.BaseUITestFile;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class filtersTest extends BaseUITestFile {


    @Test
    public void positiveSelectMakeTest() {
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
        WebElement filterLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Мобильные телефоны']")));
        filterLink.click();
        WebElement appleElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='Apple']")));
        appleElement.click();

        WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
        WebElement honorElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='Honor']")));
        honorElement.click();

        List<WebElement> goods = driver.findElements(By.xpath("//a[@class='goods-tile__heading']//span[contains(text(),'Samsung') or contains(text(),'Apple') or contains(text(),'Honor')]"));
        List<WebElement> allItems = driver.findElements(By.cssSelector("span[class='goods-tile__title']"));

        assertEquals(goods.size(), allItems.size());


    }


    @Test
    public void positiveSelectPriceTest() {
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
        WebElement filterLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Мобильные телефоны']")));
        filterLink.click();

        WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));
        WebElement minPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[formcontrolname='min']")));
        minPrice.clear();
        minPrice.sendKeys("5000");
        WebElement maxPrice = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("input[formcontrolname='max']")));
        maxPrice.clear();
        maxPrice.sendKeys("15000");
        driver.findElement(By.xpath("//button[contains(text(), 'Ok')]")).click();

        WebElement image = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='goods-tile__picture']//img")));


        List<WebElement> itemsContainsFilter = driver.findElements(By.xpath("//span[@class='goods-tile__price-value']"));
        int count;

        for (count = 1; count <= itemsContainsFilter.size(); count++) {
            String price = driver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            assertTrue(priceFiltered > 5000);
            assertTrue(priceFiltered < 15000);
        }


    }


    @Test
    public void positiveSelectSeriesTest() {
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.name("search")).sendKeys("samsung" + Keys.ENTER);
        WebElement filterLink = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='Мобильные телефоны']")));
        filterLink.click();

        WebElement img = wait.until(ExpectedConditions.presenceOfElementLocated(By.tagName("img")));

        WebElement readyForDelivery = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[@for='Готов к отправке ']")));
        readyForDelivery.click();


        WebElement image = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[@class='goods-tile__picture']//img")));


        List<WebElement> allGoods = driver.findElements(By.cssSelector("span[class='goods-tile__title']"));
        List<WebElement> selectedSeriesGoods = driver.findElements(By.xpath("//div[@class='goods-tile__availability goods-tile__availability_type_available' or @class='goods-tile__availability goods-tile__availability_type_limited']"));

        assertEquals(allGoods.size(), selectedSeriesGoods.size());


    }


}
