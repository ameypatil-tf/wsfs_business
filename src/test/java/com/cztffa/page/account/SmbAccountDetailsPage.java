package com.cztffa.page.account;

import com.cztffa.dataproviders.DataCSVExtractor;
import com.cztffa.objects.Person;
import com.cztffa.page.memberdiligence.MemberDiligencePage;
import com.cztffa.page.memberdiligence.SmbMemberDiligence;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.NoSuchElementException;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

@Slf4j

public class SmbAccountDetailsPage extends SmbMemberDiligence {

    public void addAcountDetails(Person person) throws InterruptedException {
        WebDriver driver = getSeleniumdriver().getWebDriver();
        person.getAccountDetails().isSkipped();
        //		log.info("Inside account deatils skipped");
        //		closeWindows();

        Thread.sleep(1000);
        List<WebElement> toggleButtons = driver.findElements(By.xpath("//div//tf-checkbox[@t-model='selected']"));
        log.info("Found " + toggleButtons.size() + " sign buttons to click.");
        for (int i = 0; i < toggleButtons.size(); i++) {
            log.info("Clicking on Sign button " + i);
            WebElement btn = toggleButtons.get(i);
            Thread.sleep(100);
            browserActions.scrollToWebElement(getSeleniumdriver(), btn);
            Thread.sleep(100);
            btn.click();
        }


        JavascriptExecutor j = (JavascriptExecutor) getSeleniumdriver().getWebDriver();
        j.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);
        browserActions.scrollToWebElement(getSeleniumdriver(),getSmbAccountDetailsPageModel().AccountDetailsNextButton);
        Thread.sleep(3000);
        browserActions.clickButton(getSeleniumdriver(), getSmbAccountDetailsPageModel().AccountDetailsNextButton);
        Thread.sleep(10000);
    }
}





//    public void fillAccountDetails() throws InterruptedException {
//        waitForSpinnerToDisappear();
//        WebDriver driver = getSeleniumdriver().getWebDriver();
//        Thread.sleep(1000);
//        waitForVisibilityWithLoader("//*[contains(text(),'Setup your new account')]");
//        String authorityTypeDropdownXPath = "(//tf-dropdown[@t-model='OnlineBankingAuthority__c']//input)";
//
//        List<WebElement> authorityTypeDrops = driver.findElements(By.xpath(authorityTypeDropdownXPath));
//        int totalAuthorityTypes = authorityTypeDrops.size();
//
//        log.info("Total Authority Type dropdowns found: " + totalAuthorityTypes);
//
//        for (int i = 1; i <=totalAuthorityTypes; i++) {
//            try {
//                List<WebElement> currentAuthorityTypeDrops = driver.findElements(By.xpath(authorityTypeDropdownXPath));
//                WebElement currentAuthorityType = currentAuthorityTypeDrops.get(i-1);
//
//                if (currentAuthorityType.isDisplayed()) {
//                    log.info("Processing visible Authority Type dropdown at index: " + (i));
//                    WebElement AuthorityType = currentAuthorityType.findElement(By.xpath("(//tf-dropdown[@t-model='OnlineBankingAuthority__c']//input)" + "[" + i + "]"));
//                    browserActions.scrollToWebElement(getSeleniumdriver(), AuthorityType);
//
//                    selectElement(getSeleniumdriver().getWebDriver(),AuthorityType);
//                    if (AuthorityType.isDisplayed()) {
//                        browserActions.scrollToWebElement(getSeleniumdriver(),AuthorityType);
//                        selectElement(getSeleniumdriver().getWebDriver(),AuthorityType);
//                        browserActions.clickButton(getSeleniumdriver(), AuthorityType);
//
//                        WebElement administratorSelectedElement = currentAuthorityType.findElement(By.xpath("//div[@class='dropdown-item ng-star-inserted'][contains(text(),'Administrator')]"));
//                        if (administratorSelectedElement.isDisplayed()) {
//                            browserActions.scrollToWebElement(getSeleniumdriver(),administratorSelectedElement);
//                            selectElement(getSeleniumdriver().getWebDriver(),administratorSelectedElement);
//                            browserActions.clickApply(getSeleniumdriver().getWebDriver(), administratorSelectedElement);
//                        }
//                    }
//                }
//            } catch (NoSuchElementException e) {
//                log.warn("No Authority Type element found or error at index " + (i + 1) + ", skipping.", e);
//            }
//        }
//        log.info("checking business cd");
//        if (driver.getPageSource().contains("Business CD")) {
//            wait(getSmbAccountDetailsPageModel().BusinessCdInfo);
//            browserActions.scrollToWebElement(getSeleniumdriver(), getSmbAccountDetailsPageModel().BusinessCdInfo);
//            waitWithShortTime(getSeleniumdriver());
//            browserActions.clickButton(getSeleniumdriver(), getSmbAccountDetailsPageModel().BusinessCdInfo);
//
//            wait(getSmbAccountDetailsPageModel().certificateTerm);
//            browserActions.scrollToWebElement(getSeleniumdriver(), getSmbAccountDetailsPageModel().certificateTerm);
//            selectElement(getSeleniumdriver().getWebDriver(),getSmbAccountDetailsPageModel().certificateTerm);
//            browserActions.clickButton(getSeleniumdriver(), getSmbAccountDetailsPageModel().certificateTerm);
//            wait(getSmbAccountDetailsPageModel().certificateTermSelect);
//            selectElement(getSeleniumdriver().getWebDriver(),getSmbAccountDetailsPageModel().certificateTerm);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(), getSmbAccountDetailsPageModel().certificateTermSelect);
//
//            wait(getSmbAccountDetailsPageModel().amountToEnter);
//            browserActions.clickButton(getSeleniumdriver(), getSmbAccountDetailsPageModel().amountToEnter);
//            getSmbAccountDetailsPageModel().amountToEnter.sendKeys("5000");
//            DataCSVExtractor.isFundingCompulsory = true;
//        }
//        else {
//            log.info("business cd is not there");
//        }
//    }
//}
