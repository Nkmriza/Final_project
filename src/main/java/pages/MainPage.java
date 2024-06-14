package pages;

import functions.WorkWithElements;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import utils.Urls;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    private final static class Locators {
        static final By searchField1 = By.xpath("//*[@id='search_widget']/form/input[2]");
        static final By searchItemPopUp = By.xpath("//*[@id='ui-id-1']/li[1]");
        static final By lastSlide = By.xpath("//*[@id='homepage-slider']/div/div[2]/div[1]/div[5]/a");
        static final By lastSlideImage = By.xpath("/html/body/main/div/div[1]/div/div/div[1]/ul/li[6]/a/img");
        static final By nameOfPageFromAdv = By.cssSelector("#category_desc > div.category-desc > h1");
        static final By partnership = By.xpath("//*[@id='parallax_baner']/a");
        static final By toMainPage = By.linkText("На Головну");
        static final By searchBot1 = By.cssSelector("#search_widget > form > button");
        static final By result = By.xpath("//*[@id='content']/div[1]");
        static final By searchField2 = By.xpath("/html/body/main/section/div[1]/div/div[2]/section/section/section[1]/div[2]/div/form/input[2]");
        static final By searchBot2 = By.xpath("/html/body/main/section/div[1]/div/div[2]/section/section/section[1]/div[2]/div/form/button/i");
        static final By selectFace = By.xpath("/html/body/main/header/div[3]/ul/li[2]/a");
        static final By sunCream = By.id("category-100");
        static final By cleanser = By.id("category-18");
        static final By enzymePowder = By.id("category-111");
        static final By resultOfSelectedPageForEnzyme = By.id("category_desc");
    }

    public MainPage openMainPage() {
        driver.get(Urls.onlineShopping);
        return this;
    }

    public MainPage searchForItem(String itemName) {
        workWithElements.sendKeys(Locators.searchField1, itemName);
        return this;
    }

    public MainPage clickOnSearchItemPopUp() {
        workWithElements.click(Locators.searchItemPopUp);
        return this;
    }

    public MainPage clickOnLastSlide() {
        workWithElements.click(Locators.lastSlide);
        return this;
    }

    public MainPage clickOnLastSlideImage() {
        workWithElements.click(Locators.lastSlideImage);
        return this;
    }

    public String getNameOfPageFromAdv() {
        workWithElements.returnTextFromElement(Locators.nameOfPageFromAdv);
        String pageName = workWithElements.returnTextFromElement(Locators.nameOfPageFromAdv);
        System.out.println("текст зі сторінки: "+ pageName);
        String expectedPageName = "Патчі 1+1";
        if (pageName.equals(expectedPageName)) {
            System.out.println("Тест пройдено!");
        } else {
            System.out.println("Помилка. Слайд не відповідає тексту.");
        }
        return pageName;
    }

    public MainPage clickOnPartnership() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        workWithElements.click(Locators.partnership);
        return this;
    }

    public MainPage clickOnToMainPage() {
        workWithElements.click(Locators.toMainPage);
        return this;
    }

    public MainPage enterTextToSearchField1(String text) {
        workWithElements.sendKeys(Locators.searchField1, text);
        return this;
    }

    public MainPage clickOnSearchBot1() {
        workWithElements.click(Locators.searchBot1);
        return this;
    }

    public String getResultText() {
        String result =  workWithElements.returnTextFromElement(Locators.result);
        System.out.println(result);
        return result;
    }

    public MainPage enterTextToSearchField2(String text) {
        workWithElements.clear(Locators.searchField2);
        workWithElements.sendKeys(Locators.searchField2, text);
        return this;
    }

    public MainPage clickOnSearchBot2() {
        workWithElements.click(Locators.searchBot2);
        return this;
    }

    public MainPage moveToSelectFace() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Locators.selectFace)).perform();
        return this;
    }

    public MainPage clickOnSunCream() {
        workWithElements.click(Locators.sunCream);
        return this;
    }

   public MainPage moveToAnotherCategory() {
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(Locators.selectFace)).perform();
        actions.moveToElement(driver.findElement(Locators.cleanser)).perform();
        workWithElements.click(Locators.enzymePowder);
        String result = workWithElements.returnTextFromElement(Locators.resultOfSelectedPageForEnzyme);
       System.out.println(result);
        return this;
    }
}
