Feature: Registration
@Regression @Register
Scenario Outline: Verify user can able to Register Successfull.

	Given "Register" with "<email>" and "<password>"
	When User calls "Register" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| email						| password	| method	| status	|
		| rachel.howell@reqres.in	| Kanna12	| POST		| 200		|
		| eve.holt@reqres.in		| Google4	| POST		| 200		|
		
@Regression @Register
Scenario Outline: Verify user should not able to Register Successfull using wrong email id.

	Given "Register" with "<email>" and "<password>"
	When User calls "Register" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| email						| password	| method	| status	|
		| Kanna@gamil.com			| Kanna12	| POST		| 400		|
		| google.search@reqres.in	| Google4	| POST		| 400		|
		
@Regression @Login
Scenario Outline: Verify user should to Login Successfull.

	Given "Login" with "<email>" and "<password>"
	When User calls "Login" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| email						| password	| method	| status	|
		| eve.holt@reqres.in		| Google4	| POST		| 200		|
		| rachel.howell@reqres.in	| Kanna12	| POST		| 200		|
		
@Regression @CreateUser	
Scenario Outline: Verify user id able to create Employee.

	Given "Create_User" with "<name>" and "<job>"
	When User calls "Create_User" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| name				| job			| method	| status	|
		| Durgaprasad		| Analyst		| POST		| 201		|
		| Raghava			| Dance Master	| POST		| 201		|
	
@Regression @GetUser
Scenario Outline: Verify User able to Get Employee Details by calling id

	Given "Get_User" details by using <id>
	When User calls "Get_User" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| method	| status	| id	|
		| GET		| 200		| 2		|
		| GET		| 200		| 4		|
	
@Regression @GetUserPage
Scenario Outline: Verify User able to Get Employee Details by calling pages

	Given "Get_User_page" details by using <page>
	When User calls "Get_User_page" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| method	| status	| page	|
		| GET		| 200		| 2		|
		| GET		| 200		| 4		|
			
@Regression @UpdateUser			
Scenario Outline: Verify user able to Update the Employee details.

	Given "Update_User" the "<name>" and "<job>" using <id>
	When User calls "Update_User" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| name		| job		| method	| status	| id	|
		| Prasad	| Analyst	| PUT		| 200		| 2		|
		| Kanna		| Master	| PUT		| 200		| 4		|
			
@Regression @UpdateUserPatch		
Scenario Outline: Verify user is able to Update the Employee details with patch.

	Given "Update_User_Patch" the "<name>" and "<job>" using <id>
	When User calls "Update_User_Patch" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| name		| job		| method	| status	| id	|
		| Chinna	| Manager	| PATCH		| 200		| 2		|
		| Kittu		| Artist	| PATCH		| 200		| 4		|
			
@Regression @DeleteUser			
Scenario Outline: Verify user is able to Delete the Employee details.

	Given "delete_user" details by using <id>
	When User calls "delete_user" With "<method>" method
	Then The API calls get success with status code <status>

Examples:
         
		| method	| status	| id	|
		| DELETE	| 204		| 2		|
		| DELETE	| 204		| 4		|