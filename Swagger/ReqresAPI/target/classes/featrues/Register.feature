Feature: Registration

Scenario Outline: Verify user can able to Register Successfull.

	Given "post_reg" with "<email>" and "<password>"
	When User calls "post_reg" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| email						| password	| method	| status	|
		| rachel.howell@reqres.in	| Kanna12	| POST		| 200		|
		| eve.holt@reqres.in		| Google4	| POST		| 200		|
		

Scenario Outline: Verify user should not able to Register Successfull using wrong email id.

	Given "post_reg" with "<email>" and "<password>"
	When User calls "post_reg" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| email						| password	| method	| status	|
		| Kanna@gamil.com			| Kanna12	| POST		| 400		|
		| google.search@reqres.in	| Google4	| POST		| 400		|
		
	
Scenario Outline: Verify user should to Login Successfull.

	Given "post_login" with "<email>" and "<password>"
	When User calls "post_login" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| email						| password	| method	| status	|
		| eve.holt@reqres.in		| Google4	| POST		| 200		|
		| rachel.howell@reqres.in	| Kanna12	| POST		| 200		|
		
		
Scenario Outline: Verify user id able to create Employee.

	Given "post_user" with "<name>" and "<job>"
	When User calls "post_user" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| name				| job			| method	| status	|
		| Durgaprasad		| Analyst		| POST		| 201		|
		| Raghava			| Dance Master	| POST		| 201		|
	
		
Scenario Outline: Verify User able to Get Employee Details by calling id

	Given "get_user_by_id" details by using <id>
	When User calls "get_user_by_id" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| method	| status	| id	|
		| GET		| 200		| 2		|
		| GET		| 200		| 4		|
	
		
Scenario Outline: Verify User able to Get Employee Details by calling pages

	Given "get_user_by_page" details by using <page>
	When User calls "get_user_by_page" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| method	| status	| page	|
		| GET		| 200		| 2		|
		| GET		| 200		| 4		|
		
		
Scenario Outline: Verify User able to Get Employee Details by calling pages

	Given "get_user_by_page" details by using <page>
	When User calls "get_user_by_page" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| method	| status	| page	|
		| GET		| 200		| 2		|
		| GET		| 200		| 4		|
			
			
Scenario Outline: Verify user able to Update the Employee details.

	Given "put_user" the "<name>" and "<job>" using <id>
	When User calls "put_user" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| name		| job		| method	| status	| id	|
		| Prasad	| Analyst	| PUT		| 200		| 2		|
		| Kanna		| Master	| PUT		| 200		| 4		|
			
			
Scenario Outline: Verify user is able to Update the Employee details with patch.

	Given "patch_use" the "<name>" and "<job>" using <id>
	When User calls "patch_use" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| name		| job		| method	| status	| id	|
		| Chinna	| Manager	| PATCH		| 200		| 2		|
		| Kittu		| Artist	| PATCH		| 200		| 4		|
			
			
Scenario Outline: Verify user is able to Delete the Employee details.

	Given "delete_user" details by using <id>
	When User calls "delete_user" With "<method>" method
	Then The API calls get success with status code "<status>"

Examples:
         
		| method	| status	| id	|
		| DELETE	| 204		| 2		|
		| DELETE	| 204		| 4		|
		