package com.automationtestingrestassured;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.AssertJUnit.assertEquals;

public class IDriveLogin {

    @Test
    public void loginWithValid() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.idrive360.com/enterprise/login");

        driver.manage().window().maximize();

        WebElement email=driver.findElement(By.id("username"));
        email.sendKeys("augtest_040823@idrive.com");

        WebElement pass=driver.findElement(By.id("password"));
        pass.sendKeys("123456");
        Thread.sleep(3000);

        WebElement click_button=driver.findElement(By.id("frm-btn"));
        click_button.click();

        Thread.sleep(5000);

        WebElement message=driver.findElement(By.xpath("//*[@id=\'upgrade]/span"));
        assertEquals(message.getText(), "Your free trial has expired");
        assertEquals(driver.getCurrentUrl(),"https://www.idrive360.com/enterprise/account?upgradenow=true");


        Thread.sleep(8000);

        driver.quit();

    }
}




