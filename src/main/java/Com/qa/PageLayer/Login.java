package Com.qa.PageLayer;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriverManager.chromedriver().setup();
	 	WebDriver driver=new ChromeDriver();
	
	 	
	 	driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get("https://demoblaze.com/");
		
		//login
		WebElement Login = driver.findElement(By.xpath("//a[@id='login2']"));
		Login.click();
		WebElement username = driver.findElement(By.xpath("//input[@id='loginusername']"));
		username.sendKeys("sctqaautomation@grr.la");
		WebElement password = driver.findElement(By.xpath("//input[@id='loginpassword']"));
		password.sendKeys("Spring@123");
		Thread.sleep(2000);
		WebElement LoginButton = driver.findElement(By.xpath("(//button[@class='btn btn-primary'])[3]"));
		LoginButton.click();
		
		driver.navigate().refresh();
		//Select Samsung Galaxy S6
		driver.findElement(By.xpath("//a[text()='Samsung galaxy s6']")).click();
		
		//add it to the cart
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		
		//Click on Home menu on the top 
		driver.findElement(By.xpath("//a[text()='Home ']")).click();
		
		//click on LAPTOP option
		driver.findElement(By.xpath("//a[text()='Laptops']")).click();
		
		//Add Dell i7 8 GB to the cart
		driver.findElement(By.xpath("//a[text()='Dell i7 8gb']")).click();
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		
		//Click on Home menu on the top 
		driver.findElement(By.xpath("//a[text()='Home ']")).click();
		
		//click on MONITOR option
		driver.findElement(By.xpath("//a[text()='Monitors']")).click();
		
		//Add Asus Full HD monitor to the cart
		driver.findElement(By.xpath("//a[text()='ASUS Full HD']")).click();
		driver.findElement(By.xpath("//a[text()='Add to cart']")).click();
		
		//Navigate to the cart menu
		driver.findElement(By.xpath("//a[text()='Cart']")).click();
		
		List<WebElement> Products = driver.findElements(By.xpath("//tbody[@id='tbodyid']"));
		int count=Products.size();
		System.out.println(count);
		for (int i = 0; i < count; i++) 
		{
			String ProductName=Products.get(i).getText();
			System.out.println(ProductName);
		}
		
		//Click on Place Order and enter information
		driver.findElement(By.xpath("//button[text()='Place Order']")).click();
		driver.findElement(By.xpath("//input[@id='name']")).sendKeys("Sumit Vikas Suryawanshi");
		driver.findElement(By.xpath("//input[@id='country']")).sendKeys("India");
		driver.findElement(By.xpath("//input[@id='city']")).sendKeys("pune");
		driver.findElement(By.xpath("//input[@id='card']")).sendKeys("123456489");
		driver.findElement(By.xpath("//input[@id='month']")).sendKeys("Feb");
		driver.findElement(By.xpath("//input[@id='year']")).sendKeys("2022");
		driver.findElement(By.xpath("//button[text()='Purchase']")).click();
		//extract ID and Amount
		driver.findElement(By.xpath("//p[@class='lead text-muted ']")).getText();
		driver.findElement(By.xpath("//button[@class='confirm btn btn-lg btn-primary']")).click();
		
		
		//close window
		driver.quit();
		

	}

}
