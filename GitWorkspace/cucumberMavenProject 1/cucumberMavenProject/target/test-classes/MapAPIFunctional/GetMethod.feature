Feature: End to End Test for  Testing Google Map API

Scenario Outline: Verification of Get method 
	Given Verify user should able to access the Base-URL 
	Given Verify user should not able to access the Base-URL 
	When Verify user should able to access Get Method
	When Verify user should not be able to access Post GET request with invalid http Method
	Given Verify user should able to access the Base-URL with resource path and Query Parameters
	Given Verify user should not pass invalid key
	Then veriefy user can get the details of location using placeId.
	Then verify user is able to get the location details without giving placeId.
	Then Verify status is "OK"
	Then Verify whether key location is present in the response body
	