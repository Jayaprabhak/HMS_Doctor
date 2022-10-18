package com.doctor.testing;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class doctorTesting {
	WebDriver webdriver = null;
	String URL = "http://localhost:4200/doctor/getid";

	@Test
	public void viewId() {
		System.setProperty("webdriver.chrome.driver",
				"D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver webdriver = new ChromeDriver();
		webdriver.get(URL);
		webdriver.manage().window().maximize();
		
		webdriver.findElement(By.id("user")).sendKeys("1");
		webdriver.findElement(By.id("save")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webdriver.findElement(By.id("vapp")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webdriver.findElement(By.id("vpt")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		webdriver.findElement(By.id("dpt")).click();
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("search tested successfully");
	}

}
