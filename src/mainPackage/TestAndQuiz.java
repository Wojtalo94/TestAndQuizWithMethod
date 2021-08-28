package mainPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class TestAndQuiz {

	public static void main(String[] args) {
		
		System.out.println("Start!");
		
		System.setProperty("webdriver.chrome.driver","C:\\Users\\wojta\\OneDrive\\Pulpit\\SeleniumWebDriverForChrome\\chromedriver.exe");
		
		WebDriver driver = new ChromeDriver();
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 1. Otwórz stronê https://www.testandquiz.com/
		System.out.println("STEP 1");
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx

		String url = "https://www.testandquiz.com/";
		
		driver.manage().window().setPosition(new Point (2000, 10)); // Point importujemy z 'org.openqa.selenium.Point;' 
		driver.manage().window().maximize();
		driver.get(url);
		
		String title = driver.getTitle();
		
		verifyText(title, "Quiz Show | Test And Quiz"); 

		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 2. Kliknij w link 'Login'
		System.out.println("STEP 2");		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		
		WebElement logIn = driver.findElement(By.linkText("Login"));	
		
		logIn.click();	
		
		title = driver.getTitle();
		
		verifyText(title, "Test And Quiz | User-Login-Form"); 
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 3. Wpisz dane do logowania (email, password)
		System.out.println("STEP 3");		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx		
		

		WebElement email;
		
		email = driver.findElement(By.id("email"));		
		if (email != null) {					
			System.out.println("Field email is displayed");
		} else {
			System.err.format("Field email is not displayed\n");
		}

		email.sendKeys("wojtek1994@gmail.com");	
		
		String tmpStr = "";		 
		
		tmpStr = email.getAttribute("value");	
		
		verifyText(tmpStr, "wojtek1994@gmail.com"); 
			
		
		WebElement password;
	
		password = driver.findElement(By.id("password"));
		if (password != null) {							
			System.out.println("Field password is displayed");
		} else {
			System.err.format("Field password is not displayed\n");			
		}
		
		password.sendKeys("123456789");		 
		
		tmpStr = password.getAttribute("value");		
		
		verifyText(tmpStr, "123456789"); 
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 4. Kliknij w przycisk 'Log in'
		System.out.println("STEP 4");		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx		

		WebElement buttonLogin = driver.findElement(By.xpath("//button[@type='submit']"));
		
		if (buttonLogin != null) {
			System.out.println("Button Log In is displayed");
		} else {
			System.err.format("Button Log In is nod displayed\n");
		}
		
		tmpStr = buttonLogin.getText();

		verifyText(tmpStr, "Log In"); 
		
		buttonLogin.click(); 
		
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx
		// Step 5. Sprwadz komunikat
		System.out.println("STEP 5");	
		//xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx		
		
		
		WebElement errorMess = driver.findElement(By.className("error-mesg"));
		
		tmpStr = errorMess.getText();

		verifyText(tmpStr, "Sorry ! entered email address or password is not correct"); 
	
		driver.close();
		
	}

	public static void verifyText(String text, String expectedText) {
		  {
			    if(text.equals(expectedText))
			    {
			      System.out.println("Text is correctly set to: '" + text + "'");
			    }
			    else
			    {
			      System.err.format("Text is set to '%s', instead of '%s'\n", text, expectedText);
			    }  
		  }
	}

}
