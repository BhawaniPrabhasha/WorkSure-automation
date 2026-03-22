package com.worksure.tests;

import com.worksure.base.BaseTest;
import com.worksure.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginSuccessTest extends BaseTest {

    @Test
    public void loginWithValidCredentials() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openHome();
        loginPage.clickLogin();

        // Enter VALID username
        driver.findElement(By.xpath("//input[@placeholder='Enter your username']"))
              .sendKeys("Bhawani");

        // Enter VALID password
        driver.findElement(By.xpath("//input[@placeholder='Enter your password']"))
              .sendKeys("ab123");

        // Click login
        driver.findElement(By.cssSelector("form button[type='submit']")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText().toLowerCase();

        // Check login success (no error message)
        Assertions.assertTrue(
                !bodyText.contains("there was an error during login"),
                "Login failed with valid credentials"
        );

        System.out.println("Successful login test passed.");
    }
}
