package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import utils.Urls;

public class Catalogue extends BasePage {

    public Catalogue(WebDriver driver) {
        super(driver);
    }

    private final static class Locators {
        static final By categories = By.xpath("//*[@id='af_form']/div[1]/div[1]");
        static final By price = By.xpath("//*[@id='af_form']/div[2]/div[1]");
        static final By company = By.xpath("//*[@id='af_form']/div[3]/div[1]");
        static final By color = By.xpath("//*[@id='af_form']/div[4]/div[1]");
        static final By value = By.xpath("//*[@id='af_form']/div[5]/div[1]");
        static final By skinType = By.xpath("//*[@id='af_form']/div[6]/div[1]");
        static final By age = By.xpath("//*[@id='af_form']/div[7]/div[1]");
        static final By purpose = By.xpath("//*[@id='af_form']/div[8]/div[1]");
        static final By component = By.xpath("//*[@id='af_form']/div[9]/div[1]");
        static final By country = By.xpath("//*[@id='af_form']/div[10]/div[1]");

        static final By saleMarathon = By.id("category-141");
        static final By amountOfDiscount = By.xpath("//*[@id='js-product-list']/div[1]/article[1]/div/div[1]/div/a[1]/span[1]");
        static final By isThereAnyDiscount = By.xpath("//*[@id='content']/ul/li");

        static final By filter1 = By.id("c-13");
        static final By filter2 = By.id("m-24");
        static final By filter3 = By.id("a-289");
        static final By filter4 = By.id("f-43");
        static final By chosenFilters =By.xpath("//*[@id='main']/div[2]");
        static final By filterResult =By.xpath("//*[@id='js-product-list-top']/div[1]/p");
    }

    public Catalogue openCataloguePage() {
        driver.get(Urls.shopCatalogue);
        return this;
    }

    public Catalogue firstPartOfPage() {
        workWithElements.click(Locators.categories);
        workWithElements.click(Locators.price);
        workWithElements.click(Locators.company);
        workWithElements.click(Locators.color);
        workWithElements.click(Locators.value);
        workWithElements.click(Locators.skinType);
        return this;
    }

    public Catalogue scroll() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0, 200)");
        return this;
    }

    public Catalogue secondPartOfPage() {
        workWithElements.click(Locators.age);
        workWithElements.click(Locators.purpose);
        workWithElements.click(Locators.component);
        workWithElements.click(Locators.country);
        return this;
    }

    public Catalogue openSaleCategory() {
        workWithElements.click(Locators.saleMarathon);
        return this;
    }

    public Catalogue checkTheDifferenceInPrice() {
        String amount = workWithElements.returnTextFromElement(Locators.amountOfDiscount);
        System.out.println(amount);
        workWithElements.click(Locators.amountOfDiscount);
        return this;
    }

    public Catalogue discountInfo() {
        String amount = workWithElements.returnTextFromElement(Locators.isThereAnyDiscount);
        System.out.println(amount);
        return this;
    }

    public Catalogue filter1 (){
        workWithElements.click(Locators.filter1);
        return this;
    }
    public Catalogue filter2 (){
        workWithElements.click(Locators.filter2);
        return this;
    }
    public Catalogue filter3 (){
        workWithElements.click(Locators.filter3);
        return this;
    }
    public Catalogue filter4 (){
        workWithElements.click(Locators.filter4);
        return this;
    }

    public Catalogue filterResult (){
        String chFil = workWithElements.returnTextFromElement(Locators.chosenFilters);
        System.out.println(chFil);
        return this;
    }

    public Catalogue checkResults (){
        String actualResult = workWithElements.returnTextFromElement(Locators.filterResult);
        String expectedResult = "Є 1товар.";
        if (actualResult.equals(expectedResult)){
            System.out.println("Тестування успішне");
        }else {
            System.out.println("Результат тестування не відповідає дійсності");
            System.out.println(actualResult);
        }
        /* boolean res= actualResult.equals(expectedResult);
        System.out.println(res);*/
        return this;
    }
}
