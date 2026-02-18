package com.cztffa.page.business;
import com.cztffa.xpath.business.SmbFundingPageXpath;
import com.cztffa.xpath.consumer.FundingPageXpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class SmbFundingPageModel {
    private WebDriver driver;

    public SmbFundingPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String plaidInstutionName ="//button[@aria-label='%s']";

    public String fundingAmount = "//tf-money[@t-model='Submission__c.Applications__r.%s.Amount__c']";

//    @FindBy(xpath = "//tf-money//input")
//    public WebElement fundingAmount;

    @FindBy(xpath = "//iframe[@id='plaid-link-iframe-1']")
    public WebElement framePlaid;

    @FindBy(xpath = "//button[normalize-space()='Continue without phone number']")
    public WebElement continueAsGuest;

    @FindBy(xpath = SmbFundingPageXpath.TERMVALUE)
    public WebElement termValue;

    @FindBy(xpath = SmbFundingPageXpath.FUNDINGTYPE)
    public WebElement fundingType;
    public String fundingText = "//div[contains(text(),'%s')]";
//    @FindBy(xpath = "//tf-money[@t-model='Submission__c.Applications__r.0.Amount__c']")
//    public WebElement fundingAmount;

    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'From a non')]")
    public WebElement FromNonWSFS;

    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'Paypal')]")
    public WebElement FromPaypal;

    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'PLAID')]")
    public WebElement btnPlaid;

    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'CITI BANK')]")
    public WebElement CitiBank;

    @FindBy(xpath = "//label[contains(text(),'Email or mobile number')]")
    public WebElement emailLabel;

    @FindBy(xpath = SmbFundingPageXpath.BTNLOGIN)
    public WebElement btnLogin;

    @FindBy(xpath = SmbFundingPageXpath.TXTUSERNAME)
    public WebElement txtUsername;

    @FindBy(xpath = SmbFundingPageXpath.TXTPASSWORD)
    public WebElement txtPassword;

    @FindBy(xpath = SmbFundingPageXpath.BTNAUTHSUBMIT)
    public WebElement btnAuthSubmit;

    @FindBy(xpath = SmbFundingPageXpath.BTNAUTHCONTINUEAFTER)
    public WebElement btnAuthContinueAfter;

    @FindBy(xpath = SmbFundingPageXpath.BTNAUTHCONTINUEAFTERSUCCESS)
    public WebElement btnAuthContinueAfterSuccess;

    @FindBy(xpath = SmbFundingPageXpath.PLAIDCHECKINGCHECKBOX)
    public WebElement plaidCheckingCheckbox;

    @FindBy(xpath = SmbFundingPageXpath.BTNCONTINUE)
    public WebElement btnContinue;

    @FindBy(xpath = SmbFundingPageXpath.CHECKBOXTERMS)
    public WebElement checkboxTerms;

    @FindBy(xpath = SmbFundingPageXpath.CHECKBOXTERMS_1)
    public WebElement checkboxTerms_1;

    @FindBy(xpath = SmbFundingPageXpath.BTNSUBMITCONFIRM)
    public WebElement btnSubmitConfirm;

    @FindBy(xpath = SmbFundingPageXpath.BTNCONTINUE_1)
    public WebElement btnFinishWsaving;

    @FindBy(xpath = SmbFundingPageXpath.BTNPAYPAL)
    public WebElement btnPaypal;

    @FindBy(xpath = SmbFundingPageXpath.PAYPALID)
    public WebElement paypalID;

    @FindBy(xpath = SmbFundingPageXpath.PAYPALPWD)
    public WebElement paypalPwd;
    @FindBy(xpath = SmbFundingPageXpath.PAYPALIDNXT)
    public WebElement paypalIdNxt;
    @FindBy(xpath = SmbFundingPageXpath.PAYPALGN)
    public WebElement paypalgn;
    @FindBy(xpath = SmbFundingPageXpath.CMPURCH)
    public WebElement cmpurch;

    @FindBy(xpath = SmbFundingPageXpath.BTNCONTINUE_3)
    public WebElement btnSubmit;

    @FindBy(xpath = "//div//tf-dropdown")
    public WebElement drpAcNum;

    @FindBy(xpath = "//div[@class='dropdown-item']")
    public WebElement optAcNum;

    @FindBy(xpath = SmbFundingPageXpath.CHECKBOXTERMS)
    public WebElement fundingDisclosure;

    //@FindBy(xpath = FundingPageXpath.BTNCONTINUE)
    //public WebElement btnContinue;



    @FindBy(xpath = SmbFundingPageXpath.FUNDDISC)
    public WebElement FundDisc;

    @FindBy(xpath = SmbFundingPageXpath.FUNDINGNEXTBUTTON)
    public WebElement fundingNextButton;

    @FindBy(xpath = SmbFundingPageXpath.FUNDINGSAVEMYPROGRESS)
    public WebElement fundingsaveMyProgress;

    public String termText = "//div[contains(text(),'%s')]";

}




//    public String plaidInstutionName ="//button[@aria-label='%s']";
//
//    public String fundingAmount = "//tf-money[@t-model='Submission__c.Applications__r.%s.Amount__c']";
//
////    @FindBy(xpath = "//tf-money//input")
////    public WebElement fundingAmount;
//
//    @FindBy(xpath = "//iframe[@id='plaid-link-iframe-1']")
//    public WebElement framePlaid;
//
//    @FindBy(xpath = "//button[normalize-space()='Continue as guest']")
//    public WebElement continueAsGuest;
//
//    @FindBy(xpath = FundingPageXpath.TERMVALUE)
//    public WebElement termValue;
//
//    @FindBy(xpath = FundingPageXpath.FUNDINGTYPE)
//    public WebElement fundingType;
//    public String fundingText = "//div[contains(text(),'%s')]";
////    @FindBy(xpath = "//tf-money[@t-model='Submission__c.Applications__r.0.Amount__c']")
////    public WebElement fundingAmount;
//
//    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'From a non')]")
//    public WebElement FromNonWSFS;
//
//    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'Paypal')]")
//    public WebElement FromPaypal;
//
//    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'PLAID')]")
//    public WebElement btnPlaid;
//
//    @FindBy(xpath = "//div[@class='dropdown-item'][contains(text(),'CITI BANK')]")
//    public WebElement CitiBank;
//
//    @FindBy(xpath = "//label[contains(text(),'Email or mobile number')]")
//    public WebElement emailLabel;
//
//    @FindBy(xpath = FundingPageXpath.BTNLOGIN)
//    public WebElement btnLogin;
//
//    @FindBy(xpath = FundingPageXpath.TXTUSERNAME)
//    public WebElement txtUsername;
//
//    @FindBy(xpath = FundingPageXpath.TXTPASSWORD)
//    public WebElement txtPassword;
//
//    @FindBy(xpath = FundingPageXpath.BTNAUTHSUBMIT)
//    public WebElement btnAuthSubmit;
//
//    @FindBy(xpath = FundingPageXpath.BTNAUTHCONTINUEAFTER)
//    public WebElement btnAuthContinueAfter;
//
//    @FindBy(xpath = FundingPageXpath.BTNAUTHCONTINUEAFTERSUCCESS)
//    public WebElement btnAuthContinueAfterSuccess;
//
//    @FindBy(xpath = FundingPageXpath.PLAIDCHECKINGCHECKBOX)
//    public WebElement plaidCheckingCheckbox;
//
//    @FindBy(xpath = FundingPageXpath.BTNCONTINUE)
//    public WebElement btnContinue;
//
//    @FindBy(xpath = FundingPageXpath.CHECKBOXTERMS)
//    public WebElement checkboxTerms;
//
//    @FindBy(xpath = FundingPageXpath.CHECKBOXTERMS_1)
//    public WebElement checkboxTerms_1;
//
//    @FindBy(xpath = FundingPageXpath.BTNSUBMITCONFIRM)
//    public WebElement btnSubmitConfirm;
//
//    @FindBy(xpath = FundingPageXpath.BTNCONTINUE_1)
//    public WebElement btnFinishWsaving;
//
//    @FindBy(xpath = FundingPageXpath.BTNPAYPAL)
//    public WebElement btnPaypal;
//
//    @FindBy(xpath = FundingPageXpath.PAYPALID)
//    public WebElement paypalID;
//
//    @FindBy(xpath = FundingPageXpath.PAYPALPWD)
//    public WebElement paypalPwd;
//    @FindBy(xpath = FundingPageXpath.PAYPALIDNXT)
//    public WebElement paypalIdNxt;
//    @FindBy(xpath = FundingPageXpath.PAYPALGN)
//    public WebElement paypalgn;
//    @FindBy(xpath = FundingPageXpath.CMPURCH)
//    public WebElement cmpurch;
//
//    @FindBy(xpath = FundingPageXpath.BTNCONTINUE_3)
//    public WebElement btnSubmit;
//
//    @FindBy(xpath = "//div//tf-dropdown")
//    public WebElement drpAcNum;
//
//    @FindBy(xpath = "//div[@class='dropdown-item']")
//    public WebElement optAcNum;
//
//    @FindBy(xpath = FundingPageXpath.CHECKBOXTERMS)
//    public WebElement fundingDisclosure;
//
//    //@FindBy(xpath = FundingPageXpath.BTNCONTINUE)
//    //public WebElement btnContinue;
//
//
//
//    @FindBy(xpath = FundingPageXpath.FUNDDISC)
//    public WebElement FundDisc;
//
//    @FindBy(xpath = FundingPageXpath.FUNDINGNEXTBUTTON)
//    public WebElement fundingNextButton;
//
//    @FindBy(xpath = FundingPageXpath.FUNDINGSAVEMYPROGRESS)
//    public WebElement fundingsaveMyProgress;
//
//    public String termText = "//div[contains(text(),'%s')]";
//
//}
