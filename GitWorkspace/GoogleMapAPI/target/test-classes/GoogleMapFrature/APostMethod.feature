Feature: End to End Google Map API Testing

Scenario Outline: Verifiaction of post Method
	Given Verify "<module>" user should able to access the "<Base_URL>"
	And Verify "<module>" user should able to accept the Payload
	And Verify "<module>" user should able to text the "<Phone_number>"
	And Verify "<module>" whether its accepting location key and value
	When Verify "<module>" user should able to access the post "<method>"
	Then Verify "<module>" place_id is generated
	And Verify "<module>" status is "<value>"
	
Examples: 
	| Base_URL						| Phone_number	| method| value	| module|
	| https://rahulshettyacademy.com| 9879674584	| POST	| OK	| post	|
	| https://rahulshettyacademy.cm	| 98fhg74584	| GET	| OK	| post	|