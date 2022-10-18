package com.doctor.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class applyJobTesting {
  
	WebDriver webdriver = null;
	String URL = "http://localhost:4200/login";

	@Test
	public void login() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.get(URL);
		webdriver.manage().window().maximize();
		webdriver.findElement(By.id("btnk1")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webdriver.findElement(By.id("name")).sendKeys("raj");
		webdriver.findElement(By.id("age")).sendKeys("35");
		webdriver.findElement(By.id("emid")).sendKeys("Raj@gmail.com");
		webdriver.findElement(By.id("ph")).sendKeys("9087654321");
		webdriver.findElement(By.id("add")).sendKeys("chennai");
		webdriver.findElement(By.id("spe")).sendKeys("ortho");
		
		WebElement radio1 = webdriver.findElement(By.id("m"));
		WebElement radio2 = webdriver.findElement(By.id("f"));
		radio1.click();
		webdriver.findElement(By.id("aj")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("search tested successfully");
	}

  }


