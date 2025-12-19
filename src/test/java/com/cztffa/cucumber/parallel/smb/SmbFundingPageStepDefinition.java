package com.cztffa.cucumber.parallel.smb;

import com.cztffa.browseractions.BrowserActions;
import com.cztffa.dataproviders.DataCSVExtractor;
import com.cztffa.driver.SeleniumDriver;
import com.cztffa.objects.Funding;
import com.cztffa.page.review.SmbReviewPage;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONObject;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@Slf4j

public class SmbFundingPageStepDefinition {
    private SeleniumDriver seleniumdriver;
    private BrowserActions browserActions;
    private SmbReviewPage smbReviewPage;


    public SmbFundingPageStepDefinition(SmbReviewPage smbReviewPage) {
        this.seleniumdriver = smbReviewPage.getSeleniumdriver();
        this.browserActions = smbReviewPage.browserActions;
        this.smbReviewPage=smbReviewPage;
    }

    @And("^: I should see the business funding page$")
    public void navigateToBusinessFundingPage() throws Throwable {
        smbReviewPage.letSpinnerDisappear();
        assertTrue(seleniumdriver.getWebDriver().getPageSource().contains("How would you like to fund your account"));
    }
    @SneakyThrows
    @Then(": I provide below funding amount for smb for {string}")
    public void iProvideBelowFundingAmountForSmbFor(String submissionId) throws Throwable {
        if (seleniumdriver.getWebDriver().getPageSource().contains("Amount")) {

            List<Map<?, ?>> fundingList = DataCSVExtractor.smbfundingDataStore;
            int index = 0;
            ObjectMapper objectMapper = new ObjectMapper();
            for (int i = 0; i < fundingList.size(); i++) {
                Map<?, ?> row = fundingList.get(i);
                if (row.get("submissionId").equals(submissionId)) {
                    JSONObject jsonObject = new JSONObject(row);
                    Funding funding = objectMapper.readValue(jsonObject.toString(), Funding.class);
                    smbReviewPage.addFundAmountForSMB(funding, index);
                    index++;
                    log.info("Funding amount added for Product: " + i);
                }
            }
            log.info("Funding Amount Completed for submissionId: " + submissionId);
            Thread.sleep(2000);
//            smbReviewPage.spinner();
            Thread.sleep(2000);
        }
    }
    @Then(": I provide below funding details for smb for {string}")
    public void iProvideBelowFundingDetailsForSmb(String submissionId) throws JsonProcessingException, InterruptedException {
        List<Map<?,?>> fundingList = DataCSVExtractor.smbfundingDataStore;
        ObjectMapper objectMapper = new ObjectMapper();
        for (int i = 0; i < fundingList.size(); i++) {
            Map<?,?> row = fundingList.get(i);
            Object fundingObj = row.get("submissionId");
            if (fundingObj != null && fundingObj.toString().trim().equals(submissionId)){
                JSONObject jsonObject = new JSONObject(row);
                Funding funding = objectMapper.readValue(jsonObject.toString(), Funding.class);
                smbReviewPage.addFundDetailsForSMB(funding);
                log.info("Funding added for submissionId: " + submissionId);
                break;
            }
//
        }
        log.info("Funding Page Completed for submissionId: " + submissionId);
    }

    @Then("^: I click on business funding page next button$")
    public void clickFundingPageNextButton() throws Throwable {
        smbReviewPage.waitForSpinnerToDisappear();
        browserActions.scrollToWebElement(seleniumdriver,smbReviewPage.getBusinessInfoPageModel().businessInfoNextButon);
        smbReviewPage.waitWithSpinner(smbReviewPage.getBusinessInfoPageModel().businessInfoNextButon);
        browserActions.clickUsingEnter(seleniumdriver.getWebDriver(), smbReviewPage.getBusinessInfoPageModel().businessInfoNextButon);
        Thread.sleep(1000);
        smbReviewPage.waitForSpinnerToDisappear();
    }

}
