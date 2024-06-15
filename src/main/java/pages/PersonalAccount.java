package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import utils.Urls;

public class PersonalAccount extends BasePage {
    public PersonalAccount(WebDriver driver) {
        super(driver);
    }

    private final static class Locators {
        static final By createAccount = By.xpath("//*[@id='content']/div/a");
        static final By name = By.id("customer_firstname");
        static final By surname = By.id("customer_lastname");
        static final By email = By.id("customer_email");
        static final By password = By.id("customer_passwd");
        static final By repeatPassword = By.id("customer_conf_passwd");
        static final By saveButton = By.id("btn_save_customer");
        static final By errorMessage = By.xpath("//*[@id='field_customer_conf_passwd']/span");

        static final By emailField = By.xpath("//*[@id='login-form']/section/div[1]/div[1]/input");
        static final By passwordField = By.xpath("//*[@id='login-form']/section/div[2]/div[1]/div/input");
        static final By submitLogIn = By.id("submit-login");
        static final By errorForLogIn = By.xpath("//*[@id='content']/section/div/ul/li");
        static final By showPassword = By.xpath("//*[@id='login-form']/section/div[2]/div[1]/div/span/button");
        static final By exit = By.xpath("//*[@id='_desktop_user_info']/div/div/a[2]");

        static final By info = By.xpath("//*[@id='identity-link']/span");
        static final By changeName = By.id("customer_firstname");
        static final By changeSurname = By.id("customer_lastname");
        static final By saveChanges = By.xpath("/html/body/section/div/section/div/div[3]/div[3]/div[1]/div/div/div/button");
        static final By backByNameOnTheTop = By.xpath("//*[@id='_desktop_user_info']/div/div/a[1]");


    }

    public PersonalAccount logInPage() {
        driver.get(Urls.logIn);
        return this;
    }

    public PersonalAccount createAccount() {
        workWithElements.click(Locators.createAccount);
        return this;
    }

    public PersonalAccount nameField(String name) {
        workWithElements.sendKeys(Locators.name, name);
        return this;
    }

    public PersonalAccount surnameField(String surname) {
        workWithElements.sendKeys(Locators.surname, surname);
        return this;
    }

    public PersonalAccount emailField(String email) {
        workWithElements.sendKeys(Locators.email, email);
        return this;
    }

    public PersonalAccount createPassword(String password) {
        workWithElements.sendKeys(Locators.password, password);
        return this;
    }

    public PersonalAccount confirmPassword(String password2) {
        workWithElements.sendKeys(Locators.repeatPassword, password2);
        return this;
    }

    public PersonalAccount save() {
        workWithElements.click(Locators.saveButton);
        return this;
    }

    public PersonalAccount checkIfThereAnyError() {
        String actualResult = workWithElements.returnTextFromElement(Locators.errorMessage);
        System.out.println(actualResult);
        String expectedResult = "The values do not match.";
        if (actualResult.equals(expectedResult)) {
            System.out.println("Тест успішний. Виникла помилка невідповідності паролей");
        } else {
            System.out.println("Тест не пройдено. Помилка в реєстрації");
        }
        return this;
    }

    public PersonalAccount writeEmail(String email) {
        workWithElements.sendKeys(Locators.emailField, email);
        return this;

    }

    public PersonalAccount writePassword(String password) {
        workWithElements.sendKeys(Locators.passwordField, password);
        return this;
    }

    public PersonalAccount submit() {
        workWithElements.click(Locators.submitLogIn);
        return this;
    }

    public PersonalAccount errorLogIn() {
        String actualResult = workWithElements.returnTextFromElement(Locators.errorForLogIn);
        System.out.println(actualResult);
        return this;
    }

    public PersonalAccount showPassword() {
        workWithElements.click(Locators.showPassword);
        return this;
    }

    public PersonalAccount exit() {
        workWithElements.click(Locators.exit);
        return this;
    }

    public PersonalAccount infoAboutCustomer() {
        workWithElements.click(Locators.info);
        return this;
    }

    public PersonalAccount changeNameClear() {
        workWithElements.clear(Locators.changeName);
        return this;
    }

    public PersonalAccount changeName(String newName) {
        workWithElements.sendKeys(Locators.changeName, newName);
        return this;
    }

    public PersonalAccount changeSurnameCLear() {
        workWithElements.clear(Locators.changeSurname);

        return this;
    }

    public PersonalAccount changeSurname(String newSurname) {
        workWithElements.sendKeys(Locators.changeSurname, newSurname);
        return this;
    }

    public PersonalAccount saveChanges() {
        workWithElements.click(Locators.saveChanges);
        return this;
    }

    public PersonalAccount returnToCab() {
        workWithElements.click(Locators.backByNameOnTheTop);
        return this;
    }

}
