package com.cztffa.xpath.consumer;

public class AccountDetailsPageXpath {
    public static final String ORANGEVISADEBITCARD = "//tf-select-button[@class='col tf-select-button']//img[contains(@src,'OrangeKnoxvilleMapDebit')]";
    public static final String LINKEDOVERDRAFTTOGGLEBUTTON = "//label[contains(text(), 'Linked Overdraft Protection')]/ancestor::div[@class='tf-checkbox-layout tf-left-label']//input";
    public static final String ADDLINKEDOVERDRAFTPROTECTION = "//button[@class='btn btn-outline-primary']";
    public static final String OVERDRAFTCOVERAGENOCHECKBOX = "//div[contains(text(),'Overdraft Coverage')]//ancestor::div[@class='row ng-star-inserted']//tf-radio//input[@value='No']";
    public static final String ACCEPTCHECKBOX = "//tf-checkbox[@t-model='Accepted__c']//input";
    public static final String ACCOUNTDETAILSNEXTBUTTON = "//button[@class='btn btn-primary float-end tf-step-action-next']";
    public static final String CHECKINGSECTION = "//h2[contains(text(),'Premier Checking')]";
    public static final String BASICSAVINGSSECTION = "//h2[contains(text(),'Basic Savings')]";
    public static final String CERTIFICATESECTION = "//h2[contains(text(),'Premier Certificate')]";
    public static final String CERTIFICATETERMDRP = "//tf-dropdown[@t-model='TermCode__c']/descendant::input";
    public static final String CERTIFICATETERMVALUE = "//div[@class='dropdown-item ng-star-inserted'][contains(text(),'12')]";
    public static final String CERTIFICATEAMOUNT = "//div[@class='input-group tf-input-group']//input[@type='text' and @inputmode='decimal' and starts-with(@aria-labelledby, 'Amount')]";
    public static final String CLOSEBUTTON = "//button[contains(text(),'Continue')]";
    public static final String ADDDEBITCARDBUTTON = "//button[contains(text(),' Add  Debit Card ')]";
    public static final String BENEFICIARYRELASHIONSHIPAPPLY = "//div[@class='dropdown-item'][contains(text(),'Spouse')]";
    public static final String CANCELBUTTON = "//button[contains(text(),'cancel']";
    public static final String SAVEBUTTON = "//button[contains(text(),'save']";
}
