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
//
    public WebElement element(String xpath, int index) {
        ApplicantUtil applicantUtil = new ApplicantUtil();
        return applicantUtil.getWebElement(getSeleniumdriver(), xpath, index);
    }
//
//    public void addApplicant(Person person, int index) throws InterruptedException {
//        ApplicantUtil applicantUtil = new ApplicantUtil();
//        Validation validation = person.getValidation();
//
//        waitForSpinnerToDisappear();
//        waitWithSpinner(element(getSmbPersonalInfoPageModel().firstName, index));
//        log.info("Entering first name");
//        WebElement firstName = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().firstName, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(), firstName);
//        wait(firstName);
//        browserActions.enterText(getSeleniumdriver(),
//                element(getSmbPersonalInfoPageModel().firstName, index),
//                person.getFirstName());
//        assertTrue(true);
//        log.info("Entering middle name");
//        browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                element(getSmbPersonalInfoPageModel().middleName, index),
//                person.getMiddleName());
//        log.info("Entering last name");
//        browserActions.enterText(getSeleniumdriver(),
//                element(getSmbPersonalInfoPageModel().lastName, index),
//                person.getLastName());
//
//        log.info("selecting street address dropdown ::" + person.getStreetAddress1());
//        WebElement streetAddress1 = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().streetAddress1, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(), streetAddress1);
//        wait(streetAddress1);
//        Thread.sleep(1000);
//        selectElement(getSeleniumdriver().getWebDriver(), streetAddress1);
//        browserActions.enterText(getSeleniumdriver(),
//                element(getSmbPersonalInfoPageModel().streetAddress1, index), person.getStreetAddress1());
//        Thread.sleep(4000);
//        WebElement addressText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getStreetAddress1());
//        browserActions.scrollToWebElement(getSeleniumdriver(), addressText);
//        wait(addressText);
//        selectElement(getSeleniumdriver().getWebDriver(), addressText);
//        addressText.click();
//
//        browserActions.scrollToWebElement(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().city, index));
//        browserActions.enterText(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().city, index), person.getCity());
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().zip, index),
//                person.getZip());
//        log.info("After entering Zipcode");
//
//        log.info("entering mobile phone no");
//        WebElement mobilePhone = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().phoneNumber, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(), mobilePhone);
//        Thread.sleep(1000);
//        //wait(mobilePhone);
//        browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().phoneNumber, index),
//                person.getPhoneNumber());
//
//
//        log.info("entering work phone no");
//        WebElement workPhone = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().workPhone, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(), workPhone);
//        wait(workPhone);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().workPhone, index),
//                person.getWorkPhone());
//
//        log.info("entering email");
//        WebElement email = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(), email);
//        wait(email);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index),
//                person.getEmail());
//
//        //	if ((validation == null) || validation != null && !validation.isSkipEmploymentStatusDropdown()) {
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().employment, index));
//        log.info("selecting employment method {}", person.getEmploymentStatus());
//        //if (person.getEmploymentStatus().equalsIgnoreCase("Employed")){
//        WebElement EmployedText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getEmploymentStatus());
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                EmployedText);
//        assertTrue(true);
//        // }
//        Thread.sleep(1000);
//        if (getSeleniumdriver().getWebDriver().getPageSource().contains("Current/Previous Occupation")) {
//            WebElement occupation = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().occupation, index);
//            occupation.click();
//            log.info("Eneterd occupation");
//
//            browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                    occupation, person.getOccupation());
//        }
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PrefferedId, index));
//
//
//        log.info("selecting idType method {}", person.getPrefferedId());
//        //if (person.getPrefferedId().equalsIgnoreCase("Drivers License")){
//        WebElement IDText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getPrefferedId());
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                IDText);
//        assertTrue(true);
//        //}
//        Thread.sleep(1000);
//
//
//        WebElement idNumber = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(), idNumber);
//        Thread.sleep(1000);
//        wait(element(getSmbPersonalInfoPageModel().idNumber, index));
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index),
//                person.getIdentificationNumber());
//
//        log.info("selecting stateIssued dropdown ");
//        browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));
//        wait(element(getSmbPersonalInfoPageModel().stateIssued, index));
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));
//
//        WebElement stateText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateText, person.getStateIssued());
//        browserActions.scrollToWebElement(getSeleniumdriver(), stateText);
//        wait(stateText);
//        selectElement(getSeleniumdriver().getWebDriver(), stateText);
//        stateText.click();
//        wait(element(getSmbPersonalInfoPageModel().issueDate, index));
//        browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().issueDate, index),
//                person.getIssueDate());
//        wait(element(getSmbPersonalInfoPageModel().expiryDate, index));
//        browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().expiryDate, index),
//                person.getExpiryDate());
//
//        log.info("Entering date of birth");
//        getSeleniumdriver().getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        wait(element(getSmbPersonalInfoPageModel().dateOfBirth, index));
//        assertTrue(true);
//
//        browserActions.scrollToWebElement(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().dateOfBirth, index));
//        browserActions.enterTextKeyEntry(getSeleniumdriver(), element(getSmbPersonalInfoPageModel().dateOfBirth, index), person.getDob());
//
//        log.info("entering SSN");
//        browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index));
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index),
//                person.getSsn());
//        log.info("SSN entered");
//
//        if (index == 0) {
//            log.info("Accepting Disclosure");
//            WebElement disclosure = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().IamNotSubjectTo, index);
//            Thread.sleep(500);
//            browserActions.scrollToWebElement(getSeleniumdriver(), disclosure);
//            Thread.sleep(500);
//            browserActions.clickButton(getSeleniumdriver(), disclosure);
//            log.info("Disclosure Accepted");
//        }
//
//        log.info("Select PEP Answer");
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().IsPEPPresent, index));
//        log.info("PEP answer Selected");
//
//        log.info("PEPMemberType");
//        browserActions.scrollToWebElement(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PEPMemberType, index));
//        wait(element(getSmbPersonalInfoPageModel().PEPMemberType, index));
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PEPMemberType, index));
//        WebElement MemberText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().MemberText, person.getMemberType());
//        browserActions.scrollToWebElement(getSeleniumdriver(), MemberText);
//        wait(MemberText);
//        selectElement(getSeleniumdriver().getWebDriver(), MemberText);
//        MemberText.click();
//    }

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

        //	if ((validation == null) || validation != null && !validation.isSkipEmploymentStatusDropdown()) {
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().employment, index));
//        log.info("selecting employment method {}", person.getEmploymentStatus());
//        //if (person.getEmploymentStatus().equalsIgnoreCase("Employed")){
//        WebElement EmployedText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getEmploymentStatus());
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                EmployedText);
//        assertTrue(true);
//        // }
//        Thread.sleep(1000);
//        if (getSeleniumdriver().getWebDriver().getPageSource().contains("Current/Previous Occupation")) {
//            WebElement occupation = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().occupation, index);
//            occupation.click();
//            log.info("Eneterd occupation");
//
//            browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                    occupation, person.getOccupation());
//        }
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PrefferedId, index));


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

//        if (index == 0) {
//            log.info("Accepting Disclosure");
//            WebElement disclosure = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().IamNotSubjectTo, index);
//            Thread.sleep(500);
//            browserActions.scrollToWebElement(getSeleniumdriver(), disclosure);
//            Thread.sleep(500);
//            browserActions.clickButton(getSeleniumdriver(), disclosure);
//            log.info("Disclosure Accepted");
//        }

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

    }









//        browserActions.scrollToWebElement(getSeleniumdriver(),firstName);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().firstName, index),
//                person.getFirstName());
//        assertTrue(true);
//
//        log.info("Entering middle name");
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().middleName, index),
//                person.getMiddleName());
//
//        log.info("Entering last name");
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().lastName, index),
//                person.getLastName());
//
//        log.info("Entering date of birth");
//        WebElement dobElement = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().dateOfBirth, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(), dobElement);
//        Thread.sleep(1000);
//        waitWithSpinner(dobElement);
//        browserActions.enterTextKeyEntry(getSeleniumdriver(), dobElement, person.getDob());
//
//        WebElement citizen = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().citizenship, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(),citizen);
//        waitWithSpinner(citizen);
//        log.info("selecting the citizenship dropdown");
//        browserActions.clickButton(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().citizenship, index));
//        getSeleniumdriver().getWebDriver().manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
//        if ((validation == null) || validation != null && !validation.isSkipCitizenshipDropDown()) {
//            if (person.getCitizenShip().equalsIgnoreCase("citizen")) {
//
//                log.info("selecting citizenship");
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                        getSmbPersonalInfoPageModel().citizenshipCitizenOptApply);
//                assertTrue(true);
//                log.info("selected citizen dropdown");
//
//            } else {
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                        getSmbPersonalInfoPageModel().citizenshipAlienApply);
//                log.info("selected alien citizenship dropdown");
//
//                WebElement citizenCountry = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().citizenshipCountry, index);
//                waitWithSpinner(citizenCountry);
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil
//                        .getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().citizenshipCountry, index));
//                waitWithSpinner(getSmbPersonalInfoPageModel().citizenshipCountryApply);
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                        getSmbPersonalInfoPageModel().citizenshipCountryApply);
//                WebElement willingForeign = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().willingForeign, index);
//                waitWithSpinner(willingForeign);
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(), applicantUtil
//                        .getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().willingForeign, index));
//                waitWithSpinner(getSmbPersonalInfoPageModel().willingFreignApply);
//                browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                        getSmbPersonalInfoPageModel().willingFreignApply);
//                waitForSpinnerToDisappear();
//                assertTrue(true);
//            }
//        }
//
//        log.info("selected street address dropdown ::"+person.getStreetAddress1());
//        WebElement streetAddress1= applicantUtil.getWebElement(getSeleniumdriver(),getSmbPersonalInfoPageModel().streetAddress1, index);
//        wait(streetAddress1);
//        browserActions.scrollToWebElement(getSeleniumdriver(),streetAddress1);
//        wait(streetAddress1);
//        selectElement(getSeleniumdriver().getWebDriver(),streetAddress1);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().streetAddress1, index),
//                person.getStreetAddress1());
//        WebElement addressText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getStreetAddress1());
//        browserActions.scrollToWebElement(getSeleniumdriver(),addressText);
//        wait(addressText);
//        browserActions.scrollToWebElement(getSeleniumdriver(),addressText);
//        waitForSpinnerToDisappear();
//        wait(addressText);
//        selectElement(getSeleniumdriver().getWebDriver(),addressText);
//        addressText.click();
//        WebElement city = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().city, index);
//        waitWithSpinner(city);
//        browserActions.scrollToWebElement(getSeleniumdriver(),city);
//        wait(city);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().city, index),
//                person.getCity());
//        if ((validation == null) || validation != null && !validation.isSkipStateDropdown()) {
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().state, index));
//            wait(getSmbPersonalInfoPageModel().stateOptApply);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().stateOptApply);
//            log.info("After entering state drop downn ");
//        }
//
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().zip, index),
//                person.getZip());
//        log.info("After entering Zipcode");
//
//        log.info("entering mobile phone no");
//        WebElement mobPhone = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().mobilePhone, index);
//        wait(mobPhone);
//        browserActions.scrollToWebElement(getSeleniumdriver(),mobPhone);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().mobilePhone, index),
//                person.getPhoneNumber());
//
//        log.info("entering email");
//        WebElement email = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index);
//        wait(email);
//        browserActions.scrollToWebElement(getSeleniumdriver(),email);
//        wait(email);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().email, index),
//                person.getEmail());
//        WebElement ssn = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(),ssn);
//        wait(ssn);
//
//        log.info("entering SSN");
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().ssn, index),
//                person.getSsn());
//
//        WebElement idType = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idType, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(),idType);
//        wait(idType);
//        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idType, index));
//        log.info("selecting preferred id method {}", person.getPrefferedId());
//
//        if (person.getPrefferedId().equalsIgnoreCase("military")) {
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    getSmbPersonalInfoPageModel().idTypeMilitaryApply);
//        } else if (person.getPrefferedId().equalsIgnoreCase("Resident Alien")) {
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    getSmbPersonalInfoPageModel().idTypeResidentAlienApply);
//        } else if (person.getPrefferedId().equalsIgnoreCase("driverLicence")) {
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    getSmbPersonalInfoPageModel().idTypeDriverLicenceApply);
//            getSeleniumdriver().getWebDriver().manage().timeouts().implicitlyWait(11, TimeUnit.SECONDS);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().stateApply);
//        } else if (person.getPrefferedId().equalsIgnoreCase("stateId")) {
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    getSmbPersonalInfoPageModel().idTypeStateIdApply);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().stateIssued, index));
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().stateApply);
//        } else if (person.getPrefferedId().equalsIgnoreCase("Passport")) {
//            waitWithSpinner(getSmbPersonalInfoPageModel().idTypePassportApply);
//
//            log.info("Into the passport section");
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    getSmbPersonalInfoPageModel().idTypePassportApply);
//            WebElement countryIssued = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().countryIssued, index);
//            browserActions.scrollToWebElement(getSeleniumdriver(),countryIssued);
//            wait(countryIssued);
//
//            log.info("issueing country");
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().countryIssued, index));
//            wait(getSmbPersonalInfoPageModel().citizenshipCountryApply);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(), getSmbPersonalInfoPageModel().citizenshipCountryApply);
//            log.info("Citizen id country applied");
//        }
//        WebElement idNumber = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(),idNumber);
//        wait(idNumber);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().idNumber, index),
//                person.getIdentificationNumber());
//        browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().issueDate, index),
//                person.getIssueDate());
//        browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().expiryDate, index),
//                person.getExpiryDate());
//        log.info("issue and expiry date added");
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

            //	if ((validation == null) || validation != null && !validation.isSkipEmploymentStatusDropdown()) {
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().employment, index));
//            log.info("selecting employment method {}", person.getEmploymentStatus());
//            //if (person.getEmploymentStatus().equalsIgnoreCase("Employed")){
//            WebElement EmployedText = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().addressText, person.getEmploymentStatus());
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    EmployedText);
//            assertTrue(true);
//            // }
//            Thread.sleep(1000);
//            if (getSeleniumdriver().getWebDriver().getPageSource().contains("Current/Previous Occupation")) {
//                WebElement occupation = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().occupation, index);
//                occupation.click();
//                log.info("Eneterd occupation");
//
//                browserActions.enterTextKeyEntry(getSeleniumdriver(),
//                        occupation, person.getOccupation());
//            }
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().PrefferedId, index));


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

//            if (index == 0) {
//                log.info("Accepting Disclosure");
//                WebElement disclosure = applicantUtil.getWebElement(getSeleniumdriver(), getSmbPersonalInfoPageModel().IamNotSubjectTo, index);
//                Thread.sleep(500);
//                browserActions.scrollToWebElement(getSeleniumdriver(), disclosure);
//                Thread.sleep(500);
//                browserActions.clickButton(getSeleniumdriver(), disclosure);
//                log.info("Disclosure Accepted");
//            }

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

