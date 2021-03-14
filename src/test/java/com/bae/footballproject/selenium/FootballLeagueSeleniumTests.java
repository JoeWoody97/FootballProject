package com.bae.footballproject.selenium;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@Sql(scripts = {"classpath:team-schema.sql",
"classpath:team-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class FootballLeagueSeleniumTests {
	
	@LocalServerPort
	private int port;
	
	private RemoteWebDriver driver;
	
	private WebDriverWait wait;
	
	@BeforeEach
	void setup() {
		ChromeOptions options = new ChromeOptions();
		options.setHeadless(true);
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		this.wait = new WebDriverWait(driver, 5);
	}
	
	@Test
	void testPage() {
		this.driver.get("http://localhost:" + port);
		
		WebElement title = this.driver.findElement(By.xpath("/html/body/nav/div/a"));
		
		assertThat(title.getText()).isEqualTo("5 a-side Football");
	}
	
	@Test
	void testTable() {
		this.driver.get("http://localhost:" + port);
		
		WebElement tableLocation = this.driver.findElementByXPath("//*[@id=\"output\"]/tr/td[5]");
		
		assertThat(tableLocation.getText()).isEqualTo("Chorley");
	}
	
	
	@Test
	void testCreate() throws InterruptedException {
		this.driver.get("http://localhost:" + port);
		
		WebElement nameInput = this.driver.findElementByXPath("//*[@id=\"teamName\"]");
		nameInput.sendKeys("Milton FC");
		
		WebElement captainInput = this.driver.findElementByXPath("//*[@id=\"captain\"]");
		captainInput.sendKeys("Phoebe");
		
		WebElement kitInput = this.driver.findElementByXPath("//*[@id=\"kitColour\"]");
		kitInput.sendKeys("Green");
		
		WebElement squadInput = this.driver.findElementByXPath("//*[@id=\"squadSize\"]");
		squadInput.sendKeys("7");
		
		WebElement locationInput = this.driver.findElementByXPath("//*[@id=\"location\"]");
		locationInput.sendKeys("Chinley");
		
		WebElement contactInput = this.driver.findElementByXPath("//*[@id=\"contactDetails\"]");
		contactInput.sendKeys("Phoebe@test.com");
		
		WebElement submitButton = this.driver.findElementByCssSelector("#teamForm > button:nth-child(14)");
		submitButton.click();
		
		Thread.sleep(5000L);
		
		WebElement checkUpdated = this.driver.findElementByXPath("//*[@id=\"output\"]/tr[2]/td[5]");
		assertEquals(checkUpdated.getText(), "Chinley");
	}
	
	@Test
	void updateTest() throws InterruptedException {
		this.driver.get("http://localhost:" + port);
		
		WebElement updateButton = this.driver.findElementByCssSelector("#output > tr > td:nth-child(7) > i.fas.fa-edit.icon");
		updateButton.click();
		
		WebElement nameInput = this.driver.findElementById("teamNameUpdate");
		nameInput.sendKeys("Milton FC");
		
		WebElement captainInput = this.driver.findElementById("captainUpdate");
		captainInput.sendKeys("Hannah");
		
		WebElement kitInput = this.driver.findElementById("kitColourUpdate");
		kitInput.sendKeys("Purple");
		
		WebElement squadInput = this.driver.findElementById("squadSizeUpdate");
		squadInput.sendKeys("6");
		
		WebElement locationInput = this.driver.findElementById("locationUpdate");
		locationInput.sendKeys("Chinley");
		
		WebElement contactInput = this.driver.findElementById("contactDetailsUpdate");
		contactInput.sendKeys("Hannah@test.com");
		
		WebElement submitButton = this.driver.findElementByXPath("//*[@id=\"teamUpdateForm\"]/button[2]");
		submitButton.click();
		
		Thread.sleep(5000L);
		
		WebElement checkUpdated = this.driver.findElementByXPath("//*[@id=\"output\"]/tr[1]/td[2]");
		assertEquals(checkUpdated.getText(), "Hannah");
	}
	
	
	@Test
	void deleteTest() throws InterruptedException {
		
		this.driver.get("http://localhost:" + port);
		
		WebElement deleteButton = this.driver.findElementByXPath("//*[@id=\"output\"]/tr[1]/td[7]/i[1]");
		deleteButton.click();
		
		Thread.sleep(5000L);
		
		WebElement checkDeleted = this.driver.findElementById("output");
		assertEquals(checkDeleted.getText(), "");
	}

	
	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}
