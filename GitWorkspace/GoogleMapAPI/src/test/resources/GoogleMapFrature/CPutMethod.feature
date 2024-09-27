Feature: End to End Google Map API Testing

Scenario Outline: Verifiaction of put Method
	Given Verify "<module>" user should able to access the "<Base_URL>"
	And Verify "<module>" user should able to access the Query Parameters "<qpvalue>"
	And Verify whether it accepts place ID in the parameter
	When Verify "<module>" user should able to access the post "<method>"
	Then Verify whether the updated payload is same as response body
	And Verify "<module>" whether "<key>" is present in the response body
	
Examples: 
	| Base_URL						| qpvalue	| method| value	| key	| module|
	| https://rahulshettyacademy.com| qaclick123| PUT	| OK	| msg	| put	|
	| https://rahulshettyacademy.cm	| qaclick444| GET	| OK	| mms	| put	|