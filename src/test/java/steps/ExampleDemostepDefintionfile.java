package steps;

import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class ExampleDemostepDefintionfile {

	
	// Create hooks in step defintion file. if you want to run Any task before every scneario and if we want to runa  task after every scenario
	//we can use hooks
	// hooks will be created in a single step definition file
	
	// Example: tagged hooks
	// syntax: @Before(@register)
	// in this case the before and after method will run only when this tag scenario is executed
	
	@Before(order=0)
	public void setup()
	{
		System.out.println("The browser has opened");
	}
	
	// multiple hooks run in a order
	@Before(order=1,value="@register")
	public void setup1()
	{
		System.out.println("The application is rediff mail");
	}
	
	@Before(order=2,value="@register")
	public void setup2()
	{
		System.out.println("Author is Sonal");
	}
	
	// In after hooks the order is in reverse order
	
	@After(order=2,value="@register")
	public void teardown()
	{
		System.out.println("The browser has closed");
	}
	
	@After(order=1,value="@register")
	public void teardown1()
	{
		System.out.println("The browser has closed");
	}
	
	@After(order=0,value="@register")
	public void teardown2()
	{
		System.out.println("The browser has closed");
	}
	
	// Similarly we also have annotation @BeforeStep and @Afterstep, in this the code will run wfore every stpes of the scenario and after every step of scenario
	
	@BeforeStep("@register")
	public void beforeeverystep()
	{
		System.out.println("Step executtion started");
	}
	
	@AfterStep("@register")
	public void aftereverystep()
	{
		System.out.println("Step execution completed");
	}
	
WebDriver driver;
	
	@Given("I am on RediffPage")
	public void I_am_on_RediffPage()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://mypage.rediff.com/login/dologin");
	}
	
	@When("I enter {string} on the page")
	public void emailid(String EmailID) {
		
		driver.findElement(By.id("txtlogin")).sendKeys(EmailID);	   
	}

	@And("I enter {string} on the Page")
		public void passwd(String Password)
		{
			driver.findElement(By.id("pass_box")).sendKeys(Password);
		}
		
	
	@When("click on Login")
	public void click_on_Login() throws InterruptedException {
	  
		driver.findElement(By.xpath("//*[@id=\"pass_div\"]/input[3]")).click();
		Thread.sleep(2000);
		driver.close();
	}
	
	@When("I click on Create new Account Link")
	public void i_click_on_create_new_account_link() {
		
		driver.findElement(By.linkText("Create a Rediffmail account")).click();
	    
	}

	@Then("fetch the title of the Page")
	public void fetch_the_title_of_the_page() {
	 System.out.println( driver.getTitle());
	 driver.close();
	}


	//| FullName | EmailID | Password | retype | alternate | phone |
	
	@Then("User Enters the folliwng registration details")
	public void User_Enters_the_folliwng_registration_details(DataTable dataTable)
	{
	List<Map<String,String>> userList = dataTable.asMaps(String.class,String.class);
	
	for(Map<String,String> e: userList)
	{
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[1]")).clear();
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[1]")).sendKeys(e.get("FullName"));
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[2]")).clear();
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[2]")).sendKeys(e.get("EmailID"));
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[4]")).clear();
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[4]")).sendKeys(e.get("Password"));
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[5]")).clear();
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[5]")).sendKeys(e.get("retype"));
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[6]")).clear();
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[6]")).sendKeys(e.get("alternate"));
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[13]")).clear();
		driver.findElement(By.xpath("//div[@id='wrapper']/descendant::input[13]")).sendKeys(e.get("phone"));
	}
		driver.close();
	}
	
}
