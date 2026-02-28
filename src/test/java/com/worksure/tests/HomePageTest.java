package com.worksure.tests;

import com.worksure.base.BaseTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class HomePageTest extends BaseTest {

    @Test
    public void openHomePage() {

        // Step 1: Open your frontend
        driver.get("http://localhost:5173/");

        // Step 2: Get page title
        String title = driver.getTitle();

        // Step 3: Check title is not empty
        Assertions.assertFalse(title.isEmpty());

        System.out.println("Page opened successfully. Title: " + title);
        System.out.println("Smoke test executed successfully");
    }
}
