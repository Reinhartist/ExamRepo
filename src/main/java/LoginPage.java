import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {
    @FindBy(id = "txtUsername")
    WebElement username;

    @FindBy(id = "txtPassword")
    WebElement password;

    public void login(String user, String pass) {
        username.sendKeys(user);
        password.sendKeys(pass);
        username.submit();
    }
}
