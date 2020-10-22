package Factorypages.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class ProductGridRozetkaFactory {
    WebDriver webDriver;
    WebDriverWait wait;

    public ProductGridRozetkaFactory(WebDriver webDriver) {
        this.webDriver = webDriver;
        this.wait = new WebDriverWait(webDriver, 5);
        PageFactory.initElements(webDriver,this);
    }

    @FindBy(xpath = "//a[@class='goods-tile__picture']//img")
    WebElement productImage;
    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    List<WebElement> productPriceValue;
    @FindBy(xpath = "//span[text()='Мобильные телефоны']")
    WebElement checkboxCategoryforFilter;
    @FindBy(xpath = "//label[@for='Apple']")
    WebElement waitAppleElement;
    @FindBy(tagName = "img")
    WebElement image;
    @FindBy(xpath = "//label[@for='Huawei']")
    WebElement waitHuaweiElement;
    @FindBy(xpath = "//a[@class='goods-tile__heading']//span[contains(text(),'Samsung') or contains(text(),'Apple') or contains(text(),'Huawei')]")
    List<WebElement> selectedGoods;
    @FindBy(css = "span[class='goods-tile__title']")
    List<WebElement> allItems;
    @FindBy(css = "input[formcontrolname='min']")
    WebElement selectMinPrice;
    @FindBy(css = "input[formcontrolname='max']")
    WebElement selectMaxPrice;
    @FindBy(xpath = "//button[contains(text(), 'Ok')]")
    WebElement buttonOk;
    @FindBy(xpath = "//a[@class='goods-tile__picture']//img")
    WebElement downloadPictureAfterSelectedLimit;
    @FindBy(xpath = "//span[@class='goods-tile__price-value']")
    List<WebElement> getAllPricesAfterSelectedLimitPrice;
    @FindBy(xpath = "//label[@for='Готов к отправке ']")
    WebElement readyForDelivery;
    @FindBy(xpath = "//div[@class='goods-tile__availability goods-tile__availability_type_available' or @class='goods-tile__availability goods-tile__availability_type_limited']")
    List<WebElement> selectedSeriesGoods;
    @FindBy(xpath = "//p[@class='product-prices__big product-prices__big_color_red']")
    WebElement firstElementPrice;
    @FindBy(xpath = "//h1[@class='product__title']")
    WebElement firstName;
    @FindBy(xpath = "//p[@class='product-prices__big product-prices__big_color_red']")
    WebElement secondElementPrice ;
    @FindBy(xpath = "//h1[@class='product__title']")
    WebElement secondName;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[1]//*[@class = 'product__prices']/div")
    WebElement priceInCompareMenufirst;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[1]//*[@class = 'product__body']/div/a")
    WebElement nameComparePageFirst;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[2]//*[@class = 'product__prices']/div")
    WebElement priceInCompareMenuSecond;
    @FindBy(xpath = "//ul[@class = 'products-grid']//li[2]//*[@class = 'product__body']/div/a")
    WebElement nameComparePageSecond;

    public void waitProductImage() {
        wait.until(visibilityOf(productImage));

    }

    private List<WebElement> getAllPricesInPage() {
        return productPriceValue;
    }

    public void findSuitablePrice(int filteredConditions) {
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
        wait.until(visibilityOf(checkboxCategoryforFilter));

    }

    public void clickCheckboxCategoryforFilter(){
        checkboxCategoryforFilter.click();

    }


    public void waitAppleElement(){
        wait.until(visibilityOf(waitAppleElement));

    }

    public void clickAppleElement(){
        waitAppleElement.click();

    }

    public void waitDownloadImage(){
        wait.until(visibilityOf(image));

    }

    public void waitHuaweiElement(){
        wait.until(visibilityOf(waitHuaweiElement));

    }

    public void clickHuaweiElement(){
        waitHuaweiElement.click();

    }


    public List<WebElement> getSelectedGoods(){
        return selectedGoods;
    }

    public List<WebElement> getAllItems(){
        return allItems;
    }

    public void waitMinPrice(){
        wait.until(visibilityOf(selectMinPrice));

    }

    public void waitMaxPrice(){
        wait.until(visibilityOf(selectMaxPrice));

    }

    public void clearMinPrice(){
        selectMinPrice.clear();

    }

    public void clearMaxPrice(){
        selectMaxPrice.clear();

    }

    public void addValueMinPrice(String minPrice){
        selectMinPrice.sendKeys(minPrice);

    }

    public void addValueMaxPrice(String maxPrice){
        selectMaxPrice.sendKeys(maxPrice);

    }

    public void buttonOk(){
       buttonOk.click();

    }

    public void downloadPictureAfterSelectedLimit(){
        wait.until(visibilityOf(downloadPictureAfterSelectedLimit));

    }


    public List<WebElement> getAllPricesAfterSelectedLimitPrice(){
        return getAllPricesAfterSelectedLimitPrice;
    }

    public void waitReadyForDelivery(){
        wait.until(visibilityOf(readyForDelivery));
    }

    public void clickReadyForDelivery(){
        readyForDelivery.click();
    }

    public List<WebElement> selectedSeriesGoods(){
        return selectedSeriesGoods;
    }

    public String selectFirstElementPrice(){
        String firstPrice  = firstElementPrice.getText().replaceAll("\\s", "").replaceAll("₴", "");
        return firstPrice;
    }

    public String selectFirstName(){
        String firstNameSelected  = firstName.getText();
        return firstNameSelected;
    }

    public String selectSecondElementPrice(){
        String secondPrice  = secondElementPrice.getText().replaceAll("\\s", "").replaceAll("₴", "");
        return secondPrice;
    }


    public String selectSecondName(){
        String firstSecondSelected  = secondName.getText();
        return firstSecondSelected;
    }

    public String selectPriceCompareMenuFirst(){
        String menuFirstPrice  = priceInCompareMenufirst.getText().replaceAll(" +", "").replaceAll("₴", "");
        return menuFirstPrice;
    }


    public String selectPageCompareFirstName(){
        String firstPageCompareName  = nameComparePageFirst.getText();
        return firstPageCompareName;
    }

    public String selectPriceInCompareMenuSecond(){
        String menuSecondPrice  = priceInCompareMenuSecond.getText().replaceAll(" +", "").replaceAll("₴", "");
        return menuSecondPrice;
    }


    public String selectPageCompareSecondName(){
        String secondPageCompareName  = nameComparePageSecond.getText();
        return secondPageCompareName;
    }





}
