import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashboardPage {
    @FindBy(xpath = "//*[@id=\"menu_pim_viewPimModule\"]/a/span[2]")
    private WebElement pim;

    @FindBy(id = "menu_pim_addEmployee")
    private WebElement add_employee;

    public void click_pim() {
        pim.click();
    }

    public void clickAddEmployee(WebDriverWait wait) {
        wait.until(ExpectedConditions.visibilityOf(add_employee));
        add_employee.click();
    }
}
