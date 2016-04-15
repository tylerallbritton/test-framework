#Simple UI Link Click Feature
Feature: Link

@example
Scenario: Testing a link click
Given I am on the Galvanize Home Page
When I click the "Grow Your Startup" link
Then The page title should be "More than Coworking - Join Our Community - Galvanize"