package swag_lab3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Sortig_high_to_low {

	public WebDriver driver;

	@BeforeTest

	public void log_in() {
		WebDriverManager.chromedriver().setup();

		driver = new ChromeDriver();
		driver.get("https://www.saucedemo.com/");
		driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("standard_user");
		driver.findElement(By.xpath("//*[@id=\"password\"]")).sendKeys("secret_sauce");
		driver.findElement(By.xpath("//*[@id=\"login-button\"]")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select")).click();
		driver.findElement(By.xpath("//*[@id=\"header_container\"]/div[2]/div[2]/span/select/option[4]")).click();
	}

	@Test
	public void test_high_to_low() {

		List<WebElement> listOfPrice = driver.findElements(By.className("inventory_item_price"));

		List<Double> doubleprice = new ArrayList<>();

		for (int i = 0; i < listOfPrice.size(); i++) {

			String price = listOfPrice.get(i).getText();

			String rprice = price.replace("$", "");

			double eprice = Double.parseDouble(rprice);

			doubleprice.add(eprice);

			

		}

		System.out.println(doubleprice);
		
		for (int i = 0; i < doubleprice.size(); i++) {

			boolean check=doubleprice.get(0)>doubleprice.get(doubleprice.size()-1);
			
			Assert.assertEquals(true, check);
			
		}
	}


