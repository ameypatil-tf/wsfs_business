package com.cztffa.cucumber.parallel.smb;


import com.cztffa.browseractions.BrowserActions;
import com.cztffa.driver.SeleniumDriver;
import com.cztffa.page.review.SmbReviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

import static org.junit.Assert.assertTrue;

@Slf4j

public class SmbDocumentPageStepDefinition {
    private SeleniumDriver seleniumdriver;
    private BrowserActions browserActions;
    private SmbReviewPage smbReviewPage;


    public SmbDocumentPageStepDefinition(SmbReviewPage smbReviewPage) {
        this.seleniumdriver = smbReviewPage.getSeleniumdriver();
        this.browserActions = smbReviewPage.browserActions;
        this.smbReviewPage=smbReviewPage;
    }

    @And("^: I should see the documents page$")
    public void navigateToDocumentsPage() throws Throwable {
        smbReviewPage.waitForVisibilityWithLoader("//*[contains(text(),'Please provide at least one document for each section')]");
        smbReviewPage.waitForSpinnerToDisappear();
        log.info("i am going looking at documents page");
        assertTrue(seleniumdriver.getWebDriver().getPageSource().contains("Documents"));
        log.info("I am at documents page ");
    }

    @And("^: I upload documents$")
    public void uploadDocuments() throws Throwable {
        smbReviewPage.waitForSpinnerToDisappear();
        Thread.sleep(1000);
        smbReviewPage.waitForSpinnerToDisappear();
        try {

            smbReviewPage.waitForSpinnerToDisappear();
            log.info("I am at documents page");

            // Define file paths (extend if needed)
            String[] files = {
                    "C:\\Users\\ap250818\\IdeaProjects\\wsfs_business\\IDFiles\\dummy.pdf",
                    "C:\\Users\\ap250818\\IdeaProjects\\wsfs_business\\IDFiles\\dummy.pdf",
                    "C:\\Users\\ap250818\\IdeaProjects\\wsfs_business\\IDFiles\\dummy.pdf",
                    "C:\\Users\\ap250818\\IdeaProjects\\wsfs_business\\IDFiles\\dummy.pdf",
                    "C:\\Users\\ap250818\\IdeaProjects\\wsfs_business\\IDFiles\\dummy.pdf",
                    "C:\\Users\\ap250818\\IdeaProjects\\wsfs_business\\IDFiles\\dummy.pdf"
            };

            // Find all upload buttons
            List<WebElement> uploadButtons = seleniumdriver.getWebDriver()
                    .findElements(By.xpath("//button[contains(text(),'Upload') and @class='btn btn-outline-primary']"));

            log.info("Total Upload buttons found: " + uploadButtons.size());

            // Iterate over each Upload button
            for (int i = 0; i < uploadButtons.size(); i++) {
                log.info("Clicking Upload button " + (i + 1) + " of " + uploadButtons.size());

                WebElement uploadBtn = uploadButtons.get(i);
                browserActions.scrollToWebElement(seleniumdriver, uploadBtn);
                Thread.sleep(1000);
                uploadBtn.click();
                Thread.sleep(1000);

                try {
                    // Wait for Browse button to appear inside popup
                    WebDriverWait wait = new WebDriverWait(seleniumdriver.getWebDriver(), Duration.ofSeconds(10));
                    WebElement browseInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                            By.xpath("//input[@type='file' and contains(@id,'tf-file-capture')]")));
                    Thread.sleep(1000);

                    // Upload the file
                    if (i < files.length) {
                        browseInput.sendKeys(files[i]);
                        log.info("Uploaded file: " + files[i]);
                        smbReviewPage.waitForSpinnerToDisappear();
                        Thread.sleep(1000);
                        smbReviewPage.waitForSpinnerToDisappear();
                        Thread.sleep(1000);

//                        Thread.sleep(12000);

                    } else {
                        log.warn("No file specified for Upload button " + (i + 1));
                    }
                } catch (Exception e) {
                log.error("Error while uploading file for button " + (i + 1) + ": " + e.getMessage());
                continue; // Skip to next iteration
            }
                // Wait for popup to close (adjust depending on behavior)
                    smbReviewPage.waitForSpinnerToDisappear();
                    Thread.sleep(1000);
            }
            smbReviewPage.waitForSpinnerToDisappear();
            log.info("Document page next button");
            smbReviewPage.wait(smbReviewPage.getSmbPersonalInfoPageModel().personalInfoNextButon);
            browserActions.scrollToWebElement(seleniumdriver,smbReviewPage.getSmbPersonalInfoPageModel().personalInfoNextButon);
            browserActions.clickUsingEnter(seleniumdriver.getWebDriver(),smbReviewPage.getSmbPersonalInfoPageModel().personalInfoNextButon);
            log.info("Document page next button clicked");

        } catch (Exception e) {
            log.info("Document Page not found");
        }
    }

    @Then("^: I click on documents page next button$")
    public void clickDocumentsNextButton() throws Throwable {
        smbReviewPage.waitForSpinnerToDisappear();
        log.info("Document page next button");
        smbReviewPage.wait(smbReviewPage.getSmbPersonalInfoPageModel().personalInfoNextButon);
        browserActions.scrollToWebElement(seleniumdriver,smbReviewPage.getSmbPersonalInfoPageModel().personalInfoNextButon);
        browserActions.clickUsingEnter(seleniumdriver.getWebDriver(), smbReviewPage.getSmbPersonalInfoPageModel().personalInfoNextButon);
        log.info("Document page next button clicked");
    }
}
