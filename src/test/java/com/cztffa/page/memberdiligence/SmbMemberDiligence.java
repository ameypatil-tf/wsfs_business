package com.cztffa.page.memberdiligence;

import com.cztffa.driver.SeleniumDriver;
import com.cztffa.page.personalinfo.SmbPersonalInfoPage;
import com.cztffa.util.ApplicantUtil;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SmbMemberDiligence extends SmbPersonalInfoPage {
    private SeleniumDriver seleniumdriver;

    public SmbMemberDiligence(){
        this.seleniumdriver = getSeleniumdriver();
    }

    public void completeDueDiligence() throws InterruptedException {

        WebDriver driver = getSeleniumdriver().getWebDriver();
        ApplicantUtil applicantUtil = new ApplicantUtil();
        log.info("Processing the CDD details");
        // if (getSeleniumdriver().getWebDriver().getPageSource().contains("Tell us how you will use your account")) {

//        WebElement payRoll = applicantUtil.getWebElement(getSeleniumdriver(),getMemberDiligencePageModel().accountUsedFor, index);
//        Thread.sleep(500);
//        browserActions.scrollToWebElement(getSeleniumdriver(), payRoll);
//        Thread.sleep(500);
//        browserActions.clickButton(getSeleniumdriver(), payRoll);



        Thread.sleep(1000);
        wait(getMemberDiligencePageModel().accountUsedFor);
        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getMemberDiligencePageModel().accountUsedFor));
        Thread.sleep(1000);
//        wait(getMemberDiligencePageModel().checkDropdown);
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(), getMemberDiligencePageModel().checkDropdown);
//        log.info("Element Selected");

        Thread.sleep(1000);
        List<WebElement> signButtons = driver.findElements(By.xpath("//tf-expansion-panel//tf-radio//input[@value='No']"));
        log.info("Found " + signButtons.size() + " sign buttons to click.");
        for (int i = 0; i < signButtons.size(); i++) {
            log.info("Clicking on Sign button " + i);
            WebElement btn = signButtons.get(i);
            Thread.sleep(100);
            browserActions.scrollToWebElement(getSeleniumdriver(), btn);
            Thread.sleep(100);
            btn.click();
        }








        //        waitForSpinnerToDisappear();
//        log.info("entering number of locations");
//        waitForSpinnerToDisappear();
//        waitForVisibilityWithLoader("//*[contains(text(),'GENERAL INFORMATION')]");
//        browserActions.scrollToWebElement(getSeleniumdriver(), getMemberDiligencePageModel().tradeArea);
//
//        waitWithSpinner(getMemberDiligencePageModel().tradeArea);
//        waitWithSpinner(getMemberDiligencePageModel().location);
//        browserActions.scrollToWebElement(getSeleniumdriver(),getMemberDiligencePageModel().location);
//        selectElement(getSeleniumdriver().getWebDriver(),getMemberDiligencePageModel().location);
//        browserActions.enterTextNoTextClear(getSeleniumdriver(),
//                getMemberDiligencePageModel().location,
//                "1");
//        assertTrue(true);
//
//        log.info("selecting the trade scope");
//        browserActions.scrollToWebElement(getSeleniumdriver(),getMemberDiligencePageModel().tradeArea);
//        selectElement(getSeleniumdriver().getWebDriver(), getMemberDiligencePageModel().tradeArea);
//        waitWithSpinner(getMemberDiligencePageModel().tradeArea);
//        browserActions.clickButton(getSeleniumdriver(), getMemberDiligencePageModel().tradeArea);
//
//        log.info("selecting local trader");
//        selectElement(getSeleniumdriver().getWebDriver(),getMemberDiligencePageModel().tradeLocal);
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                getMemberDiligencePageModel().tradeLocal);
//        assertTrue(true);
//        log.info("trading locally selected");
//
//        waitForSpinnerToDisappear();
//        WebDriver driver = getSeleniumdriver().getWebDriver();
//        int totalDrops = driver.findElements(By.xpath("//tf-detail-header[.//span[text()='Related Person']]")).size();
//
//        log.info("Total persons found: " + totalDrops);
//        for (int index = 1; index <= totalDrops; index++) {
//            try {
//                List<WebElement> drops = driver.findElements(By.xpath("//tf-detail-header[.//span[text()='Related Person']]"));
//                WebElement currentDrop = drops.get(index - 1);
//                browserActions.scrollToWebElement(getSeleniumdriver(), currentDrop);
//                waitWithSpinner(currentDrop);
//                 selectElement(getSeleniumdriver().getWebDriver(),currentDrop);
//                if (currentDrop.isDisplayed()) {
//                    browserActions.clickApply(driver, currentDrop);
//                    WebElement employmentStatusElement = currentDrop.findElement(By.xpath("(//tf-dropdown[@t-model='Employment_Status']//input)" + "[" + index + "]"));
//                    browserActions.scrollToWebElement(getSeleniumdriver(),employmentStatusElement);
//                    waitWithSpinner(employmentStatusElement);
//                    selectElement(getSeleniumdriver().getWebDriver(),employmentStatusElement);
//
//                    if (employmentStatusElement.isDisplayed()) {
//                        browserActions.scrollToWebElement(getSeleniumdriver(),employmentStatusElement);
//                        selectElement(getSeleniumdriver().getWebDriver(),employmentStatusElement);
//                        browserActions.clickButton(getSeleniumdriver(), employmentStatusElement);
//
//                        WebElement selfEmployedSelectedElement = currentDrop.findElement(By.xpath("//div[@class='dropdown-item ng-star-inserted'][contains(text(),'Self Employed')]"));
//                        if (selfEmployedSelectedElement.isDisplayed()) {
//                            browserActions.scrollToWebElement(getSeleniumdriver(),selfEmployedSelectedElement);
//                            selectElement(getSeleniumdriver().getWebDriver(),selfEmployedSelectedElement);
//                            browserActions.clickApply(getSeleniumdriver().getWebDriver(), selfEmployedSelectedElement);
//                        }
//
//                        WebElement occupationNameElement = currentDrop.findElement(By.xpath("(//tf-input[@t-model='Occupation']//input)" + "[" + index + "]"));
//                        if (occupationNameElement.isDisplayed()) {
//                            browserActions.scrollToWebElement(getSeleniumdriver(),occupationNameElement);
//                            selectElement(getSeleniumdriver().getWebDriver(),occupationNameElement);
//                            browserActions.enterText(getSeleniumdriver(), occupationNameElement, "Farmer");
//                        }
//                    }
//
//                    WebElement pepStatusElement = currentDrop.findElement(By.xpath("(//tf-dropdown[@t-model='PEP_Member_Type']//input)" + "[" + index + "]"));
//                    if (pepStatusElement.isDisplayed()) {
//                        browserActions.scrollToWebElement(getSeleniumdriver(),pepStatusElement);
//                        selectElement(getSeleniumdriver().getWebDriver(),pepStatusElement);
//                        browserActions.clickButton(getSeleniumdriver(), pepStatusElement);
//
//                        WebElement noPEPSelectedElement = currentDrop.findElement(By.xpath("//div[@class='dropdown-item ng-star-inserted'][contains(text(),'No')]"));
//                        if (noPEPSelectedElement.isDisplayed()) {
//                            browserActions.scrollToWebElement(getSeleniumdriver(),noPEPSelectedElement);
//                            selectElement(getSeleniumdriver().getWebDriver(),noPEPSelectedElement);
//                            browserActions.clickApply(getSeleniumdriver().getWebDriver(), noPEPSelectedElement);
//                        }
//                    }
//                }
//            } catch (NoSuchElementException e) {
//                log.warn("No element found or error at index " + index + ", skipping.");
//            }
//        }
//
    }

}
