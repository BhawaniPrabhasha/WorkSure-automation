package com.worksure.tests;

import com.worksure.base.BaseTest;
import com.worksure.pages.LoginPage;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginPageTest extends BaseTest {

    @Test
    public void openLoginPage() {

        LoginPage loginPage = new LoginPage(driver);

        loginPage.openHome();
        loginPage.clickLogin();

        Assertions.assertTrue(
                loginPage.isLoginTextVisible(),
                "Login page text not visible"
        );

        System.out.println("Login page opened successfully using POM.");
    }
}
