<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>User Account Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            margin: 0;
            padding: 0;
        }

        header {
            background-color: #007BFF;
            color: #fff;
            padding: 10px 0;
            text-align: center;
        }

        .container {
            max-width: 800px;
            margin: 0 auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .welcome {
            font-size: 24px;
            text-align: center;
            margin-bottom: 20px;
        }

        #but {
            text-align: right;
            margin-top: 10px;
        }

        .button {
            background-color: #007BFF;
            color: #fff;
            border: none;
            padding: 10px 20px;
            border-radius: 5px;
            cursor: pointer;
        }

        .button:hover {
            background-color: #0056b3;
        }

        nav {
            margin-top: 20px;
            text-align: center;
        }

        nav a {
            text-decoration: none;
            margin: 0 10px;
            color: #007BFF;
            font-weight: bold;
        }

        nav a:hover {
            text-decoration: underline;
        }
    </style>
</head>
<body>
    <header>
        <h1>Library Management</h1>
    </header>
    <div class="container">
        <div class="welcome">
            <% String user = (String)session.getAttribute("user"); %>
            Welcome <b><%= user %></b>
        </div>
        <div id="but">
            <input type="button" class="button" name="logout" value="Logout" onclick="window.location='login.jsp'">
        </div>
        <nav>
            <a href="AccountDetails.jsp">Account Details</a>
            <a href="Search.jsp">Search / Issue</a>
            <a href="Return.jsp">Return</a>
            <a href="History.jsp">History</a>
        </nav>
    </div>
    
</body>
</html>
