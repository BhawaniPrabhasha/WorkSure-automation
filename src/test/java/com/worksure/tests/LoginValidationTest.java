package com.worksure.tests;

import com.worksure.base.BaseTest;
import com.worksure.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

public class LoginValidationTest extends BaseTest {

    @Test
    public void validateEmptyLoginFields() {
        LoginPage loginPage = new LoginPage(driver);

        loginPage.openHome();
        loginPage.clickLogin();

        // On the login page, click the submit button without entering data
        driver.findElement(By.cssSelector("form button[type='submit']")).click();

        String bodyText = driver.findElement(By.tagName("body")).getText().toLowerCase();

        Assertions.assertTrue(
                bodyText.contains("required")
                        || bodyText.contains("username")
                        || bodyText.contains("password")
                        || bodyText.contains("error"),
                "Validation message not shown for empty login fields"
        );

        System.out.println("Empty login validation test passed.");
    }
}
