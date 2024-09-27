Feature: End to End Test for Testing Google Map API for Post Method

Scenario Outline: Verify user should able to access the Base-URL

	Given User calls the "<Base_URL>"
	When User calls With "<method>" method
	Then The API calls get success with status "<value>"
	
 Examples: 
 		| Base_URL						| method| value	|
 		| https://rahulshettyacademy.com| POST	| OK	|
	
	
Scenario Outline: Verify user should able to access Post Method

	Given User calls the "<Base_URL>"
	When User calls With "<method>" method
	Then The API calls get success with status "<value>"
	
 Examples: 
 		| Base_URL						| method| value	|
 		| https://rahulshettyacademy.com| POST	| OK	|
 		
 		
 Scenario Outline: Verify user should not be able to access Add place request with invalid HTTP GET Method

	Given User calls the "<Base_URL>"
	When User calls With "<method>" method
	Then The API calls get success with status "<value>"
	
 Examples: 
 		| Base_URL						| method| value	|
 		| https://rahulshettyacademy.com| GET	| OK	|