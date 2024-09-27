Feature: End to End Test for  Testing Maps API

Scenario Outline: Verify user should able to access the Base-URL 
	Given User calls the "<Base_URL>"
	When User calls With "<method>" method
	Then The API calls get success with status "<value>"
	
 Examples: 
 		| Base_URL						| method| value	|
 		| https://rahulshettyacademy.com| POST	| OK	|
 		| https://rahulshettyacademy.com| GET	| OK	|
 		| https://rahulshettyacademy.com| PUT	| OK	|
 		| https://rahulshettyacademy.com| DELETE| OK	|
 		

Scenario Outline: Verify user should able to access the Base-URL 
	Given User calls the "<Base_URL>"
	When User calls With "<method>" method
	Then The API calls get success with status "<value>"
	
 Examples: 
 		| Base_URL						| method| value	|
 		| https://rahulshettyacademy.co	| POST	| OK	|
 		| https://rahulshettyacademy.co	| GET	| OK	|
 		| https://rahulshettyacademy.co	| PUT	| OK	|
 		| https://rahulshettyacademy.co	| DELETE| OK	|
 		
 		
Scenario Outline: Verify user should able to access Post Method 
	Given User calls the "<Base_URL>"
	When User calls With "<method>" method
	Then The API calls get success with status "<value>"
	
 Examples: 
 		| Base_URL						| method| value	|
 		| https://rahulshettyacademy.com| POST	| OK	|
 		| https://rahulshettyacademy.com| GET	| OK	|
 		| https://rahulshettyacademy.com| PUT	| OK	|
 		| https://rahulshettyacademy.com| DELETE| OK	|
 		
 		
Scenario Outline: Verify user should not be able to access Add place request with invalid HTTP Method 
	Given User calls the "<Base_URL>"
	When User calls With "<method>" method
	Then The API calls get success with status "<value>"
	
 Examples: 
 		| Base_URL						| method| value	|
 		| https://rahulshettyacademy.com| POST	| OK	|
 		| https://rahulshettyacademy.com| GET	| OK	|
 		| https://rahulshettyacademy.com| PUT	| OK	|
 		| https://rahulshettyacademy.com| DELETE| OK	|