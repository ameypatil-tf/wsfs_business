package com.cztffa.xpath.consumer;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Product {

  PREMIERCHECKING("PremierChecking",
      "//*[text() = 'Premier Checking']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  PREMIERCERTIFICATE("PremierCertificate",
      "//*[text() = 'Premier Certificate']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  PREMIERSAVING("PremierSaving",
      "//*[text() = 'Premier Savings']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  BASICSAVINGS("BasicSavings",
      "//*[text() = 'Basic Savings']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  BASICCHECKING("BasicChecking",
      "//*[text() = 'Basic Checking']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  CHECKINGSILVER("CheckingSilver",
      "//*[text() = 'Checking - Silver']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  PERSONALCHECKING("PersonalChecking",
      "//*[text() = 'Personal Checking']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  SAVINGPLATINUM("SavingPlatinum",
      "//*[text() = 'Saving - Platinum']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]"),
  DOCUSIGNPREMIERCHECKING("DocusignPremierChecking",
      "//*[text() = 'Docusign Premier Checking']/parent::div[@class='unit-text-wrapper text-center pt-4']/following-sibling::div[@class='unit-text-wrapper text-center mt-4 product-btn-wrapper']/descendant::button[contains(text(), 'Add to Cart')]");

  private String name;

  private String xpath;

  public static Product getByName(String name) {

      if (name.equalsIgnoreCase("PremierChecking")) {
      return PREMIERCHECKING;}
      else if (name.equalsIgnoreCase("PremierCertificate")) {
      return PREMIERCERTIFICATE;}
      else if (name.equalsIgnoreCase("PremierSaving")) {
      return PREMIERSAVING;}
      else if (name.equalsIgnoreCase("BasicSavings")) {
      return BASICSAVINGS;}
      else if (name.equalsIgnoreCase("BasicChecking")) {
      return BASICCHECKING;}
      else if (name.equalsIgnoreCase("CheckingSilver")) {
      return CHECKINGSILVER;}
      else if (name.equalsIgnoreCase("PersonalChecking")) {
      return PERSONALCHECKING;}
      else if (name.equalsIgnoreCase("SavingPlatinum")) {
      return SAVINGPLATINUM;}
      else if (name.equalsIgnoreCase("DocusignPremierChecking")) {
      return DOCUSIGNPREMIERCHECKING;}
      return null;
  }
}
