package com.cztffa.page.businessinfo;

import static org.junit.Assert.assertTrue;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import com.cztffa.page.product.SmbProductSelectorPage;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import com.cztffa.objects.Business;
import com.cztffa.objects.Validation;
import com.cztffa.util.ApplicantUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BusinessInfoPage extends SmbProductSelectorPage {

    //addBusinessDetailForSmb
	public void addBusinessDetailForSmb(Business business, int index) throws InterruptedException {

		Thread.sleep(1000);
		waitForSpinnerToDisappear();
		waitForSpinnerToDisappear();
		ApplicantUtil applicantUtil = new ApplicantUtil();
		Validation validation = business.getValidation();

        WebElement dropdownOption = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().businessType, index);
        wait(dropdownOption);
        browserActions.scrollToWebElement(getSeleniumdriver(),dropdownOption);

        log.info("selecting the business type dropdown");
        browserActions.clickButton(getSeleniumdriver(),


        applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().businessType, index));
        if (business.getBusinessType().equalsIgnoreCase("Sole Proprietorship")) {
            log.info("selecting BusinessType");
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    getBusinessInfoPageModel().businessTypeSelectSole);
            assertTrue(true);
            log.info("business type selected");
        }
        else if (business.getBusinessType().equalsIgnoreCase("Limited Liability Company")) {
            log.info("selecting BusinessType");
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    getBusinessInfoPageModel().businessTypeSelectLlc);
            assertTrue(true);
            log.info("business type selected");
        }
        else if (business.getBusinessType().equalsIgnoreCase("Corporation")) {
            log.info("selecting BusinessType");
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    getBusinessInfoPageModel().businessTypeSelectCorporation);
            assertTrue(true);
            log.info("business type selected");
        }
        else if (business.getBusinessType().equalsIgnoreCase("General Partnership")) {
            log.info("selecting BusinessType");
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    getBusinessInfoPageModel().businessTypeSelectGenralPartnership);
            assertTrue(true);
            log.info("business type selected");
        }

		log.info("Entering business name");
		browserActions.enterText(getSeleniumdriver(),
				applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().businessName, index),
				business.getBusinessName());
		assertTrue(true);
        Thread.sleep(1000);

        log.info("Entering DBA name");
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().dbaName, index),
                business.getDbaName());
        assertTrue(true);
        Thread.sleep(1000);

        log.info("Entering date of establishment");
        WebElement dateOfEst = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().dateOfEstablishment, index);
        browserActions.scrollToWebElement(getSeleniumdriver(),dateOfEst);
        wait(dateOfEst);
        Thread.sleep(500);
        browserActions.clickApply(getSeleniumdriver().getWebDriver(),applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().dateOfEstablishment,index));
        Thread.sleep(500);
        WebElement doeElement = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().dateOfEstablishment,
                index);
        assertTrue(true);
        browserActions.enterTextKeyEntry(getSeleniumdriver(), doeElement, business.getDoe());
        log.info("date of establishment entered");


        log.info("i am at the select address place");
        log.info("selected street address dropdown ::"+business.getStreetAddress1());
        WebElement address = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().streetAddress1, index);
        browserActions.scrollToWebElement(getSeleniumdriver(), address);
        Thread.sleep(500);
        selectElement(getSeleniumdriver().getWebDriver(),address);
        Thread.sleep(500);
        browserActions.clickApply(getSeleniumdriver().getWebDriver(),address);
        Thread.sleep(500);
        browserActions.enterText(getSeleniumdriver(),
                address,
                business.getStreetAddress1());
        selectBusinessAddress(getSeleniumdriver().getWebDriver(),address);
        waitWithShortTime(getSeleniumdriver());
        log.info("before addresstext");
        Thread.sleep(500);
        WebElement addressOfElement = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().addressText, business.getStreetAddress1());
        selectElement(getSeleniumdriver().getWebDriver(),addressOfElement);
        Thread.sleep(500);
        browserActions.scrollToWebElement(getSeleniumdriver(), addressOfElement);
        Thread.sleep(500);
        waitWithSpinner(addressOfElement);
        browserActions.clickApply(getSeleniumdriver().getWebDriver(),addressOfElement);
        log.info("after addresstext");
        Thread.sleep(500);

//        WebElement city = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().city, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(),city);
//        Thread.sleep(500);
//        wait(getSeleniumdriver().getWebDriver(),city);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().city, index),
//                business.getCity());
//        Thread.sleep(500);
//        if ((validation == null) || validation != null && !validation.isSkipStateDropdown()) {
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//                    applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().state, index));
//            wait(getBusinessInfoPageModel().stateOptApply);
//            browserActions.clickApply(getSeleniumdriver().getWebDriver(), getBusinessInfoPageModel().stateOptApply);
//            log.info("After entering state drop downn ");
//        }
//        Thread.sleep(500);
//        WebElement zip = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().zip, index);
//        browserActions.scrollToWebElement(getSeleniumdriver(),zip);
//        Thread.sleep(500);
//        wait(zip);
//        browserActions.enterText(getSeleniumdriver(),
//                applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().zip, index),
//                business.getZip());
//        waitForSpinnerToDisappear();
//        log.info("After entering Zipcode");
        Thread.sleep(500);


        log.info("Entering year");
        WebElement year = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().year, index);
        browserActions.scrollToWebElement(getSeleniumdriver(),year);
        Thread.sleep(500);
        browserActions.scrollToWebElement(getSeleniumdriver(),year);
        Thread.sleep(500);
        browserActions.enterText(getSeleniumdriver(), applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().year, index),
                business.getYear());
        assertTrue(true);
        Thread.sleep(500);

        log.info("entering mobile phone no");
        WebElement mobPhone = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().mobilePhone, index);
        browserActions.scrollToWebElement(getSeleniumdriver(),mobPhone);
        Thread.sleep(500);
        wait(mobPhone);
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().mobilePhone, index),
                business.getPhoneNumber());
        Thread.sleep(500);
        log.info("entering email");
        browserActions.enterText(getSeleniumdriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().email, index),
                business.getEmail());
        Thread.sleep(500);
        waitForSpinnerToDisappear();

        if (business.getBusinessType().equalsIgnoreCase("Sole Proprietorship")) {
            log.info("entering SSN");
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().idType, index));
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    getBusinessInfoPageModel().idTypeSSNApply);
            Thread.sleep(500);
            waitForSpinnerToDisappear();
            waitForInnerSpinnersToDisappear(getSeleniumdriver().getWebDriver());
            browserActions.scrollToWebElement(getSeleniumdriver(), getBusinessInfoPageModel().ssn);
            Thread.sleep(500);
            browserActions.enterText(getSeleniumdriver(),
                    getBusinessInfoPageModel().ssn,
                    business.getSsn());
            log.info("entered ssn");
        } else if (business.getBusinessType().equalsIgnoreCase("Limited Liability Company") ||
                business.getBusinessType().equalsIgnoreCase("Corporation")||business.getBusinessType().equalsIgnoreCase("General Partnership")) {

            log.info("entering TIN");
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().idType, index));
            browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                    getBusinessInfoPageModel().idTypeTINApply);
            Thread.sleep(500);
            waitForSpinnerToDisappear();
            waitForInnerSpinnersToDisappear(getSeleniumdriver().getWebDriver());
            browserActions.scrollToWebElement(getSeleniumdriver(), getBusinessInfoPageModel().tin);
            Thread.sleep(500);
            browserActions.enterText(getSeleniumdriver(),
                    getBusinessInfoPageModel().tin,
                    business.getTinNumber());
            log.info("entered TIN");
        }

        if(index == 0){
            log.info("Accepting Disclosure");
            WebElement disclosure = applicantUtil.getWebElement(getSeleniumdriver(),getBusinessInfoPageModel().IamNotSubjectTo, index);
            Thread.sleep(500);
            browserActions.scrollToWebElement(getSeleniumdriver(), disclosure);
            Thread.sleep(500);
            browserActions.clickButton(getSeleniumdriver(), disclosure);
            log.info("Disclosure Accepted");
        }

        WebElement naics = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().naicsCode, index);
        browserActions.scrollToWebElement(getSeleniumdriver(),  applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().naicsCode, index));
        wait(naics);
        browserActions.clickApply(getSeleniumdriver().getWebDriver(),
                applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().naicsCode, index));
        Thread.sleep(500);
        waitForSpinnerToDisappear();
        Thread.sleep(500);
        log.info("selecting preferred id method {}", business.getNaicsCode());
        if (business.getNaicsCode().equalsIgnoreCase("soybean farming")) {
            browserActions.clickButton(getSeleniumdriver(),
                    getBusinessInfoPageModel().soybeanFarmingSelected);
        }
        log.info("Soyabean selected");
        Thread.sleep(500);




//		WebElement dropdownOption = applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().businessType, index);
//		wait(dropdownOption);
//		browserActions.scrollToWebElement(getSeleniumdriver(),dropdownOption);

//		log.info("selecting the business type dropdown");
//		browserActions.clickButton(getSeleniumdriver(),
//				applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().businessType, index));
//		if (business.getBusinessType().equalsIgnoreCase("Sole Proprietorship")) {
//			log.info("selecting citizenship");
//			browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//					getBusinessInfoPageModel().businessTypeSelectSole);
//			assertTrue(true);
//			log.info("business type selected");
//		}
//		else if (business.getBusinessType().equalsIgnoreCase("Limited Liability Company")) {
//			log.info("selecting citizenship");
//			browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//					getBusinessInfoPageModel().businessTypeSelectLlc);
//			assertTrue(true);
//			log.info("business type selected");
//		}
//		else if (business.getBusinessType().equalsIgnoreCase("Corporation")) {
//			log.info("selecting citizenship");
//			browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//					getBusinessInfoPageModel().businessTypeSelectCorporation);
//			assertTrue(true);
//			log.info("business type selected");
//		}
//		else if (business.getBusinessType().equalsIgnoreCase("General Partnership")) {
//			log.info("selecting citizenship");
//			browserActions.clickApply(getSeleniumdriver().getWebDriver(),
//					getBusinessInfoPageModel().businessTypeSelectGenralPartnership);
//			assertTrue(true);
//			log.info("business type selected");
//		}









//		if(index!=0) {
//			WebElement relationCode=applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().relationCode, index);
//			browserActions.scrollToWebElement(getSeleniumdriver(),applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().relationCode, index));
//
//			wait(relationCode);
//			browserActions.enterText(getSeleniumdriver(),
//					applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().relationCode, index),
//					business.getRelationship());
//
//			browserActions.clickApply(getSeleniumdriver().getWebDriver(),applicantUtil.getWebElement(getSeleniumdriver(), getBusinessInfoPageModel().relation, business.getRelationship()));
//			log.info("After entering Relationcode"+business.getRelationship());
//		}
	}
}