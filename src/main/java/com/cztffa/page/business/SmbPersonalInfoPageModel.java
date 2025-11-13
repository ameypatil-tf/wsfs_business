package com.cztffa.page.business;
import com.cztffa.xpath.business.SmbPersonalInfoPageXpath;
import com.cztffa.xpath.consumer.PersonalInfoPageXpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class SmbPersonalInfoPageModel {
    private WebDriver driver;

    public SmbPersonalInfoPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String firstName = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.FirstName__c']/descendant::input";

    public String middleName = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.MiddleName__c']/descendant::input";

    public String lastName = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.LastName__c']/descendant::input";

    public String streetAddress1 = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tfcz-address[@t-model='Party__r.AddressXrefs__r.0.Address__r']//tf-input[@t-model='Line1__c']/descendant::input";

    public String city = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='City__c']//input";

    public String state = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='State__c']/descendant::input";

    public String zip = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='ZipCode__c']//input";
    public String year = "//tf-number[@t-model='Party__r.AddressXrefs__r.0.PeriodInYears__c']/descendant::input";
    public String phoneNumber = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-phone[@t-model='Party__r.PrimaryPhone__c']";

    public String workPhone = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-phone[@t-model='Party__r.SecondaryPhone__c']/descendant::input";

    public String email = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-email[@t-model='Party__r.PrimaryEmail__c']/descendant::input";

    public String employment = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Party__r.Incomes__r.0.Employment__r.Type__c']";

    public String occupation = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.Incomes__r.0.Employment__r.Occupation__c']";

    public String PrefferedId = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Identifications__r.0.Type__c']/descendant::input";

    public String idNumber = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Identifications__r.0.IdentificationNumber__c']//input";

    public String stateIssued = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Identifications__r.0.IssuingState__c']/descendant::input";

    public String issueDate = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='Identifications__r.0.IssueDate__c']//input";

    public String expiryDate = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='Identifications__r.0.ExpirationDate__c']//input";

    public String dateOfBirth = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='BirthDate__c']//input";

    public String ssn = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-ssn[@t-model='NationalIdentifierValue__c']//input";

    public String IamNotSubjectTo = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-checkbox[@t-model='Accepted__c']";

    public String IsPEPPresent = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-radio-group[@t-model='Is_PEP_Present']";

    public String PEPMemberType = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='PEP_Member_Type']";

//    public String APlastname = "//tf-input[@t-model=/'LastName__c/']";
//    public String APssn = "//tf-input[@t-model=/'Last4NationalIdentifierValue__c/']";
//    public String APemail = "//tf-input[@t-model='PrimaryEmail__c']";


//    @FindBy(xpath = PersonalInfoPageXpath.APLASTNAME)
//    public WebElement APlastname;
//
//    @FindBy(xpath = PersonalInfoPageXpath.APSSN)
//    public WebElement APssn;
//
//    @FindBy(xpath = PersonalInfoPageXpath.APEMAIL)
//    public WebElement APemail;

    @FindBy(xpath = PersonalInfoPageXpath.ADDADDITIONALAPPLICANTBUTTON)
    public WebElement addAdditionalApplicantButton;

//    @FindBy(xpath = PersonalInfoPageXpath.IamNotSubjectTo)
//    public WebElement IamNotSubjectTo;

    //    @FindBy(xpath = PersonalInfoPageXpath.IsPEPPresent)
//    public WebElement IsPEPPresent;
    @FindBy(xpath = PersonalInfoPageXpath.PERSONALINFONEXTBUTON)
    public WebElement personalInfoNextButon;

    @FindBy(xpath = PersonalInfoPageXpath.APLOGIN)
    public WebElement apLogin;

    @FindBy(xpath = PersonalInfoPageXpath.SAVE)
    public WebElement save;

    @FindBy(xpath = PersonalInfoPageXpath.SAVEMYPROGRESS)
    public WebElement saveMyProgress;

    @FindBy(xpath = PersonalInfoPageXpath.SAVEMODALCONTINUEBUTTON)
    public WebElement saveModalContinueButton;

    @FindBy(xpath = PersonalInfoPageXpath.CANCELAPPLICATION)
    public WebElement cancelApplication;

    @FindBy(xpath = PersonalInfoPageXpath.CANCELMODALBUTTON)
    public WebElement cancelModalButton;

    @FindBy(xpath = PersonalInfoPageXpath.CONTINUEBTN1)
    public WebElement continueBtn1;

    public String addressText = "//div[contains(text(),'%s')]";
    public String stateText = "//div[contains(text(),'%s')]";
    public String MemberText = "//div[contains(text(),'%s')]";
    public String idText = "//div[contains(text(),'%s')]";



//    public String prefix = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Party__r.Prefix__c']/descendant::input";
//
//    public String middleName = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.MiddleName__c']/descendant::input";
//
//    public String suffix = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Party__r.Suffix__c']/descendant::input";
//
//    public String streetAddress1 = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Line1__c']/descendant::input";
//
//    public String city = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='City__c']/descendant::input";
//
//    public String state = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='State__c']/descendant::input";
//
//    public String zip = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='ZipCode__c']/descendant::input";
//
//    public String years = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-number[@t-model='Party__r.AddressXrefs__r.0.PeriodInYears__c']/descendant::input";
//
//    public String idType = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Identifications__r.0.Type__c']/descendant::input";
//
//    public String idNumber = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Identifications__r.0.IdentificationNumber__c']/descendant::input";
//
//    public String stateIssued = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Identifications__r.0.IssuingState__c']/descendant::input";
//
//    public String issueDate = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='Identifications__r.0.IssueDate__c']/descendant::input";
//
//    public String ssn = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-ssn[@t-model='NationalIdentifierValue__c']/descendant::input";
//
//    public String expiryDate = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='Identifications__r.0.ExpirationDate__c']/descendant::input";
//
//    public String dateOfBirth = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='BirthDate__c']/descendant::input";
//
//    @FindBy(xpath = SmbPersonalInfoPageXpath.ISPEPPRESENT)
//    public WebElement IsPEPPresent;
//
//    public String PEPMemberType = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='PEP_Member_Type']/descendant::input";
//
//    @FindBy(xpath = SmbPersonalInfoPageXpath.ADDADDITIONALAPPLICANTBUTTON)
//    public WebElement addAdditionalApplicantButton;
//
//    public String IsApplicantPresent = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-checkbox[@t-model='IsPresent__c']/descendant::input";
//
//    @FindBy(xpath = SmbPersonalInfoPageXpath.REMOVEPERSON)
//    public WebElement removePerson;
//
//    @FindBy(xpath = SmbPersonalInfoPageXpath.REMOVEBUTTON)
//    public WebElement removeButton;
//
//    @FindBy(xpath = SmbPersonalInfoPageXpath.PERSONALINFONEXTBUTON)
//    public WebElement personalInfoNextButon;
//
//    @FindBy(xpath = SmbPersonalInfoPageXpath.CONTINUEBTN1)
//    public WebElement continueBtn1;
    
}
