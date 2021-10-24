package com.jabatalks.qa.testcases;

import com.jabatalks.qa.pages.SignupPage;
import com.jabatalks.qa.testBase.BaseClass;
import org.apache.log4j.Logger;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class SignupTest extends BaseClass {
    SignupPage signupPage;
    Logger log = Logger.getLogger(SignupTest.class);

    public SignupTest() throws IOException {
        super();
    }

    @BeforeMethod
    public void setup() throws IOException {
        initialization();
        signupPage = new SignupPage();
    }

    @Test(priority = 1)
    public void pageTileTest() {
        String PageTile = signupPage.getPageTile();
        Assert.assertEquals(PageTile, "Jabatalks");
    }

    @Test(priority = 2)
    public void validateDropDownValueTest() {
        boolean langFlag = signupPage.validateDropDownValue();
        Assert.assertTrue(langFlag, "Language is missing");
    }

    @Test(priority = 3)
    public void fileFormTest() throws InterruptedException {
        String successMessage = signupPage.fileForm("Test", "XYZ Pvt LTD", "test@test.com");
        if (successMessage.equals("A welcome email has been sent. Please check your email.")) {
            log.info("Signup successfull: Email has been received");
        } else {
            log.info("Signup not successfull: possible reason : " + successMessage);
            Assert.fail();
        }
    }


    @AfterMethod
    public void tearDown(ITestResult result) {
        driver.quit();
    }
}

