Feature: End to End Google Map API Testing

Scenario Outline: Verifiaction of get Method
	Given Verify "<module>" user should able to access the "<Base_URL>"
	And Verify "<module>" user should able to access the Query Parameters "<qpvalue>"
	When Verify "<module>" user should able to access the post "<method>"
	Then veriefy "<module>" user can get the details of location using placeId.
	And Verify "<module>" status is "<value>"
	And Verify "<module>" whether "<key>" is present in the response body
	
Examples: 
	| Base_URL						| qpvalue	| method| value	| key		| module|
	| https://rahulshettyacademy.com| qaclick123| GET	| 40	| location	| get	|
	| https://rahulshettyacademy.cm	| qaclick444| PUT	| 40	| vecation	| get	|