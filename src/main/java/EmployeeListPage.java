import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class EmployeeListPage {
    @FindBy(id = "employee_name_quick_filter_employee_list_value")
    private WebElement search_bar;

    @FindBy(xpath = "//*[@id=\"employeeListTable\"]/tbody/tr/td[2]")
    private WebElement first_user;

    public void search_for_user(WebDriverWait wait, String user) {
        search_bar.sendKeys(user);
        wait.until(ExpectedConditions.textToBe(By.xpath("//*" +
                        "[@id=\"employee_name_quick_filter_employee_list_dropdown\"]/div[3]/span[1]"),
                Constants.first_name + " " + Constants.middle_name + " " + Constants.last_name));
        search_bar.sendKeys(Keys.ENTER);
    }

    public void inspect_user() {
        first_user.click();
    }
}
