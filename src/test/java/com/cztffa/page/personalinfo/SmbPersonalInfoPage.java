package com.cztffa.page.personalinfo;


import com.cztffa.dataproviders.DataCSVExtractor;
import com.cztffa.driver.SeleniumDriver;
import com.cztffa.objects.Applicant;
import com.cztffa.objects.Business;
import com.cztffa.objects.Person;
import com.cztffa.objects.Validation;
import com.cztffa.page.businessinfo.BusinessInfoPage;
import com.cztffa.page.product.SmbProductSelectorPage;
import com.cztffa.page.review.ReviewPage;
import com.cztffa.page.review.SmbReviewPage;
import com.cztffa.util.ApplicantUtil;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;


import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@Slf4j

public class SmbPersonalInfoPage extends BusinessInfoPage {
    private SeleniumDriver seleniumdriver;
    private ReviewPage reviewPage;
    private SmbReviewPage smbReviewPage;

    //    protected void addPersonalDetails(Person person) throws InterruptedException {
//        addApplicant(person, 0);
//        int i = 0;
//        if (person.getApplicants() != null && person.getApplicants().size() > 0) {
//            browserActions.clickButton(getSeleniumdriver(), getSmbPersonalInfoPageModel().addAdditionalApplicantButton);
//            Thread.sleep(3000);
//            for (Applicant applicant : person.getApplicants()) {
//                addApplicant(applicant, ++i);
//            }
//        }
//        Thread.sleep(7000);
//        browserActions.clickButton(getSeleniumdriver(), getSmbPersonalInfoPageModel().personalInfoNextButon);
//
//        Thread.sleep(10000);
//    }
//

    public WebElement element (String xpath,int index){
        ApplicantUtil applicantUtil = new ApplicantUtil();
        return applicantUtil.getWebElement(getSeleniumdriver(), xpath, index);
    }
//
//

    public void addApplicantForSMB(Person person, int index) throws InterruptedException {
        waitForSpinnerToDisappear();
        Thread.sleep(1000);
        ApplicantUtil applicantUtil = new ApplicantUtil();
        Validation validation = person.getValidation();
        String pageSource = getSeleniumdriver().getWebDriver().getPageSource();

        //            log.info("Clicking on 'yes'");
//            browserActions.clickButton(getSeleniumdriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectionYes, index));
//        String textToCheck = "Proceed without prefill";
//        if (pageSource.contains(textToCheck)) {
//            browserActions.scrollToWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//           wait(getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//            browserActions.clickUsingEnter(getSeleniumdriver().getWebDriver(),getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//                waitForSpinnerToDisappear();
//        WebElement firstName = applicantUtil.getWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().firstName, index);
//        wait(firstName);


        waitForSpinnerToDisappear();
        waitWithSpinner(element(getSmbPersonalInfoPageModel().firstName, index));
        log.info("Entering first name");
        WebElement firstName = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().firstName, index);
        browserActions.scrollToWebElement(getSeleniumdriver(), firstName);
        wait(firstName);
        browserActions.enterText(getSeleniumdriver(),
                element(getSmbPersonalInfoPageModel().firstName, index),
                person.getFirstName());
        assertTrue(true);
        log.info("Entering middle name");
        browserActions.enterTextKeyEntry(getSeleniumdriver(),
                element(getSmbPersonalInfoPageModel().middleName, index),
                person.getMiddleName());
        log.info("Entering last name");
        browserActions.enterText(getSeleniumdriver(),
                element(getSmbPersonalInfoPageModel().lastName, index),
                person.getLastName());

        log.info("selecting street address dropdown ::" + person.getStreetAddress1());
        WebElement streetAddress1 = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().streetAddress1, index);
        browserActions.scrollToWebElement(getSeleniumdriver(), streetAddress1);
        wait(streetAddress1);
        Thread.sleep(1000);
        selectElement(getSeleniumdriver().getWebDriver(), streetAddress1);
        browserActions.enterText(getSeleniumdriver(),
                element(getSmbPersonalInfoPageModel().streetAddress1, index), person.getStreetAddress1());
        Thread.sleep(4000);
        WebElement addressText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getStreetAddress1());
        browserActions.scrollToWebElement(getSeleniumdriver(), addressText);
        wait(addressText);
        selectElement(getSeleniumdriver().getWebDriver(), addressText);
        addressText.click();

        browserActions.scrollToWebElement(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().city, index));
        browserActions.enterText(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().city, index), person.getCity());
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().zip, index),
                person.getZip());
        log.info("After entering Zipcode");
        Thread.sleep(1000);

        log.info("Entering year");
        WebElement year = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().year, index);
        browserActions.scrollToWebElement(getSeleniumdriver(),year);
        Thread.sleep(500);
        browserActions.scrollToWebElement(getSeleniumdriver(),year);
        Thread.sleep(500);
        browserActions.enterText(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().year, index),
                person.getYear());
        assertTrue(true);
        Thread.sleep(500);


        log.info("entering mobile phone no");
        WebElement mobilePhone = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().phoneNumber, index);
        browserActions.scrollToWebElement(getSeleniumdriver(), mobilePhone);
        Thread.sleep(1000);
        //wait(mobilePhone);
        browserActions.enterTextKeyEntry(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().phoneNumber, index),
                person.getPhoneNumber());


        log.info("entering work phone no");
        WebElement workPhone = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().workPhone, index);
        browserActions.scrollToWebElement(getSeleniumdriver(), workPhone);
        wait(workPhone);
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().workPhone, index),
                person.getWorkPhone());

        log.info("entering email");
        WebElement email = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index);
        browserActions.scrollToWebElement(getSeleniumdriver(), email);
        wait(email);
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index),
                person.getEmail());


        log.info("selecting idType method {}", person.getPrefferedId());
        //if (person.getPrefferedId().equalsIgnoreCase("Drivers License")){
        browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PrefferedId, index));
        wait(element(getSmbPersonalInfoPageModel().stateIssued, index));
        browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PrefferedId, index));

        WebElement idText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idText, person.getPrefferedId());
        selectElement(getSeleniumdriver().getWebDriver(), idText);
        idText.click();
        assertTrue(true);
        //}
        Thread.sleep(1000);


        WebElement idNumber = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index);
        browserActions.scrollToWebElement(getSeleniumdriver(), idNumber);
        Thread.sleep(1000);
        wait(element(getSmbPersonalInfoPageModel().idNumber, index));
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index),
                person.getIdentificationNumber());

        log.info("selecting stateIssued dropdown ");
        browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));
        wait(element(getSmbPersonalInfoPageModel().stateIssued, index));
        browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));

        WebElement stateText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateText, person.getStateIssued());
        browserActions.scrollToWebElement(getSeleniumdriver(), stateText);
        wait(stateText);
        selectElement(getSeleniumdriver().getWebDriver(), stateText);
        stateText.click();
        wait(element(getSmbPersonalInfoPageModel().issueDate, index));
        browserActions.enterTextKeyEntry(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().issueDate, index),
                person.getIssueDate());
        wait(element(getSmbPersonalInfoPageModel().expiryDate, index));
        browserActions.enterTextKeyEntry(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().expiryDate, index),
                person.getExpiryDate());

        log.info("Entering date of birth");
        getSeleniumdriver().getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
        wait(element(getSmbPersonalInfoPageModel().dateOfBirth, index));
        assertTrue(true);

        browserActions.scrollToWebElement(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().dateOfBirth, index));
        browserActions.enterTextKeyEntry(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().dateOfBirth, index), person.getDob());

        log.info("entering SSN");
        browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index));
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index),
                person.getSsn());
        log.info("SSN entered");

//
        log.info("Select PEP Answer");
        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().IsPEPPresent, index));
        log.info("PEP answer Selected");

        log.info("PEPMemberType");
        browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PEPMemberType, index));
        wait(element(getSmbPersonalInfoPageModel().PEPMemberType, index));
        browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PEPMemberType, index));
        WebElement MemberText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().MemberText, person.getMemberType());
        browserActions.scrollToWebElement(getSeleniumdriver(), MemberText);
        wait(MemberText);
        selectElement(getSeleniumdriver().getWebDriver(), MemberText);
        MemberText.click();
        Thread.sleep(2000);

        log.info("Clicking next button");

        waitWithSpinner(getSmbPersonalInfoPageModel().personalInfoNextButon);
        waitForSpinnerToDisappear();
        browserActions.scrollToWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().personalInfoNextButon);
        waitWithSpinner(getSmbPersonalInfoPageModel().personalInfoNextButon);
        browserActions.clickApply(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().personalInfoNextButon);
        log.info("clicked on Personal info");
        Thread.sleep(2000);
        waitForSpinnerToDisappear();

        waitWithSpinner(getSmbPersonalInfoPageModel().saveModalContinueButton);
        waitForSpinnerToDisappear();
        browserActions.scrollToWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().saveModalContinueButton);
        waitWithSpinner(getSmbPersonalInfoPageModel().saveModalContinueButton);
        browserActions.clickApply(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().saveModalContinueButton);
        log.info("clicked on Personal info");
        Thread.sleep(2000);
        waitForSpinnerToDisappear();




    }

//


//
//        if(index==0) {
//            browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index));
//            WebElement relationCode = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index);
//            wait(relationCode);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index));
//            browserActions.enterText(getSeleniumdriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index),
//                    person.getRelationship());
//                WebElement relationSelect = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().getRelationionshipOfPerson, person.getRelationship());
//                browserActions.scrollToWebElement(getSeleniumdriver(),relationSelect);
//            waitWithSpinner(relationSelect);
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(),relationSelect);
//
//                log.info("Entering Relationship percentage if existed entered");
//            if(person.getRelationship().equalsIgnoreCase("Owner")) {
//                DataCSVExtractor.ownerCount++;
//                log.info("Owner Count");
//                wait(getSmbPersonalInfoPageModel().percentage);
//                log.info("Relationship selected");
//                browserActions.scrollToWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().percentage);
//                wait(getSmbPersonalInfoPageModel().percentage);
//                browserActions.enterTextKeyEntry(getSeleniumdriver(), getSmbPersonalInfoPageModel().percentage, person.getOwnershipPercentage());
//            }
//        }
//    }


        public void addApplicantsForSmb (Person person,int index) throws InterruptedException {
            getSeleniumdriver().getWebDriver().manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
            ApplicantUtil applicantUtil = new ApplicantUtil();
            Validation validation = person.getValidation();
            waitForSpinnerToDisappear();
            String pageSource = getSeleniumdriver().getWebDriver().getPageSource();
            log.info(String.valueOf(index));

//        if (pageSource.contains("Are you a beneficial owner")) {
//            log.info("Clicking on 'yes'");
//            browserActions.clickButton(getSeleniumdriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectionYes, index));
//            log.info("Entered proceed without prefill");
//            waitForSpinnerToDisappear();
//            browserActions.scrollToWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//            waitWithSpinner(getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//            browserActions.clickUsingEnter(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//
//        }else {
//            browserActions.scrollToWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//            waitWithSpinner(getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//            browserActions.clickUsingEnter(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().proceedWithoutPrefillBtn);
//        }

        waitForSpinnerToDisappear();
        log.info("Moved after proceed with prefill");
////        WebElement firstName= applicantUtil.getWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().firstName, index);
////        waitWithSpinner(firstName);
//        browserActions.scrollToWebElement(getSeleniumdriver(),firstName);




            waitForSpinnerToDisappear();
            waitWithSpinner(element(getSmbPersonalInfoPageModel().firstName, index));
            log.info("Entering first name");
            WebElement firstName = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().firstName, index);
            browserActions.scrollToWebElement(getSeleniumdriver(), firstName);
            wait(firstName);
            browserActions.enterText(getSeleniumdriver(),
                    element(getSmbPersonalInfoPageModel().firstName, index),
                    person.getFirstName());
            assertTrue(true);
            log.info("Entering middle name");
            browserActions.enterTextKeyEntry(getSeleniumdriver(),
                    element(getSmbPersonalInfoPageModel().middleName, index),
                    person.getMiddleName());
            log.info("Entering last name");
            browserActions.enterText(getSeleniumdriver(),
                    element(getSmbPersonalInfoPageModel().lastName, index),
                    person.getLastName());

            log.info("selecting street address dropdown ::" + person.getStreetAddress1());
            WebElement streetAddress1 = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().streetAddress1, index);
            browserActions.scrollToWebElement(getSeleniumdriver(), streetAddress1);
            wait(streetAddress1);
            Thread.sleep(1000);
            selectElement(getSeleniumdriver().getWebDriver(), streetAddress1);
            browserActions.enterText(getSeleniumdriver(),
                    element(getSmbPersonalInfoPageModel().streetAddress1, index), person.getStreetAddress1());
            Thread.sleep(4000);
            WebElement addressText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getStreetAddress1());
            browserActions.scrollToWebElement(getSeleniumdriver(), addressText);
            wait(addressText);
            selectElement(getSeleniumdriver().getWebDriver(), addressText);
            addressText.click();

            browserActions.scrollToWebElement(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().city, index));
            browserActions.enterText(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().city, index), person.getCity());
            browserActions.enterText(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().zip, index),
                    person.getZip());
            log.info("After entering Zipcode");
            Thread.sleep(500);

            log.info("Entering year");
            WebElement year = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().year, index);
            browserActions.scrollToWebElement(getSeleniumdriver(),year);
            Thread.sleep(500);
            browserActions.scrollToWebElement(getSeleniumdriver(),year);
            Thread.sleep(500);
            browserActions.enterText(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().year, index),
                    person.getYear());
            assertTrue(true);
            Thread.sleep(500);

            log.info("entering mobile phone no");
            WebElement mobilePhone = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().phoneNumber, index);
            browserActions.scrollToWebElement(getSeleniumdriver(), mobilePhone);
            Thread.sleep(1000);
            //wait(mobilePhone);
            browserActions.enterTextKeyEntry(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().phoneNumber, index),
                    person.getPhoneNumber());


            log.info("entering work phone no");
            WebElement workPhone = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().workPhone, index);
            browserActions.scrollToWebElement(getSeleniumdriver(), workPhone);
            wait(workPhone);
            browserActions.enterText(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().workPhone, index),
                    person.getWorkPhone());

            log.info("entering email");
            WebElement email = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index);
            browserActions.scrollToWebElement(getSeleniumdriver(), email);
            wait(email);
            browserActions.enterText(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index),
                    person.getEmail());




            log.info("selecting idType method {}", person.getPrefferedId());
            //if (person.getPrefferedId().equalsIgnoreCase("Drivers License")){
            WebElement IDText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getPrefferedId());
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    IDText);
            assertTrue(true);
            //}
            Thread.sleep(1000);


            WebElement idNumber = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index);
            browserActions.scrollToWebElement(getSeleniumdriver(), idNumber);
            Thread.sleep(1000);
            wait(element(getSmbPersonalInfoPageModel().idNumber, index));
            browserActions.enterText(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index),
                    person.getIdentificationNumber());

            log.info("selecting stateIssued dropdown ");
            browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));
            wait(element(getSmbPersonalInfoPageModel().stateIssued, index));
            browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));

            WebElement stateText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateText, person.getStateIssued());
            browserActions.scrollToWebElement(getSeleniumdriver(), stateText);
            wait(stateText);
            selectElement(getSeleniumdriver().getWebDriver(), stateText);
            stateText.click();
            wait(element(getSmbPersonalInfoPageModel().issueDate, index));
            browserActions.enterTextKeyEntry(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().issueDate, index),
                    person.getIssueDate());
            wait(element(getSmbPersonalInfoPageModel().expiryDate, index));
            browserActions.enterTextKeyEntry(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().expiryDate, index),
                    person.getExpiryDate());

            log.info("Entering date of birth");
            getSeleniumdriver().getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
            wait(element(getSmbPersonalInfoPageModel().dateOfBirth, index));
            assertTrue(true);

            browserActions.scrollToWebElement(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().dateOfBirth, index));
            browserActions.enterTextKeyEntry(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().dateOfBirth, index), person.getDob());

            log.info("entering SSN");
            browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index));
            browserActions.enterText(getSeleniumdriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index),
                    person.getSsn());
            log.info("SSN entered");

//

            log.info("Select PEP Answer");
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().IsPEPPresent, index));
            log.info("PEP answer Selected");

            log.info("PEPMemberType");
            browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PEPMemberType, index));
            wait(element(getSmbPersonalInfoPageModel().PEPMemberType, index));
            browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PEPMemberType, index));
            WebElement MemberText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().MemberText, person.getMemberType());
            browserActions.scrollToWebElement(getSeleniumdriver(), MemberText);
            wait(MemberText);
            selectElement(getSeleniumdriver().getWebDriver(), MemberText);
            MemberText.click();

//            log.info("");
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().IsPEPPresent, index));
//            log.info("PEP answer Selected");




//        if (index == 0) {
//            browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index));
//            WebElement relationCode = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index);
//            waitWithSpinner(relationCode);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index));
//            waitWithSpinner(getSmbPersonalInfoPageModel().relationSelect);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    getSmbPersonalInfoPageModel().relationSelect);
//
//            log.info("Relationship selected");
//            browserActions.enterTextKeyEntry(getSeleniumdriver(), getSmbPersonalInfoPageModel().percentage, person.getOwnershipPercentage());
//        } else {
//            log.info("index greater than 0");
//            WebElement relationCode = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index);
//
//            browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index));
//            waitWithSpinner(relationCode);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index));
//            browserActions.enterText(getSeleniumdriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().selectRelation, index),
//                    person.getRelationship());
//
//            WebElement relationSelect = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().getRelationionshipOfPerson, person.getRelationship());
//
//            browserActions.scrollToWebElement(getSeleniumdriver(),relationSelect);
//            waitWithSpinner(relationSelect);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),relationSelect);
//
//            log.info("Entering Relationship percentage if exist");
//            if (person.getRelationship().equalsIgnoreCase("Owner")) {
//               DataCSVExtractor.ownerCount++;
//                log.info("value of index="+index);
//                log.info("value of owner="+DataCSVExtractor.ownerCount);
//                String percentage = "(//input[@type='text' and @inputmode='decimal' and @class='form-control'])[" + DataCSVExtractor.ownerCount + "]";
//                log.info(percentage);
//                WebElement enterPercentage=getSeleniumdriver().getWebDriver().findElement(By.xpath(percentage));
//                browserActions.scrollToWebElement(getSeleniumdriver(),enterPercentage);
//                waitWithSpinner(enterPercentage);
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(),enterPercentage);
//                  browserActions.enterTextKeyEntry(getSeleniumdriver(), enterPercentage, person.getOwnershipPercentage());
//            }
//            log.info("After entering Relationcode" + person.getRelationship());
//        }

    }

    public void clickRelationsDetailNextButtonHelper() throws InterruptedException {
        waitForSpinnerToDisappear();
        log.info("clicking on personalInfo Next Button");
        waitForVisibilityWithLoader("//*[contains(text(),'Specify how the individuals')]");
        waitWithSpinner(getSmbPersonalInfoPageModel().personalInfoNextButon);
        browserActions.scrollToWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().personalInfoNextButon);
        waitWithSpinner(getSmbPersonalInfoPageModel().personalInfoNextButon);
        browserActions.clickUsingEnter(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().personalInfoNextButon);
    }
//
            public void fillDetailsForSMB (Person person) throws InterruptedException {
                waitWithSpinner(getSmbGettingStartedPageModel().firstName);
                browserActions.enterText(getSeleniumdriver(), getSmbGettingStartedPageModel().firstName, person.getFirstName());
                browserActions.enterText(getSeleniumdriver(), getSmbGettingStartedPageModel().lastName, person.getLastName());
                wait(getSmbGettingStartedPageModel().phoneNumber);
                browserActions.scrollToWebElement(getSeleniumdriver(), getSmbGettingStartedPageModel().phoneNumber);
                browserActions.enterText(getSeleniumdriver(), getSmbGettingStartedPageModel().phoneNumber, person.getPhoneNumber());
                browserActions.enterText(getSeleniumdriver(), getSmbGettingStartedPageModel().personalEmail, person.getEmail());
                Thread.sleep(1000);
                browserActions.clickButton(getSeleniumdriver(), getSmbGettingStartedPageModel().acceptPolicy);
                waitForSpinnerToDisappear();
//        wait(getSmbGettingStartedPageModel().acceptBtn);
//        browserActions.clickUsingEnter(getSeleniumdriver().getWebDriver(), getSmbGettingStartedPageModel().acceptBtn);
            }





}
//    }

