package com.cztffa.page.consumer;
import com.cztffa.xpath.consumer.PersonalInfoPageXpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class PersonalInfoPageModel {
    private WebDriver driver;

    public PersonalInfoPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String firstName = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.FirstName__c']/descendant::input";
    
    public String middleName = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.MiddleName__c']/descendant::input";
    
    public String lastName = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.LastName__c']/descendant::input";
    
    public String dateOfBirth = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='Party__r.BirthDate__c']//input";
    
    public String citizenship = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Party__r.Citizenship__c']/descendant::input";
    
    public String streetAddress1 = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-address[@t-model='Party__r.AddressXrefs__r.0.Address__r']//tf-input[@t-model='Line1__c']/descendant::input";
    
    public String city = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='City__c']//input";
    
    public String state = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='State__c']/descendant::input";
    
    public String zip = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='ZipCode__c']//input";
    
    public String prefferedContact = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Party__r.PreferredContactMethod__c']/descendant::input";
    
    public String mobilePhone = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-phone[@t-model='Party__r.PrimaryPhone__c']//input";
    
    public String employment = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-ssn[@t-model='Party__r.NationalIdentifierValue__c']//input";
    
    public String email = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-email[@t-model='Party__r.PrimaryEmail__c']//input";
    
    public String employer = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.Employments__r.0.EmployerName__c']//input";
    
    public String occupation = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.Employments__r.0.Occupation__c']//input";
    
    public String ssn = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-ssn[@t-model='Party__r.NationalIdentifierValue__c']//input";
    
    public String idType = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Type__c']/descendant::input";
    
    public String idNumber = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='IdentificationNumber__c']//input";
    
    public String securityWord = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-input[@t-model='Party__r.CZSecurityWord__c']//input";
    
    public String issueDate = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='IssueDate__c']//input";
    
    public String expiryDate = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-date[@t-model='ExpirationDate__c']//input";
    
    public String citizenshipCountry = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Party__r.CountryOfCitizenship__c']//input";
    
    public String willingForeign = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='Party__r.CZAffiliatedWithForeignGoverment__c']//input";
    
    public String stateIssued = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='IssuingState__c']//input";
    
    public String countryIssued = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='IssuingCountry__c']//input";
    
    public String relationCode = "//tf-expansion-panel[@t-model='Submission__c.PartyXrefs__r.%s']//tf-dropdown[@t-model='RelationCode__c']//input";
    
    public String relation = "//div[@class='dropdown-item ng-star-inserted'][contains(text(),'%s')]";
    
    public String addressText = "//div[contains(text(),'%s')]";
    
    @FindBy(xpath = PersonalInfoPageXpath.CITIZENSHIPALIENAPPLY)
    public WebElement citizenshipAlienApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.CITIZENSHIPCITIZENOPTAPPLY)
    public WebElement citizenshipCitizenOptApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.STATEOPTAPPLY)
    public WebElement stateOptApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.PREFERREDCONTACTMOBILEAPPLY)
    public WebElement preferredContactMobileApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.EMPLOYMENTEMPLOYEDAPPLY)
    public WebElement employmentEmployedApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.IDTYPEMILITARYAPPLY)
    public WebElement idTypeMilitaryApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.IDTYPEDRIVERLICENCEAPPLY)
    public WebElement idTypeDriverLicenceApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.IDTYPESTATEIDAPPLY)
    public WebElement idTypeStateIdApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.IDTYPEPASSPORTAPPLY)
    public WebElement idTypePassportApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.IDTYPERESIDENTALIENAPPLY)
    public WebElement idTypeResidentAlienApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.PERSONALINFONEXTBUTTON)
    public WebElement personalInfoNextButton;

    @FindBy(xpath = PersonalInfoPageXpath.PERSONALINFOCANCELBUTTON)
    public WebElement personalInfoCancelButton;

    @FindBy(xpath = PersonalInfoPageXpath.CANCELBUTTON)
    public WebElement CancelButton;
    
    @FindBy(xpath = PersonalInfoPageXpath.ADDADDITIONALAPPLICANTBUTTON)
    public WebElement addAdditionalApplicantButton;
    
    @FindBy(xpath = PersonalInfoPageXpath.PROCEEDWITHOUTPREFILLBTN)
    public WebElement proceedWithoutPrefillBtn;
    
    @FindBy(xpath = PersonalInfoPageXpath.CITIZENSHIPCOUNTRYAPPLY)
    public WebElement citizenshipCountryApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.WILLINGFREIGNAPPLY)
    public WebElement willingFreignApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.STATEAPPLY)
    public WebElement stateApply;
    
    @FindBy(xpath = PersonalInfoPageXpath.CHECKBOX)
    public WebElement checkbox;
    
}
