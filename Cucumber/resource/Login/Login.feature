Feature: validate login api and check accesstoken using the accesstoken getallusers and fetch one user and delete



@Login
Scenario: validate login and fetch the accesstoken
Given Login API along with payload
When Execute login with resource "/user/login" and provide me accesstoken
Then executed successfully with status code 200
And verify Login message

#@getalluser
#Scenario: validate getalluser
#Given Login successfully with accessToken.
#When getalluser "/user" and fetch the userid
#Then verify status code 200
#
#@deleteuser
#Scenario: Validate delete
#Given Login successfully with accessToken.
#When deleteuser "/user/"
#Then verify message 