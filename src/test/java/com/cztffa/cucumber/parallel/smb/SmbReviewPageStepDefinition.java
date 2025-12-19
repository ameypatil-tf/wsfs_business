package com.cztffa.cucumber.parallel.smb;

import com.cztffa.browseractions.BrowserActions;
import com.cztffa.dataproviders.DataCSVExtractor;
import com.cztffa.driver.SeleniumDriver;
import com.cztffa.page.review.SmbReviewPage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;
import java.util.NoSuchElementException;

import static org.junit.Assert.assertTrue;

@Slf4j

public class SmbReviewPageStepDefinition {

    private SeleniumDriver seleniumdriver;
    private BrowserActions browserActions;
    private SmbReviewPage smbReviewPage;

    public SmbReviewPageStepDefinition(SmbReviewPage smbReviewPage) {
        this.seleniumdriver = smbReviewPage.getSeleniumdriver();
        this.browserActions = smbReviewPage.browserActions;
        this.smbReviewPage=smbReviewPage;
    }
    @Then("^: I should accept the all business terms and conditions (\\d+)$")
    public void acceptAllTermsAndConditions(int numberOfDisclosure) throws Throwable {
        log.info("i am at terms and condition page");
        smbReviewPage.waitForSpinnerToDisappear();
        smbReviewPage.waitForVisibilityWithLoader("//*[contains(text(),'Legal Business Name and Address')]");
//        String termAndConditions = "(//tf-checkbox[@t-model='Accepted__c']//input)";
        smbReviewPage.scrollToElementWithActionPause(seleniumdriver,smbReviewPage.getSmbReviewPageModel().disclosureCheckbox);
        log.info("After Scrolling");
        browserActions.scrollToWebElement(seleniumdriver,smbReviewPage.getSmbReviewPageModel().disclosureCheckbox);
        smbReviewPage.waitWithShortTime(seleniumdriver);
        browserActions.clickButton(seleniumdriver, smbReviewPage.getSmbReviewPageModel().disclosureCheckbox);
        browserActions.scrollToWebElement(seleniumdriver, smbReviewPage.getSmbReviewPageModel().disclosureCheckbox);

        WebDriver driver = seleniumdriver.getWebDriver();

        String mainWindow = driver.getWindowHandle();
        int index = 2;
        while(true) {
            try {
                log.info("Inside while");
                String termAndConditions = "(//tf-checkbox[@t-model='Accepted__c']//input)[" + index + "]";
                log.info(termAndConditions);
                WebElement checkbox;
                try {
                    checkbox = seleniumdriver.getWebDriver().findElement(By.xpath(termAndConditions));
                    log.info("Clicking T&C " + index);
                    browserActions.scrollToWebElement(seleniumdriver, checkbox);
                    smbReviewPage.waitWithShortTime(seleniumdriver);
                    browserActions.clickButton(seleniumdriver,checkbox);
                    Thread.sleep(1000);
                    smbReviewPage.spinner();
                    log.info("Number of windows: " + driver.getWindowHandles().size());
                    index++;

//                    if(driver.getWindowHandles().size()>1){
//                        for (String windowHandle : driver.getWindowHandles()) {
//                            if (!windowHandle.equals(mainWindow)) {
//                                driver.switchTo().window(windowHandle);
//                                log.info("Switched to popup window: " + windowHandle);
//                                break;
//                            }
//                        }

                    if (smbReviewPage.switchToIframeIfPresent(seleniumdriver.getWebDriver(), smbReviewPage.getSmbReviewPageModel().framePlaid,10)) {
                        // Click inside iframe
                        log.info("Inside frame");
                        try {
                            Thread.sleep(11000);

//                            if (Seleniumdriver().getWebDriver().getPageSource().contains("Issue Date")) {
                                log.info("Clicking on modalcheckbox Button");
                                browserActions.clickButton(seleniumdriver, smbReviewPage.getSmbReviewPageModel().modalCheckbox);
//                            Thread.sleep(2000);
                                log.info("Clicking on modal continue Button");
                                browserActions.clickButton(seleniumdriver, smbReviewPage.getSmbReviewPageModel().modalCnt);
                                Thread.sleep(2000);
//                            }
                            WebElement element1 = driver.findElement(By.xpath("//button//span[contains(text(),'Adopt and Sign')]"));
                            browserActions.scrollToWebElement(seleniumdriver, element1);
                            Thread.sleep(2000);
                            browserActions.clickApply(driver, element1);
                            Thread.sleep(2000);
                            log.info("Selecting AdoptAndSignBtn");

                            log.info("Clicking on Finish Button");
                            browserActions.clickButton(seleniumdriver, smbReviewPage.getSmbDisclosurePageModel().finishBtn);
                            Thread.sleep(2000);
                            smbReviewPage.spinner();
                            Thread.sleep(9000);
                            smbReviewPage.spinner();
                        } catch (Exception e) {
                            log.error("No sign button");
                        }
                        browserActions.switchToDefaultContent(seleniumdriver);
                    }
                    if(smbReviewPage.getSeleniumdriver().getWebDriver().getPageSource().contains("BUSINESS RESOLUTION")){
                        Thread.sleep(2000);
                        browserActions.clickButton(seleniumdriver, smbReviewPage.getSmbDisclosurePageModel().acceptBtn);
                    }
//                    }
                } catch (Exception e) {
                    break;
                }
            } catch (NoSuchElementException e) {
                log.info("No more checkboxes found. Exiting loop.");
                break;
            }
        }
        Thread.sleep(3000);
//        browserActions.clickButton(seleniumdriver, smbReviewPage.getSmbDisclosurePageModel().acceptBtn);
//        Thread.sleep(1000);
    }

    @And(": I click on review details submit button for smb")
    public void iClickOnReviewDetailsSubmitButtonForSmb() throws InterruptedException {
        log.info("Before clicking on submit button");
        browserActions.scrollToWebElement(seleniumdriver, smbReviewPage.getSmbReviewPageModel().submitButton);
        browserActions.clickUsingEnter(seleniumdriver.getWebDriver(), smbReviewPage.getSmbReviewPageModel().submitButton);
        log.info("After clicking on submit button");
        Thread.sleep(12000);

    }
    @Then(": I should see the reference Id page for final submission of smb")
    public void iShouldSeeTheReferenceIdPageForFinalSubmissionOfSmb() throws InterruptedException {
        log.info("On Reference Id page");
        log.info("Successful executed the whole flow ");
        Thread.sleep(2000);
        smbReviewPage.spinner();
        Thread.sleep(2000);

    }
}
