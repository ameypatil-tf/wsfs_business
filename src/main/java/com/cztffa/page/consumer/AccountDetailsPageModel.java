package com.cztffa.page.consumer;
import com.cztffa.xpath.consumer.AccountDetailsPageXpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class AccountDetailsPageModel {
    private WebDriver driver;

    public AccountDetailsPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = AccountDetailsPageXpath.ORANGEVISADEBITCARD)
    public WebElement orangeVisaDebitCard;
    
    @FindBy(xpath = AccountDetailsPageXpath.LINKEDOVERDRAFTTOGGLEBUTTON)
    public WebElement linkedOverdraftToggleButton;
    
    @FindBy(xpath = AccountDetailsPageXpath.ADDLINKEDOVERDRAFTPROTECTION)
    public WebElement addLinkedOverDraftProtection;
    
    @FindBy(xpath = AccountDetailsPageXpath.OVERDRAFTCOVERAGENOCHECKBOX)
    public WebElement OverDraftCoverageNoCheckBox;
    
    @FindBy(xpath = AccountDetailsPageXpath.ACCEPTCHECKBOX)
    public WebElement acceptCheckBox;
    
    @FindBy(xpath = AccountDetailsPageXpath.ACCOUNTDETAILSNEXTBUTTON)
    public WebElement accountDetailsNextButton;
    
    @FindBy(xpath = AccountDetailsPageXpath.CHECKINGSECTION)
    public WebElement checkingSection;
    
    @FindBy(xpath = AccountDetailsPageXpath.BASICSAVINGSSECTION)
    public WebElement basicSavingsSection;
    
    @FindBy(xpath = AccountDetailsPageXpath.CERTIFICATESECTION)
    public WebElement certificateSection;
    
    @FindBy(xpath = AccountDetailsPageXpath.CERTIFICATETERMDRP)
    public WebElement certificateTermDrp;
    
    @FindBy(xpath = AccountDetailsPageXpath.CERTIFICATETERMVALUE)
    public WebElement certificateTermValue;
    
    @FindBy(xpath = AccountDetailsPageXpath.CERTIFICATEAMOUNT)
    public WebElement certificateAmount;
    
    @FindBy(xpath = AccountDetailsPageXpath.CLOSEBUTTON)
    public WebElement closeButton;
    
    @FindBy(xpath = AccountDetailsPageXpath.ADDDEBITCARDBUTTON)
    public WebElement addDebitCardButton;
    
    @FindBy(xpath = AccountDetailsPageXpath.BENEFICIARYRELASHIONSHIPAPPLY)
    public WebElement beneficiaryRelashionshipApply;
    
    @FindBy(xpath = AccountDetailsPageXpath.CANCELBUTTON)
    public WebElement cancelButton;
    
    @FindBy(xpath = AccountDetailsPageXpath.SAVEBUTTON)
    public WebElement saveButton;
    
}
