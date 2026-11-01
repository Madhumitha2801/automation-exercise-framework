
package com.automationexercise.base;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.imageio.ImageIO;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.qameta.allure.Allure;

public class BaseTest {

    protected WebDriver driver;
    protected WebDriverWait wait;

    @BeforeMethod(alwaysRun = true)
    public void setUp() {

        driver = new ChromeDriver();

        driver.manage().window().maximize();

        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    @AfterMethod(alwaysRun = true)
    public void tearDown(ITestResult result) {

        if (driver != null) {

            try {

                // 1. Create Robot object
                Robot robot = new Robot();

                // 2. Detect complete screen size
                Rectangle screenRect = new Rectangle(
                        Toolkit.getDefaultToolkit().getScreenSize()
                );

                // 3. Capture full laptop screen
                BufferedImage screenFullImage =
                        robot.createScreenCapture(screenRect);

                // 4. Get test status
                String status;

                if (result.getStatus() == ITestResult.SUCCESS) {
                    status = "PASS";
                } else if (result.getStatus() == ITestResult.FAILURE) {
                    status = "FAIL";
                } else {
                    status = "SKIP";
                }

                // 5. Create screenshots folder
                File screenshotFolder = new File("screenshots");

                if (!screenshotFolder.exists()) {
                    screenshotFolder.mkdirs();
                }

                // 6. Create screenshot filename
                String fileName = "Robot_Screenshot_"
                        + status + "_"
                        + result.getMethod().getMethodName()
                        + "_"
                        + System.currentTimeMillis()
                        + ".png";

                File outputFile = new File(
                        screenshotFolder, fileName
                );

                // 7. Save screenshot in project folder
                ImageIO.write(
                        screenFullImage,
                        "png",
                        outputFile
                );

                System.out.println(
                        "Screenshot saved: " + outputFile.getAbsolutePath()
                );

                // 8. Attach screenshot to Allure report
                try (InputStream inputStream =
                        new FileInputStream(outputFile)) {

                    Allure.addAttachment(
                            status + " - Full Screen Screenshot",
                            "image/png",
                            inputStream,
                            ".png"
                    );
                }

            } catch (Exception e) {

                System.out.println("Screenshot capture failed!");
                e.printStackTrace();

            } finally {

                // 9. Close browser after screenshot
                driver.quit();
            }
        }
    }
}
