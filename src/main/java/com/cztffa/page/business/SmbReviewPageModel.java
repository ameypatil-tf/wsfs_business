package com.cztffa.page.business;
import com.cztffa.xpath.business.SmbReviewPageXpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class SmbReviewPageModel {
    private WebDriver driver;

    public SmbReviewPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = SmbReviewPageXpath.DISCLOSURECHECKBOX)
    public WebElement disclosureCheckbox;



    @FindBy(xpath = SmbReviewPageXpath.MODALCHECKBOX)
    public WebElement modalCheckbox;

    @FindBy(xpath = SmbReviewPageXpath.MODALCNT)
    public WebElement modalCnt;

    @FindBy(xpath = "//div[contains(@class,'tf-modal-iframe')]//iframe")
    public WebElement framePlaid;

    @FindBy(xpath = "//button[normalize-space()='Accept']")
    public WebElement framePlaidTwo;
    
    @FindBy(xpath = SmbReviewPageXpath.BRACCEPT)
    public WebElement brAccept;
    
    @FindBy(xpath = SmbReviewPageXpath.SUBMITBUTTON)
    public WebElement submitButton;
    
}
