<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<title>Customer Login Form</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f4f4f4;
            margin: 0;
            padding: 0;
        }

        h2 {
            text-align: center;
        }

        form {
            max-width: 400px;
            margin: 0 auto;
            padding: 20px;
            background: #fff;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 5px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"],
        select {
            width: 90%;
            padding: 10px;
            margin-bottom: 15px;
            border: 1px solid #ccc;
            border-radius: 4px;
            background-color: #f8f8f8;
        }

        select {
            height: 36px;
        }

        input[type="submit"] {
            background: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            cursor: pointer;
            border-radius: 4px;
        }

        input[type="submit"]:hover {
            background: #0056b3;
        }

        /* Additional styles */
        input[type="text"]:focus,
        input[type="password"]:focus,
        select:focus {
            border: 1px solid #007BFF;
            outline: none;
        }

        label[for="status"] {
            color: #007BFF;
        }

        #activatedOn::placeholder {
            color: #aaa;
        }
    </style>
</head>
<body>
    <h2>Customer Login Form</h2>
    <form action="CustomerLoginServlet" method="post">

        <label for="firstName">First Name:</label>
        <input type="text" id="firstName" name="firstName">

        <label for="lastName">Last Name:</label>
        <input type="text" id="lastName" name="lastName">

        <label for="userName">Username:</label>
        <input type="text" id="userName" name="userName">

        <label for="password">Password:</label>
        <input type="password" id="password" name="password">

        <label for="email">Email:</label>
        <input type="text" id="email" name="email">

        <label for="phoneNo">Phone Number:</label>
        <input type="text" id="phoneNo" name="phoneNo">

        <input type="submit" value="SignUp">
    </form>

</body>
</html>