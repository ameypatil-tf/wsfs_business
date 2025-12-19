package com.cztffa.xpath.business;

public class SmbReviewPageXpath {
    public static final String DISCLOSURECHECKBOX = "//tf-checkbox[@t-model='Accepted__c']//input";
    public static final String BRACCEPT = "//button[normalize-space()='Accept']";
    public static final String SUBMITBUTTON = "//button[normalize-space()='Submit Application']";
    public static final String MODALCHECKBOX = "//span[contains(text(),'I agree to use electronic records and signatures.')]";
    public static final String MODALCNT = "//button[normalize-space()='Continue']";
}
