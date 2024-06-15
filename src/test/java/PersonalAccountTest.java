import pages.BasePage;
import org.testng.annotations.Test;
import pages.PersonalAccount;

public class PersonalAccountTest extends BaseTest {


    @Test
    public void createAccountTest() {
        PersonalAccount personalAccount = new PersonalAccount(driver);
        personalAccount.logInPage()
                .createAccount()
                .nameField("name")
                .surnameField("surname")
                .emailField("mail@mail.com")
                .createPassword("123456")
                .confirmPassword("654321")
                .save()
                .checkIfThereAnyError();
    }

    @Test
    public void logIn() throws InterruptedException {
        PersonalAccount personalAccount = new PersonalAccount(driver);
        personalAccount.logInPage()
                .writeEmail("lizasamsung98@gmail.com")
                .writePassword("123456")
                .submit()
                .errorLogIn()
                .writePassword("qwerty")
                .showPassword();
        Thread.sleep(1000);
        personalAccount.submit()
                .exit();
    }

    @Test
    public void changeNameTest() throws InterruptedException {
        PersonalAccount personalAccount = new PersonalAccount(driver);
        personalAccount.logInPage()
                .writeEmail("lizasamsung98@gmail.com")
                .writePassword("qwerty")
                .submit()
                .infoAboutCustomer();
        Thread.sleep(1000);
        personalAccount.changeNameClear();
        Thread.sleep(1000);
        personalAccount.changeName("Name")
                .changeSurnameCLear();
        Thread.sleep(1000);
        personalAccount.changeSurname("Surname")
                .saveChanges()
                .returnToCab()
                .exit();
    }

    @Test
    public void languageCheck (){
        PersonalAccount personalAccount = new PersonalAccount(driver);
        personalAccount.logInPage()
                .writeEmail("lizasamsung98@gmail.com")
                .writePassword("qwerty")
                .submit()
                .clickOnHistory()
                .checkLanguageForHistory()
                .exit();
    }
}