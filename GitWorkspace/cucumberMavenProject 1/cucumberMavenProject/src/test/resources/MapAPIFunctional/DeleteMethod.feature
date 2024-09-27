Feature: End to End Test for  Testing Google Map API

Scenario Outline: Verification of Delete method
	Given Verify user should able to access the Base-URL 
	Given Verify user should not able to access the Base-URL 
	When Verify user should able to access Delete Method
	When Verify user should not be able to access Post DELETE request with invalid http Method
	Then Verify whether user is able to get    "status": "OK"
	Then Verify whether "status"key is present in the response
	Given Verify whether it accept valid payload
	Given Verify whether it should not accept invalid payload
	Given Verify whether it accept valid key in the parameter
	Given Verify whether it should not accept invalid key in the parameter