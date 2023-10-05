# REST-API-TestSuite
The "API TestSuite" project is designed to be a comprehensive testing suite for testing and validating Application Programming Interfaces (APIs). 




## API Reference


### POST request
#### Headers

```http
  POST https://bfhldevapigw.healthrx.co.in/automation-campus/create/user
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `roll-number`| `number` | **Required**. Roll number of participant |
| `Content-Type`| `json` | **Required**. "application/json" |




#### Body

```http
  POST https://bfhldevapigw.healthrx.co.in/automation-campus/create/user
```


| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `Firstname`| `string` | **Required**. First name of Student |
| `Lastname`| `string` | **Required**. Last name of Student |
| `Phonenumber`| `number` | **Required**. Phonenumber of student |
| `emailId`| `string` | **Required**. emailId of student |
