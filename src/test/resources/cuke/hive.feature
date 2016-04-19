#Simple set of Hive query features
Feature: Hive
@example
Scenario: Pulling list of Hive tables
Given I can connect to Hive
When I request a list of tables
Then I get a list of 21 tables