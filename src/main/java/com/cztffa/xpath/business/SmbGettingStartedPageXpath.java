package com.cztffa.xpath.business;

public class SmbGettingStartedPageXpath {
    public static final String OFFERCODE = "//tf-input[@t-model='Submission__c.Applications__r.0.PromotionCode__c']//input";
    public static final String FIRSTNAME = "//tf-input[@t-model='Party__r.FirstName__c']//input";
    public static final String LASTNAME = "//tf-input[@t-model='Party__r.LastName__c']//input";
    public static final String PHONENUMBER = "//tf-phone[@t-model='Party__r.PrimaryPhone__c']//input";
    public static final String PERSONALEMAIL = "//tf-email[@t-model='Party__r.PrimaryEmail__c']//input";
    public static final String ACCEPTPOLICY = "//tf-checkbox[@t-model='Accepted__c']//input";
    public static final String STARTAPPLICATIONBUTTON = "//button[normalize-space()='Start Application']";
    public static final String EXTRADISC = "//label[contains(text(),'I acknowledge and understand the information above.')]";
    public static final String PROCEEDBUTTON = "//button[normalize-space()='Proceed']";
}
