package com.worksure.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {

    private final WebDriver driver;
    private final WebDriverWait wait;

    // Locators (how we find elements)
    private final By loginButton = By.xpath("//button[contains(.,'Login') or contains(.,'Sign In') or contains(.,'Sign in')]");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    // Actions (what we do on the page)
    public void openHome() {
        driver.get("http://localhost:5173/");
    }

    public void clickLogin() {
        wait.until(ExpectedConditions.elementToBeClickable(loginButton)).click();
    }

    public boolean isLoginTextVisible() {
        return wait.until(ExpectedConditions.textToBePresentInElementLocated(By.tagName("body"), "Login"));
    }
}
