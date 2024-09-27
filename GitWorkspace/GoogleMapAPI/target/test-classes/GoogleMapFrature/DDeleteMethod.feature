Feature: End to End Google Map API Testing

Scenario Outline: Verifiaction of delete Method
	Given Verify "<module>" user should able to access the "<Base_URL>"
	And Verify "<module>" user should able to accept the Payload
	And Verify "<module>" user should able to access the Query Parameters "<qpvalue>"
	When Verify "<module>" user should able to access the post "<method>"
	And Verify "<module>" status is "<value>"
	And Verify "<module>" whether "<key>" is present in the response body
	
Examples: 
	| Base_URL						| qpvalue	| method| value	| key	| module|
	| https://rahulshettyacademy.com| qaclick123| DELETE| OK	| status| delete|
	| https://rahulshettyacademy.cm	| qaclick444| PUT	| OK	| thumba| delete|