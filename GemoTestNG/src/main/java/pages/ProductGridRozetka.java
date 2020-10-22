package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class ProductGridRozetka {
    WebDriver webDriver;
    WebDriverWait wait;

    public ProductGridRozetka(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver,5);
        PageFactory.initElements(webDriver,this);
    }

    By productImage = By.xpath("//a[@class='goods-tile__picture']//img");
    By productPriceValue = By.xpath("//span[@class='goods-tile__price-value']");
    By checkboxCategoryforFilter = By.xpath("//span[text()='Мобильные телефоны']");
    By waitAppleElement = By.xpath("//label[@for='Apple']");
    By image = By.tagName("img");
    By waitHuaweiElement = By.xpath("//label[@for='Huawei']");
    By selectedGoods = By.xpath("//a[@class='goods-tile__heading']//span[contains(text(),'Samsung') or contains(text(),'Apple') or contains(text(),'Huawei')]");
    By allItems = By.cssSelector("span[class='goods-tile__title']");
    By selectMinPrice = By.cssSelector("input[formcontrolname='min']");
    By selectMaxPrice = By.cssSelector("input[formcontrolname='max']");
    By buttonOk = By.xpath("//button[contains(text(), 'Ok')]");
    By downloadPictureAfterSelectedLimit = By.xpath("//a[@class='goods-tile__picture']//img");
    By getAllPricesAfterSelectedLimitPrice = By.xpath("//span[@class='goods-tile__price-value']");
    By readyForDelivery = By.xpath("//label[@for='Готов к отправке ']");
    By selectedSeriesGoods = By.xpath("//div[@class='goods-tile__availability goods-tile__availability_type_available' or @class='goods-tile__availability goods-tile__availability_type_limited']");
    By firstElementPrice = By.xpath("//p[@class='product-prices__big product-prices__big_color_red']");
    By firstName = By.xpath("//h1[@class='product__title']");
    By secondElementPrice = By.xpath("//p[@class='product-prices__big product-prices__big_color_red']");
    By secondName = By.xpath("//h1[@class='product__title']");
    By priceInCompareMenufirst = By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div");
    By nameComparePageFirst = By.xpath("//ul[@class = 'products-grid']//li[1]//*[@class = 'product__body']/div/a");
    By priceInCompareMenuSecond = By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div");
    By nameComparePageSecond = By.xpath("//ul[@class = 'products-grid']//li[2]//*[@class = 'product__body']/div/a");



    public void waitProductImage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(productImage));

    }


    private List<WebElement> getAllPricesInPage(){
        return webDriver.findElements(productPriceValue);
    }

    public void findSuitablePrice(int filteredConditions){
        List<WebElement> prices = getAllPricesInPage();
        int count;

        for (count = 1; count <= prices.size(); count++) {
            String price = webDriver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//span[@class='goods-tile__price-value']")).getText().replaceAll("\\s", "");
            int priceFiltered = Integer.parseInt(price);
            if (priceFiltered < filteredConditions) {
                webDriver.findElement(By.xpath("//ul[@class='catalog-grid']//li[" + count + "]//a[@class='goods-tile__picture']")).click();
                break;
            }
        }
    }


    public void waitCheckboxCategoryforFilter(){
        wait.until(ExpectedConditions.presenceOfElementLocated(checkboxCategoryforFilter));

    }

    public void clickCheckboxCategoryforFilter(){
        webDriver.findElement(checkboxCategoryforFilter).click();

    }


    public void waitAppleElement(){
        wait.until(ExpectedConditions.presenceOfElementLocated(waitAppleElement));

    }

    public void clickAppleElement(){
        webDriver.findElement(waitAppleElement).click();

    }

    public void waitDownloadImage(){
        wait.until(ExpectedConditions.presenceOfElementLocated(image));

    }

    public void waitHuaweiElement(){
        wait.until(ExpectedConditions.presenceOfElementLocated(waitHuaweiElement));

    }

    public void clickHuaweiElement(){
        webDriver.findElement(waitHuaweiElement).click();

    }

    public List<WebElement> getSelectedGoods(){
        return webDriver.findElements(selectedGoods);
    }

    public List<WebElement> getAllItems(){
        return webDriver.findElements(allItems);
    }

    public void waitMinPrice(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selectMinPrice));

    }

    public void waitMaxPrice(){
        wait.until(ExpectedConditions.presenceOfElementLocated(selectMaxPrice));

    }

    public void clearMinPrice(){
        webDriver.findElement(selectMinPrice).clear();

    }

    public void clearMaxPrice(){
        webDriver.findElement(selectMaxPrice).clear();

    }

    public void addValueMinPrice(String minPrice){
        webDriver.findElement(selectMinPrice).sendKeys(minPrice);

    }

    public void addValueMaxPrice(String maxPrice){
        webDriver.findElement(selectMaxPrice).sendKeys(maxPrice);

    }

    public void buttonOk(){
        webDriver.findElement(buttonOk).click();

    }

    public void downloadPictureAfterSelectedLimit(){
        wait.until(ExpectedConditions.presenceOfElementLocated(downloadPictureAfterSelectedLimit));

    }


    public List<WebElement> getAllPricesAfterSelectedLimitPrice(){
        return webDriver.findElements(getAllPricesAfterSelectedLimitPrice);
    }

    public void waitReadyForDelivery(){
        wait.until(ExpectedConditions.presenceOfElementLocated(readyForDelivery));
    }

    public void clickReadyForDelivery(){
        webDriver.findElement(readyForDelivery).click();
    }

    public List<WebElement> selectedSeriesGoods(){
        return webDriver.findElements(selectedSeriesGoods);
    }

    public String selectFirstElementPrice(){
        String firstPrice  = webDriver.findElement(firstElementPrice).getText().replaceAll("\\s", "").replaceAll("₴", "");
        return firstPrice;
    }

    public String selectFirstName(){
        String firstNameSelected  = webDriver.findElement(firstName).getText();
        return firstNameSelected;
    }

    public String selectSecondElementPrice(){
        String secondPrice  = webDriver.findElement(secondElementPrice).getText().replaceAll("\\s", "").replaceAll("₴", "");
        return secondPrice;
    }


    public String selectSecondName(){
        String firstSecondSelected  = webDriver.findElement(secondName).getText();
        return firstSecondSelected;
    }


    public String selectPriceCompareMenuFirst(){
        String menuFirstPrice  = webDriver.findElement(priceInCompareMenufirst).getText().replaceAll(" +", "").replaceAll("₴", "");
        return menuFirstPrice;
    }


    public String selectPageCompareFirstName(){
        String firstPageCompareName  = webDriver.findElement(nameComparePageFirst).getText();
        return firstPageCompareName;
    }

    public String selectPriceInCompareMenuSecond(){
        String menuSecondPrice  = webDriver.findElement(priceInCompareMenuSecond).getText().replaceAll(" +", "").replaceAll("₴", "");
        return menuSecondPrice;
    }


    public String selectPageCompareSecondName(){
        String secondPageCompareName  = webDriver.findElement(nameComparePageSecond).getText();
        return secondPageCompareName;
    }




}
