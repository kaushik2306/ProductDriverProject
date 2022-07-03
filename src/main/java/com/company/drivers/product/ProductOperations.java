package com.company.drivers.product;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.company.inputmodel.product.ProductModel;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ProductOperations {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	WebDriver driver;
	
	Wait<WebDriver> wait;
	
	public void login(ProductModel product) throws Exception{
		logger.info("Login into "+product.getUid());
		
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		//driver.manage().timeouts().implicitlyWait(Duration.ofMillis(500L));
		driver.get(product.getLinkUrl());
		Thread.sleep(10000);
		driver.manage().window().maximize();
		
		wait = new FluentWait<WebDriver>(driver)
				.withTimeout(Duration.ofSeconds(20))
				.pollingEvery(Duration.ofSeconds(200))
				.ignoring(NullPointerException.class,ElementClickInterceptedException.class);

		WebElement usernNameElement = wait.until(elemet -> elemet.findElement(By.name("username")));
		usernNameElement.click();
		usernNameElement.sendKeys(product.getUsername());
		
		WebElement passwordElement = wait.until(elemet -> elemet.findElement(By.name("password")));
		passwordElement.click();
		passwordElement.sendKeys(product.getPassword());
		
		WebElement loginElement = wait.until(elemet -> elemet.findElement(By.cssSelector("body > form > input[type=submit]")));
		loginElement.click();
	}
	
	public void logout(ProductModel product){
		logger.info("Logout into "+product.getUid());
		driver.close();
	}
	
	public static void main(String[] args) {
		ProductModel product = new ProductModel();
		product.setLinkUrl("https://www.stealmylogin.com/demo.html");
		product.setUid("P1");
		product.setUsername("admin");
		product.setPassword("admin1");
		
		try {			
			ProductOperations operations = new ProductOperations();
			operations.login(product);
			
			operations.logout(product);
		} catch (Exception e) {
			System.out.println("ProductOperations.main()" +e.getMessage());
		}
	}
}
