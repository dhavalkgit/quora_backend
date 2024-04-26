# Quora Backend
## Overview 
This API provides functionalities for Q&A platform that allows user to ask questions, 
answer them, comment on answer, and engage through likes and follows, 
while organizing content via topic tags.

## User have the following functionality 
 * user create account or register 
 * user post or update question 
 * search question by title 
 * write answer of question 
 * comment on answer or replay on comment 
 * like answer, question or comment 
 * follow other users

## Some API Routes 
* To register user use following route 
```
request url: http://localhost:8080/api/v1/users/ 
```
Json body for request
```
{
    "email":"dhaval@gamil.com",
    "name":"Dhaval",
    "about":"Hi, I am backend developer!"
}
```
* To add or post question use following routs 
```
request url: http://localhost:8080/api/v1/questions/
```
Json body for request 
```
{
    "title":"Road map to become java backend developer?",
    "topic":["Backend development","Programming"],
    "userId": 1
}
```
    