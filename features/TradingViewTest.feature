@Test
Feature: TradingView Test

Scenario: Automate finding currency exchange rates in https://www.tradingview.com 
Given I navigate to "https://www.tradingview.com/markets/currencies/rates-all/"
And sign in to the application
When I select "Asia" tab
Then I should find the last exchange rate for the currency pair "GBPJPY"
And I should find the last three exchange rates of currency pair "GBPJPY" for a period of 1 minute
And I sign out of the application