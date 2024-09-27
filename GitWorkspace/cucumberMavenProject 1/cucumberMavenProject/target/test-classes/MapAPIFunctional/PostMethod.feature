Feature: End to End Test for  Testing Google Map API

Scenario Outline: Verification of post method 
	Given Verify user should able to access the "<Base_URL>"
	Given Verify whether its accepting location key and value
	Given Verify user should able to accept the payload
	Given Verify user should able to text the "<phone_number>"
	When Verify user should able to access "<Post>" Method
	Then Verify place_id is generated
	Then Verify status is "<value>"

Examples:
	| Base_URL| phone_number| Post| value|