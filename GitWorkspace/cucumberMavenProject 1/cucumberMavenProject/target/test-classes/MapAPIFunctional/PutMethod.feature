Feature: End to End Test for  Testing Google Map API

Scenario Outline: Verification of Put method
	Given Verify user should able to access the Base-URL 
	Given Verify user should not able to access the Base-URL 
	When Verify user should able to access Put Method
	When Verify user should not be able to access Post PUT request with invalid http Method
	Given Verify whether it accepts place Id which we are getting from POST response
	Given Verify whether it accepts invalid place ID in the parameter
	Then Verify whether the updated payload is same as response body
	Given Verify whether it accepts invalid key in the parameter
	Given Verify whether it accepts valid key in the parameter
	Then Verify whether key location is present in the response body