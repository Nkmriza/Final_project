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
        personalAccount.submit();
    }
}