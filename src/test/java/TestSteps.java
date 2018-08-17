import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.TestCase.assertEquals;

public class TestSteps {
    private WebDriver driver;
    private WebDriverWait wait;
    private Actions action;

    private LoginPage loginPage;
    private DashboardPage dashboardPage;
    private AddEmployeePage addEmployeePage;
    private EmployeeListPage employeeListPage;

    private String new_user;
    private String new_user_id;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "C:\\Development\\web_driver\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        wait = new WebDriverWait(driver, 30);
        action = new Actions(driver);

        new_user = HelperFunctions.gen_random_name();
        new_user_id = HelperFunctions.gen_random_id();
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Given("^the login page$")
    public void the_login_page() {
        driver.get(Constants.main_url + Constants.login_path);
    }

    @When("^I login$")
    public void i_login() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
        loginPage.login(Constants.username, Constants.password);
    }

    @When("^I click the PIM tab$")
    public void i_click_the_PIM_tab() {
        dashboardPage = PageFactory.initElements(driver, DashboardPage.class);
        dashboardPage.click_pim();

    }

    @When("^then the Add Employee Tab$")
    public void then_the_Add_Employee_Tab() {
        dashboardPage.clickAddEmployee(wait);
    }

    @When("^I fill out the Add Employee Details correctly$")
    public void i_fill_out_the_Add_Employee_Details_correctly() {
        addEmployeePage = PageFactory.initElements(driver, AddEmployeePage.class);
        addEmployeePage.fillEmployeeDetails(wait, action,Constants.first_name, Constants.middle_name,
                Constants.last_name, new_user_id);
    }

    @When("^I choose to create Login Details by clicking the appropriate button$")
    public void i_choose_to_create_Login_Details_by_clicking_the_appropriate_button() {
        addEmployeePage.clickCreateLoginDetails();
    }

    @When("^I fill out the Login Details correctly$")
    public void i_fill_out_the_Login_Details_correctly() {
        addEmployeePage.fillLoginDetails(action, new_user, "secretpass", "secretpass");
    }

    @When("^I click the Save button$")
    public void i_click_the_Save_button() {
        addEmployeePage.clickSave(wait);
    }

    @Then("^I can search for the Employee I have just created$")
    public void i_can_search_for_the_Employee_I_have_just_created() {
        driver.get(Constants.main_url + Constants.employee_list_path);
        employeeListPage = PageFactory.initElements(driver, EmployeeListPage.class);
        employeeListPage.search_for_user(wait, new_user_id);
    }

    @Then("^select them for inspection$")
    public void select_them_for_inspection() {
        employeeListPage.inspect_user();
        assertEquals(driver.getTitle(), "Personal Details");
    }
}
