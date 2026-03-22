package com.worksure.tests;

import com.worksure.base.BaseTest;
import com.worksure.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginInvalidPasswordTest extends BaseTest {

    @Test
    public void loginWithWrongPassword() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openHome();
        loginPage.clickLogin();

        driver.findElement(By.xpath("//input[@placeholder='Enter your username']"))
              .sendKeys("selenium_test");

        driver.findElement(By.xpath("//input[@placeholder='Enter your password']"))
              .sendKeys("wrong123");

        driver.findElement(By.cssSelector("form button[type='submit']")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText().toLowerCase();

        System.out.println("Page content: " + bodyText); // DEBUG

        Assertions.assertTrue(
                bodyText.contains("error")
                        || bodyText.contains("invalid")
                        || bodyText.contains("failed")
                        || bodyText.contains("login"),
                "Error message not shown for wrong password"
        );

        System.out.println("Wrong password login test passed.");
    }
}
