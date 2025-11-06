package com.cztffa.page.consumer;
import com.cztffa.xpath.consumer.ProductSelectorPageXpath;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.WebDriver;

public class ProductSelectorPageModel {
    private WebDriver driver;

    public ProductSelectorPageModel(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = ProductSelectorPageXpath.CLICKCONSUMERTAB)
    public WebElement clickConsumerTab;
    
    @FindBy(xpath = ProductSelectorPageXpath.CHECKOUTBTN)
    public WebElement checkOutBtn;
    
    @FindBy(xpath = ProductSelectorPageXpath.PROCEEDBTN)
    public WebElement proceedBtn;
    
    @FindBy(xpath = ProductSelectorPageXpath.PROCEEDWITHOUTPREFILLBTN)
    public WebElement proceedWithoutPrefillBtn;
    
    @FindBy(xpath = ProductSelectorPageXpath.ADDNEW)
    public WebElement addNew;
    
}
