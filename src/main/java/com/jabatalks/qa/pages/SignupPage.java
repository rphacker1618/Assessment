package com.jabatalks.qa.pages;

import com.jabatalks.qa.testBase.BaseClass;
import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SignupPage extends BaseClass {
    Logger log = Logger.getLogger(SignupPage.class);

    @FindBy(id = "language")
    WebElement langdropdown;

    @FindBy(id = "name")
    WebElement fullname;

    @FindBy(id = "orgName")
    WebElement orgname;

    @FindBy(id = "singUpEmail")
    WebElement emailid;

    @FindBy(xpath = "//span[@class='black-color ng-binding']")
    WebElement termsconditionsagree;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement getstarted;

    @FindBy(xpath = "//div/span[@class='ng-binding']")
    WebElement successMessage;

    public SignupPage() throws IOException {
        PageFactory.initElements(driver, this);
    }

    public String getPageTile() {
        return driver.getTitle();
    }

    public String fileForm(String name, String orgName, String mail) throws InterruptedException {
        fullname.sendKeys(name);
        orgname.sendKeys(orgName);
        emailid.sendKeys(mail);
        termsconditionsagree.click();
        getstarted.click();
        Thread.sleep(5000);
        return successMessage.getText();
    }

    public boolean validateDropDownValue() {
        langdropdown.click();
        List<WebElement> child = driver.findElements(By.xpath("//div[@ng-bind-html='language']"));
        List<String> langList = Arrays.asList("English", "Dutch");
        List<String> compareList = new ArrayList<String>();
        compareList.add(child.get(0).getText());
        compareList.add(child.get(1).getText());
        return langList.containsAll(compareList);
    }
}
