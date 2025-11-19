package com.cztffa.xpath.business;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum Product {

  NONPROFITCHECKING("NonProfitChecking",
      "//tfcz-product-card[.//div[text()='Non-Profit Checking']]//button[contains(text(), 'Add to Cart')]"),
  SMALLBUSINESSCHECKING("SmallBusinessChecking",
                                 "//tfcz-product-card[.//div[text()='Small Business Checking']]//button[contains(text(), 'Add to Cart')]"),
  SMALLBUSINESSPERMIERCHECKING("SmallBusinessPremierChecking",
                                        "//tfcz-product-card[.//div[text()='Small Business Premier Checking']]//button[contains(text(), 'Add to Cart')]"),
  NONPROFITINTERESTCHECKING("NonProfitInterestChecking",
                                     "//tfcz-product-card[.//div[text()='Non-Profit Interest Checking']]//button[contains(text(), 'Add to Cart')]"),
  SMALLBUSINESSMONEYMARKET("SmallBusinessMoneyMarket",
                                    "//tfcz-product-card[.//div[text()='Small Business Money Market']]//button[contains(text(), 'Add to Cart')]"),
  COMMUNITYMONEYMARKET("CommunityMoneyMarket",
                                "//tfcz-product-card[.//div[text()='Community Money Market']]//button[contains(text(), 'Add to Cart')]"),
  SMALLBUSINESSCORESAVINGS("SmallBusinessCoreSavings",
                                    "//tfcz-product-card[.//div[text()='Small Business Core Savings']]//button[contains(text(), 'Add to Cart')]"),
  COMMUNITYCORESAVINGS("CommunityCoreSavings","//tfcz-product-card[.//div[text()='Community Core Savings']]//button[contains(text(), 'Add to Cart')]");




  private String name;

  private String xpath;

  public static Product getByName(String name) {

      if (name.equalsIgnoreCase("NonProfitChecking")) {
      return NONPROFITCHECKING;}
      else if (name.equalsIgnoreCase("SmallBusinessChecking")) {
          return SMALLBUSINESSCHECKING;}
      else if (name.equalsIgnoreCase("SmallBusinessPremierChecking")) {
          return SMALLBUSINESSPERMIERCHECKING;}
      else if (name.equalsIgnoreCase("NonProfitInterestChecking")) {
          return NONPROFITINTERESTCHECKING;}
      else if (name.equalsIgnoreCase("SmallBusinessMoneyMarket")) {
          return SMALLBUSINESSMONEYMARKET;}
      else if (name.equalsIgnoreCase("CommunityMoneyMarket")) {
          return COMMUNITYMONEYMARKET;}
      else if (name.equalsIgnoreCase("SmallBusinessCoreSavings")) {
          return SMALLBUSINESSCORESAVINGS;}
      else if (name.equalsIgnoreCase("CommunityCoreSavings")) {
          return COMMUNITYCORESAVINGS;}

      return null;
  }
}
