package com.cztffa.cucumber.parallel.smb;

import com.cztffa.browseractions.BrowserActions;
import com.cztffa.dataproviders.DataCSVExtractor;
import com.cztffa.driver.SeleniumDriver;
import com.cztffa.objects.StepData;
import com.cztffa.page.review.SmbReviewPage;
import com.cztffa.xpath.consumer.Product;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.testng.Reporter;

import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

@Slf4j

public class SmbHomePageStepDefinition {

    private SeleniumDriver seleniumdriver;
    private BrowserActions browserActions;
    private SmbReviewPage smbReviewPage;
    private StepData stepData;

    public SmbHomePageStepDefinition(SmbReviewPage smbReviewPage) {
        this.browserActions = smbReviewPage.browserActions;
        this.smbReviewPage = smbReviewPage;
        this.stepData = stepData;
    }

    @Before("@SMBFlow")
    public void setUp(Scenario scenario) {
        log.info("Starting scenario {} ", scenario.getName());
    }

    @Given(": I am at the smb home page")
    public void iAmAtTheSmbHomePage() {
        try {
            log.info("Starting of home page");
            String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
            String channel = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("channel");
            smbReviewPage.launch(channel,browser);
            this.seleniumdriver = smbReviewPage.getSeleniumdriver();
            log.info("loaded home page ");
        } catch (Exception ex) {
            log.error("Failed in home page loading");
        }
    }

    @When(": I click on the business tab$")
    public void i_click_on_the_business_tab() throws InterruptedException {
        log.info("Before click of business tab");
        Thread.sleep(3000);
        smbReviewPage.waitForSpinnerToDisappear();
        smbReviewPage.waitForSpinnerToDisappear();
        smbReviewPage.waitWithSpinner(smbReviewPage.getSmbProductSelectorPageModel().Business);
        browserActions.clickButton(seleniumdriver,smbReviewPage.getSmbProductSelectorPageModel().Business);
    }

//    @Then(": I click on product for {string}")
//    public void iClickOnProduct(String submissionId) throws Throwable {
//        if (seleniumdriver.getWebDriver().getPageSource().contains("Checkout")) {
//            List<Map<?, ?>> productDataStore = DataCSVExtractor.productDataStore;
//
//            log.info("Clicking all products for submissionId: " + submissionId);
//            for (Map<?, ?> map : productDataStore) {
//                String rowSubmissionId = map.get("submissionId").toString().trim();
//                if (!rowSubmissionId.equals(submissionId)) continue;
//                String product = map.get("product").toString().trim();
//                String xpath = Product.getByName(product).getXpath();
//                smbReviewPage.wait(xpath);
//                WebElement element = browserActions.findElement(seleniumdriver, By.xpath(xpath));
//                browserActions.scrollToWebElement(seleniumdriver, element);
//                smbReviewPage.waitWithSpinner(element);
//                browserActions.clickUsingEnter(seleniumdriver.getWebDriver(), element);
//                log.info("Clicked product: " + product);
//            }
//            Thread.sleep(2000);
//            //smbReviewPage.spinner();
//            Thread.sleep(2000);
//        }
//    }

//    @And("^: I click on the checkout$")
//    public void iClickOnTheCheckout() throws Throwable {
//        if (seleniumdriver.getWebDriver().getPageSource().contains("Checkout")) {
//            log.info("Before click of checkout btn");
//            smbReviewPage.wait(smbReviewPage.getSmbProductSelectorPageModel().checkout);
//            browserActions.scrollToWebElement(seleniumdriver, smbReviewPage.getSmbProductSelectorPageModel().checkout);
//            Thread.sleep(1000);
//            browserActions.clickButton(seleniumdriver, smbReviewPage.getSmbProductSelectorPageModel().checkout);
//            log.info("On click of checkout btn");
//            Thread.sleep(1000);
//            //smbReviewPage.spinner();
//
//        }
//    }

//    @Then(": I click on proceed without prefill")
//    public void iClickOnProceedWithoutPrefill() throws InterruptedException {
//
//    }

    @Then("^: I should see foundation radio button validation msg$")
    public void iShouldSeeFoundationValidationMsg() throws Throwable {
        //assertTrue(reviewPage.getReviewPageModel().isRequiredError.isDisplayed());
    }

    @After("@SMBFlow")
    public void tearDown(Scenario scenario) {
        if (scenario.isFailed()) {
            final byte[] screenshot = ((TakesScreenshot) seleniumdriver.getWebDriver())
                    .getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        log.info("Finished scenario {}", scenario.getName());
        log.info("Final line it got executed {} ", scenario.getLine());
        log.info("Status of the scenario {} ", scenario.getStatus());
        seleniumdriver.getWebDriver().quit();
    }

    @Then("^: I should see product page validation msg$")
    public void iShouldSeeProductPageValidationMsg() throws Throwable {
        //assertTrue(reviewPage.getReviewPageModel().isRequiredError.isDisplayed());
    }


}
