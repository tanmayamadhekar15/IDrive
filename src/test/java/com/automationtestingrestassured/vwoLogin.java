package com.automationtestingrestassured;

import org.hamcrest.Matchers;
import org.openqa.selenium.By;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.assertThat;

public class vwoLogin {

    @Test
    public void loginWithValid() throws InterruptedException {
        ChromeOptions options=new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
        WebDriver driver=new ChromeDriver();
        driver.get("https://app.vwo.com/#/login");

        driver.manage().window().maximize();

        WebElement email=driver.findElement(By.id("login-username"));
        email.sendKeys("vwo@1secmail.com");

        WebElement pass=driver.findElement(By.id("login-password"));
        pass.sendKeys("Vwo@1234");

        WebElement rememberME=driver.findElement(By.id("checkbox-remember"));
        rememberME.isSelected();

        WebElement click_button=driver.findElement(By.id("js-login-btn"));
        click_button.click();

        assertThat("Hi V W,", Matchers.equalTo("Hi V W,"));

        Thread.sleep(8000);

        driver.quit();

    }
}




