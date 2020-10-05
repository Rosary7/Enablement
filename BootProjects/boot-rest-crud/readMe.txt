

1) Create / POST
http://localhost:8080/api/v1/createEmployee
I/P:
{
    "id": 2,
    "firstName": "ggg",
    "lastName": "ggg",
    "emailId": "test@test.coM"
}

2) get  all records / GET
http://localhost:8080/api/v1/getAllEmployees

http://localhost:8080//api/user/api/v1/getAllEmployees

3) get one record / GET
http://localhost:8080/api/v1/getEmployeeById/1


Actuator:
Steps to implement & use Actuator:
a)	Add dependency in maven :   spring-boot-starter-actuator
b)	Add following  in application.properties  
	management.endpoints.enabled-by-default=true
	management.endpoints.web.exposure.include=health,beans,env,mappings
c)	Hit below in browser -
	http://localhost:8080/actuator/health  (To see health info)
		Output:   {"status":"UP"}
	http://localhost:8080/actuator/beans   (To get beans info)
	http://localhost:8080/actuator/mappings   (To get mappings info)


Spring Security:
1) To configure spring security ,extend SpringSecurityConfiguration and override two methods configure(AuthenticationManagerBuilder auth) 
and configure(AuthenticationManagerBuilder auth)
2) In above methods,for the authentication, we have added two users’ root and test. Here root is a user as well as admin,  whereas, the test is just a user.
3) Test:
HTTP GET can be called by a user (test and root), Whereas, HTTP POST, PUT, and DELETE can only be called by admin.

Scenario – 1:
In Postman ,When no authorization   is provided and GET request made (http://localhost:8080/api/v1/getAllEmployees)
O/P:
{
    "timestamp": "2020-10-01T04:28:35.926+00:00",
    "status": 401,
    "error": "Unauthorized",
    "message": "Unauthorized",
    "path": "/api/user/api/v1/getAllEmployees"
}

Scenario -2 When ‘test’ credential provided
In Postman ,When no authorization (Postman -> Authorization ->Basic Auth -> test/test123)  is provided  and GET request made (http://localhost:8080/api/v1/getAllEmployees)
O/P:
[
    {
        "id": 1,
        "firstName": "nn1",
        "lastName": "nn1",
        "emailId": "nn@gmai1l.com"
    },
    
}


